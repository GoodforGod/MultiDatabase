package com.univ.db.service.modelbased.multilevel;

import com.univ.db.model.dao.mongo.DiscountOfferCached;
import com.univ.db.model.dao.redis.DiscountOfferHot;
import com.univ.db.service.modelbased.impl.prime.RedisService;
import com.univ.db.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Service
public class DiscountHotService extends RedisService<DiscountOfferHot> {

    @Qualifier("discount")
    private RedisTemplate<String, DiscountOfferHot> redisTemplate;

    private final DiscountCachedService cachedService;

    private final Map<String, LocalDateTime> desctroyPolicyMap = new HashMap<>();

    @Autowired
    public DiscountHotService(RedisTemplate<String, DiscountOfferHot> redisTemplate, DiscountCachedService cachedService) {
        super(redisTemplate);
        this.redisTemplate = redisTemplate;
        this.cachedService = cachedService;
    }

    private void updatePolicy(String id) {
        LocalDateTime policy = desctroyPolicyMap.putIfAbsent(id, LocalDateTime.now());

        if(policy != null)
            desctroyPolicyMap.replace(id, LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 5000)
    private void policyScheduler() {
        for(Map.Entry<String, LocalDateTime> policy : desctroyPolicyMap.entrySet()) {
            if (LocalDateTime.from(policy.getValue()).until(LocalDateTime.now(), ChronoUnit.MINUTES) > 5)
                super.deleteById(policy.getKey());
        }
    }

    @Override
    public Optional<DiscountOfferHot> getById(String id) {
        Optional<DiscountOfferHot> offerHot = super.getById(id);

        if(!offerHot.isPresent()) {
            Optional<DiscountOfferCached> offerCached = cachedService.getById(id);

            if(offerCached.isPresent()) {
                updatePolicy(id);
                return Optional.of(Converter.toDAO(offerCached.get()));
            }
            else
                return Optional.empty();
        }
        else
            return offerHot;
    }

    @Transactional
    @Override
    public Optional<DiscountOfferHot> save(DiscountOfferHot itemRecent) {
        try {
            redisTemplate.opsForValue().set(itemRecent.getCode().toString(), itemRecent);
            cachedService.save(Converter.toDTO(itemRecent));
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + itemRecent.getCode());
        }
        return Optional.of(itemRecent);
    }

    @Transactional
    @Override
    public Optional<DiscountOfferHot> delete(DiscountOfferHot itemRecent) {
        try {
            deleteById(itemRecent.getCode().toString());
            cachedService.deleteById(itemRecent.getCode().toString());
            desctroyPolicyMap.remove(itemRecent.getCode().toString());
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + itemRecent.getCode());
        }
        return Optional.of(itemRecent);
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
        cachedService.deleteById(s);
        desctroyPolicyMap.remove(s);
    }
}

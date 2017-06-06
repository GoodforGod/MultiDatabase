package com.univ.db.service.modelbased.multilevel;

import com.univ.db.model.dao.mongo.DiscountOfferCached;
import com.univ.db.model.dao.sql.DiscountOfferStore;
import com.univ.db.repo.DiscountCachedRepository;
import com.univ.db.service.modelbased.impl.prime.MongoService;
import com.univ.db.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DiscountCachedService extends MongoService<DiscountOfferCached> {

    private final DiscountCachedRepository repository;

    private final DiscountStoreService storeService;

    private final Map<String, LocalDateTime> desctroyPolicyMap = new HashMap<>();

    @Autowired
    public DiscountCachedService(DiscountCachedRepository repository, DiscountStoreService storeService) {
        super(repository);
        this.repository = repository;
        this.storeService = storeService;
    }

    private void updatePolicy(String id) {
        LocalDateTime policy = desctroyPolicyMap.putIfAbsent(id, LocalDateTime.now());

        if(policy != null)
            desctroyPolicyMap.replace(id, LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 5000)
    void policyScheduler() {
        for(Map.Entry<String, LocalDateTime> policy : desctroyPolicyMap.entrySet()) {
            if (LocalDateTime.from(policy.getValue()).until(LocalDateTime.now(), ChronoUnit.MINUTES) > 10)
                super.deleteById(policy.getKey());
        }
    }

    @Override
    public Optional<DiscountOfferCached> getById(String id) {
        Optional<DiscountOfferCached> offerCached = super.getById(id);

        if(!offerCached.isPresent()) {
            Optional<DiscountOfferStore> offerStore = storeService.getById(Long.valueOf(id));

            if(offerStore.isPresent()) {
                updatePolicy(id);
                save(Converter.toDAO(offerStore.get()));
                return Optional.of(Converter.toDAO(offerStore.get()));
            }
            else
                return Optional.empty();
        }
        else
            return offerCached;
    }

    @Transactional
    @Override
    public Optional<DiscountOfferCached> save(DiscountOfferCached discountOfferCached) {
        super.save(discountOfferCached);
        storeService.save(Converter.toDTO(discountOfferCached));
        return Optional.of(discountOfferCached);
    }

    @Transactional
    @Override
    public Optional<DiscountOfferCached> delete(DiscountOfferCached discountOfferCached) {
        super.delete(discountOfferCached);
        storeService.deleteById(discountOfferCached.getCode());
        desctroyPolicyMap.remove(discountOfferCached.getCode().toString());
        return Optional.of(discountOfferCached);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        super.deleteById(id);
        storeService.deleteById(Long.valueOf(id));
        desctroyPolicyMap.remove(id);
    }
}

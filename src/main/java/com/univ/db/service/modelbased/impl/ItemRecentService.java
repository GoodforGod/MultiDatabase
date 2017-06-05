package com.univ.db.service.modelbased.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.redis.ItemRecent;
import com.univ.db.service.modelbased.IItemRecentService;
import com.univ.db.service.modelbased.impl.prime.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class ItemRecentService extends RedisService<ItemRecent> implements IItemRecentService {

    private final RedisTemplate<String, ItemRecent> redisTemplate;

    @Autowired
    public ItemRecentService(RedisTemplate<String, ItemRecent> redisTemplate) {
        super(redisTemplate);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<Long> count() {
        return super.count();
    }

    @Override
    public Optional<List<ItemRecent>> getAll() {
        List<ItemRecent> itemRecents = new ArrayList<>();

        try {
            for(String s : redisTemplate.keys("*"))
                getById(s).ifPresent(itemRecents::add);
        }
        catch (Exception e){
            logger.warn(e.getMessage());
        }

        return Optional.of(itemRecents);
    }

    @Override
    public Optional<ItemRecent> getById(String id) {
        try {
            return Optional.of(redisTemplate.opsForValue().get(id));
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + id);
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public Optional<ItemRecent> save(ItemRecent itemRecent) {
        try {
            redisTemplate.opsForValue().set(itemRecent.getCatalogCode().toString(), itemRecent);
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + itemRecent.getCatalogCode());
        }
        return Optional.of(itemRecent);
    }

    @Transactional
    @Override
    public Optional<ItemRecent> delete(ItemRecent itemRecent) {
        try {
            deleteById(itemRecent.getCatalogCode().toString());
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + itemRecent.getCatalogCode());
        }
       return Optional.of(itemRecent);
    }

    @Transactional
    @Override
    public void deleteById(String id) {
        try {
            redisTemplate.opsForValue().getOperations().delete(id);
        }
        catch (Exception e) {
            logger.warn(e.getMessage() + " : " + id);
        }
    }

    @Transactional
    public void deleteAll() {
        try {
            for (String s : redisTemplate.keys("*"))
                redisTemplate.delete(s);
        }
        catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }
}

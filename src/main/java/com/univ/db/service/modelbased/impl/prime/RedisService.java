package com.univ.db.service.modelbased.impl.prime;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class RedisService<T> extends PrimeUtilService<T, String> implements ICRUDService<T, String> {

    protected RedisTemplate<String, T> redisTemplate;

    public RedisService(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Optional<Long> count() {
        Optional<List<T>> all = getAll();
        if(all.isPresent())
            return Optional.of((long) all.get().size());
        return Optional.empty();
    }

    @Override
    public Optional<List<T>> getAll() {
        List<T> models = new ArrayList<>();

        try {
            for(String s : redisTemplate.keys("*"))
                getById(s).ifPresent(models::add);
        }
        catch (Exception e){
            logger.warn(e.getMessage());
        }

        return Optional.of(models);
    }

    @Override
    public Optional<T> getById(String id) {
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
    public Optional<T> save(T t) {
        return null;
    }

    @Transactional
    @Override
    public Optional<T> delete(T t) {
        return null;
    }

    @Transactional
    @Override
    public void deleteById(String s) {

    }
}

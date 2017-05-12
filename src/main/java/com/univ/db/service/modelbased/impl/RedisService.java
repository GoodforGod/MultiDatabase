package com.univ.db.service.modelbased.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.modelbased.ICRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class RedisService<T> implements ICRUDService<T, String> {

    protected final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    protected boolean invalidModel(T t) {
        if(t == null) {
            LOGGER.warn("NULL MODEL");
            return true;
        }
        return false;
    }

    protected boolean invalidId(Long id) {
        if(id == null) {
            LOGGER.warn("NULL ID");
            return true;
        }
        return false;
    }

    @Override
    public Optional<Long> count() {
        return Optional.empty();
    }

    @Override
    public Optional<List<T>> getAll() {
        return null;
    }

    @Override
    public Optional<T> getById(String s) {
        return null;
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

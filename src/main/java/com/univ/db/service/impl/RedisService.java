package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.ICRUDService;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class RedisService<T> implements ICRUDService<T, Long> {

    @Override
    public Optional<List<T>> getAll() {
        return null;
    }

    @Override
    public Optional<T> getById(Long aLong) {
        return null;
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T delete(T t) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}

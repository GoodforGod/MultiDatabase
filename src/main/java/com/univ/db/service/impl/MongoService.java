package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.ICRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class MongoService<T> implements ICRUDService<T, String> {

    private MongoRepository<T, String> primeRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(MongoService.class);

    public MongoService(MongoRepository<T, String> mongoRepository) {
        this.primeRepository = mongoRepository;
    }

    protected boolean invalidModel(T t) {
        if(t == null) {
            LOGGER.warn("NULL MODEL");
            return true;
        }
        return false;
    }

    protected boolean invalidId(String id) {
        if(id == null || id.trim().isEmpty()) {
            LOGGER.warn("NULL ID");
            return true;
        }
        return false;
    }

    @Override
    public Optional<Long> count() {
        return Optional.of(primeRepository.count());
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    @Override
    public Optional<T> getById(String id) {
        if(invalidId(id))
            return Optional.empty();

        return Optional.of(primeRepository.findOne(id));
    }

    @Override
    public Optional<T> save(T t) {
        if(invalidModel(t))
            return Optional.empty();

        return Optional.of(primeRepository.save(t));
    }

    @Override
    public Optional<T> delete(T t) {
        if(invalidModel(t))
            return Optional.empty();

        primeRepository.delete(t);
        return Optional.of(t);
    }

    @Override
    public void deleteById(String id) {
        if(invalidId(id))
            return;

        primeRepository.delete(id);
    }
}

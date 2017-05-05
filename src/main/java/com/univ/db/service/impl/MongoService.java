package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.ICRUDService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class MongoService<T> implements ICRUDService<T, String> {

    private MongoRepository<T, String> primeRepository;

    public MongoService(MongoRepository<T, String> mongoRepository) {
        this.primeRepository = mongoRepository;
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    @Override
    public Optional<T> getById(String id) {
        return Optional.of(primeRepository.findOne(id));
    }

    @Override
    public Optional<T> save(T t) {
        return Optional.of(primeRepository.save(t));
    }

    @Override
    public T delete(T t) {
        primeRepository.delete(t);
        return t;
    }

    @Override
    public void deleteById(String id) {
        primeRepository.delete(id);
    }
}

package com.univ.db.service.modelbased.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.modelbased.ICRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class JpaService<T> implements ICRUDService<T, Long>{

    private JpaRepository<T, Long> primeRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(JpaService.class);

    public JpaService(JpaRepository<T, Long> jpaRepository) {
        this.primeRepository = jpaRepository;
    }

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
        return Optional.of(primeRepository.count());
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    @Override
    public Optional<T> getById(Long id) {
        if(invalidId(id))
            return Optional.empty();

        return Optional.of(primeRepository.findOne(id));
    }

    @Transactional
    @Override
    public Optional<T> save(T t) {
        if(invalidModel(t))
            return Optional.empty();

        return Optional.of(primeRepository.save(t));
    }

    @Transactional
    @Override
    public Optional<T> delete(T t) {
        if(invalidModel(t))
            return Optional.empty();

        primeRepository.delete(t);
        return Optional.of(t);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if(invalidId(id))
            return;

        primeRepository.delete(id);
    }
}

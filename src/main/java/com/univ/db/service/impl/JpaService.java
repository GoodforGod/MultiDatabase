package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.ICRUDService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class JpaService<T> implements ICRUDService<T, Long>{

    private JpaRepository<T, Long> primeRepository;

    public JpaService(JpaRepository<T, Long> jpaRepository) {
        this.primeRepository = jpaRepository;
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(primeRepository.findAll());
    }

    @Override
    public Optional<T> getById(Long id) {
        return Optional.of(primeRepository.findOne(id));
    }

    @Override
    public T save(T t) {
        return primeRepository.save(t);
    }

    @Override
    public T delete(T t) {
        primeRepository.delete(t);
        return t;
    }

    @Override
    public void deleteById(Long id) {
        primeRepository.delete(id);
    }
}

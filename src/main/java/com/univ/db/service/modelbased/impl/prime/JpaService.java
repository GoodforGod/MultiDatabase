package com.univ.db.service.modelbased.impl.prime;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class JpaService<T, ID extends Serializable> extends PrimeUtilService<T, ID> implements ICRUDService<T, ID>{

    private JpaRepository<T, ID> primeRepository;

    public JpaService(JpaRepository<T, ID> jpaRepository) {
        this.primeRepository = jpaRepository;
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
    public Optional<T> getById(ID id) {
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
    public void deleteById(ID id) {
        if(invalidId(id))
            return;

        primeRepository.delete(id);
    }
}

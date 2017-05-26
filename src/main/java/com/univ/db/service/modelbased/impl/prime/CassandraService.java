package com.univ.db.service.modelbased.impl.prime;

import com.google.common.collect.Lists;
import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public class CassandraService<T> extends PrimeUtilService<T, String> implements ICRUDService<T, String> {

    private CrudRepository<T, String> primeRepository;

    public CassandraService(CrudRepository<T, String> primeRepository) {
        this.primeRepository = primeRepository;
    }

    @Override
    public Optional<Long> count() {
        return Optional.of(primeRepository.count());
    }

    @Override
    public Optional<List<T>> getAll() {
        return Optional.of(Lists.newArrayList(primeRepository.findAll()));
    }

    @Override
    public Optional<T> getById(String uuid) {
        return Optional.of(primeRepository.findOne(uuid));
    }

    @Transactional
    @Override
    public Optional<T> save(T t) {
        return Optional.of(primeRepository.save(t));
    }

    @Transactional
    @Override
    public Optional<T> delete(T t) {
        primeRepository.delete(t);
        return Optional.of(t);
    }

    @Transactional
    @Override
    public void deleteById(String uuid) {
        primeRepository.delete(uuid);
    }
}

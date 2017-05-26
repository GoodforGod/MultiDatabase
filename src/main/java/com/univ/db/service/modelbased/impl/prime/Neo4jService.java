package com.univ.db.service.modelbased.impl.prime;

import com.google.common.collect.Lists;
import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public class Neo4jService<T> extends PrimeUtilService<T, Long> implements ICRUDService<T, Long> {

    protected GraphRepository<T> primeRepository;

    public Neo4jService(GraphRepository<T> primeRepository) {
        this.primeRepository = primeRepository;
    }

    @Override
    public Optional<Long> count() {
        return Optional.of(primeRepository.count());
    }

    @Override
    public Optional<List<T>> getAll() {
        Iterable<T> t = primeRepository.findAll();
        return (t == null)
                ? Optional.empty()
                : Optional.of(Lists.newArrayList(t));
    }

    @Override
    public Optional<T> getById(Long aLong) {
        T t = primeRepository.findOne(aLong);
        return (t == null)
                ? Optional.empty()
                : Optional.of(t);
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
    public void deleteById(Long aLong) {
        primeRepository.delete(aLong);
    }
}

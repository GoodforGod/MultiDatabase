package com.univ.db.service.modelbased.impl.prime;

import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.neo4j.repository.GraphRepository;

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
        return null;
    }

    @Override
    public Optional<List<T>> getAll() {
        return null;
    }

    @Override
    public Optional<T> getById(Long aLong) {
        return null;
    }

    @Override
    public Optional<T> save(T t) {
        return null;
    }

    @Override
    public Optional<T> delete(T t) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}

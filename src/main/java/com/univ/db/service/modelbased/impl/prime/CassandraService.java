package com.univ.db.service.modelbased.impl.prime;

import com.google.common.collect.Lists;
import com.univ.db.service.modelbased.ICRUDService;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public class CassandraService<T> extends PrimeUtilService<T, MapId> implements ICRUDService<T, MapId> {

    private CassandraRepository<T> primeRepository;

    public CassandraService(CassandraRepository<T> primeRepository) {
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
    public Optional<T> getById(MapId uuid) {
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
    public void deleteById(MapId uuid) {
        primeRepository.delete(uuid);
    }
}

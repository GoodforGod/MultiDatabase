package com.univ.db.service.modelbased;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface ICRUDService<T, ID> {

    Optional<Long> count();

    Optional<List<T>> getAll();

    Optional<T> getById(ID id);

    Optional<T> save(T t);

    Optional<T> delete(T t);

    void deleteById(ID id);
}

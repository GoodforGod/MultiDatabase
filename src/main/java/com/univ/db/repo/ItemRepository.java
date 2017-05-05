package com.univ.db.repo;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Default Comment
 */
public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findByCatalogCode(Integer code);
}

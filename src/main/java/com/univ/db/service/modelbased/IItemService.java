package com.univ.db.service.modelbased;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.mongo.Item;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IItemService<ID> {
    Optional<Item> getByCatalogCode(Long id);
}

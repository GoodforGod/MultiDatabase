package com.univ.db.service;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Item;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IItemRecentService {
    Optional<Item> getByCatalogCode(Long id);
}

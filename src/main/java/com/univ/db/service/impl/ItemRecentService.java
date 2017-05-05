package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.ItemRecent;
import com.univ.db.repo.ItemRecentRepository;
import com.univ.db.service.IItemRecentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default Comment
 */
public class ItemRecentService extends RedisService<ItemRecent> implements IItemRecentService {

    private final ItemRecentRepository repository;

    @Autowired
    public ItemRecentService(ItemRecentRepository repository) {
        this.repository = repository;
    }
}

package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Item;
import com.univ.db.repo.ItemRepository;
import com.univ.db.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default Comment
 */
@Service
public class ItemService extends MongoService<Item> implements IItemService<String> {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

package com.univ.db.service.modelbased.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.mongo.Item;
import com.univ.db.repo.ItemRepository;
import com.univ.db.service.modelbased.IItemService;
import com.univ.db.service.modelbased.impl.prime.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Item> getByCatalogCode(Long id) {
        return repository.findByCatalogCode(id);
    }
}

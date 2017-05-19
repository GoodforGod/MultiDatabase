package com.univ.db.service.modelbased.impl;

import com.univ.db.model.dao.Seller;
import com.univ.db.repo.SellerRepository;
import com.univ.db.service.modelbased.ISellerService;
import com.univ.db.service.modelbased.impl.prime.Neo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
@Service
public class SellerService extends Neo4jService<Seller> implements ISellerService {

    private final SellerRepository repository;

    @Autowired
    public SellerService(SellerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<List<Seller>> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Seller> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}

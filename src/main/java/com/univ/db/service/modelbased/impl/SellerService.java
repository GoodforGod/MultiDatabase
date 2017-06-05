package com.univ.db.service.modelbased.impl;

import com.univ.db.model.dao.neo4j.Seller;
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
        List<Seller> s = repository.findByName(name);
        return (s == null)
                ? Optional.empty()
                : Optional.of(s);
    }

    @Override
    public Optional<Seller> getByEmail(String email) {
        Seller s = repository.findByEmail(email);
        return (s == null)
                ? Optional.empty()
                : Optional.of(s);
    }
}

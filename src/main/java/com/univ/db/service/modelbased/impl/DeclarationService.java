package com.univ.db.service.modelbased.impl;

import com.univ.db.model.dao.Declaration;
import com.univ.db.repo.DeclarationRepository;
import com.univ.db.service.modelbased.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.CassandraRepository;
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
public class DeclarationService extends CassandraService<Declaration> implements IDeclarationService {

    private final DeclarationRepository repository;

    @Autowired
    public DeclarationService(CassandraRepository<Declaration> primeRepository, DeclarationRepository repository) {
        super(primeRepository);
        this.repository = repository;
    }

    @Override
    public Optional<Declaration> getByCatalogCode(Long catalog_code) {
        return repository.findByCatalogCode(catalog_code);
    }

    @Override
    public Optional<List<Declaration>> getByAccepted(String accepted) {
        return repository.findByAccepted(accepted);
    }

    @Override
    public Optional<List<Declaration>> getBySupplier(String supplier) {
        return repository.findBySupplier(supplier);
    }
}

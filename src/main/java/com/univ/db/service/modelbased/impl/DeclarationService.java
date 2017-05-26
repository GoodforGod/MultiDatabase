package com.univ.db.service.modelbased.impl;

import com.univ.db.model.dao.Declaration;
import com.univ.db.repo.DeclarationRepository;
import com.univ.db.service.modelbased.IDeclarationService;
import com.univ.db.service.modelbased.impl.prime.CassandraService;
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
public class DeclarationService extends CassandraService<Declaration> implements IDeclarationService {

    private final DeclarationRepository repository;

    @Autowired
    public DeclarationService(DeclarationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Declaration> getByCatalogCode(Long catalog_code) {
        return repository.findByCatalogCode(catalog_code.toString());
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

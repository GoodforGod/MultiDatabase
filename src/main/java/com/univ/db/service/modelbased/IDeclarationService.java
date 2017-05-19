package com.univ.db.service.modelbased;

import com.univ.db.model.dao.Declaration;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public interface IDeclarationService {
    Optional<Declaration> getByCatalogCode(Long catalog_code);

    Optional<List<Declaration>> getByAccepted(String accepted);

    Optional<List<Declaration>> getBySupplier(String supplier);
}

package com.univ.db.repo;

import com.univ.db.model.dao.Declaration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
@Repository
public interface DeclarationRepository extends CrudRepository<Declaration, String> {

    Optional<Declaration> findByCatalogCode(String catalogCode);

    Optional<List<Declaration>> findByAccepted(String accepted);

    Optional<List<Declaration>> findBySupplier(String supplier);
}

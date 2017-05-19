package com.univ.db.repo;

import com.univ.db.model.dao.Declaration;
import org.springframework.data.cassandra.repository.CassandraRepository;
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
public interface DeclarationRepository extends CassandraRepository<Declaration> {

    Optional<Declaration> findByCatalogCode(Long catalog_code);

    Optional<List<Declaration>> findByAccepted(String accepted);

    Optional<List<Declaration>> findBySupplier(String supplier);
}

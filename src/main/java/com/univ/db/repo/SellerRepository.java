package com.univ.db.repo;

import com.univ.db.model.dao.Seller;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public interface SellerRepository extends GraphRepository<Seller> {

    Optional<List<Seller>> findByName(String name);

    Optional<Seller> findByEmail(String email);
}

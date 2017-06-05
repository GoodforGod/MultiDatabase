package com.univ.db.repo;

import com.univ.db.model.dao.neo4j.Seller;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
@Repository
public interface SellerRepository extends GraphRepository<Seller> {

    List<Seller> findByName(@Param("name") String name);

    Seller findByEmail(@Param("email") String email);
}

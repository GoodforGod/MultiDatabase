package com.univ.db.repo;

import com.univ.db.model.dao.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public interface CustomerRepository extends GraphRepository<Customer> {

    Optional<List<Customer>> findByName(String name);

    Optional<List<Customer>> findByEmail(String email);
}

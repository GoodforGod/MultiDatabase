package com.univ.db.repo;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAddress_Country(String country);

    Optional<User> findByEmail(String email);

    Optional<List<User>> findByName(String name);
}

package com.univ.db.repo;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Default Comment
 */
public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByEmail(String email);
}

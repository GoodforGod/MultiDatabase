package com.univ.db.repo;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Default Comment
 */
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    Optional<UserAddress> findByUserCredential_Email(String email);
}

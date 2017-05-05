package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.UserAddress;
import com.univ.db.repo.UserAddressRepository;
import com.univ.db.service.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default Comment
 */
public class UserAddressService extends JpaService<UserAddress> implements IUserAddressService {

    private final UserAddressRepository repository;

    @Autowired
    public UserAddressService(UserAddressRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

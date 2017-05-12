package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.User;
import com.univ.db.repo.UserRepository;
import com.univ.db.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default Comment
 */
@Service
public class UserService extends JpaService<User> implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

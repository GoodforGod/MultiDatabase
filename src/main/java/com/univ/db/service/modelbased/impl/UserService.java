package com.univ.db.service.modelbased.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.User;
import com.univ.db.repo.UserRepository;
import com.univ.db.service.modelbased.IUserService;
import com.univ.db.service.modelbased.impl.prime.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class UserService extends JpaService<User, Long> implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<List<User>> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}

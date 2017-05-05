package com.univ.db.service.impl;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.UserCredential;
import com.univ.db.repo.UserCredentialRepository;
import com.univ.db.service.IUserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default Comment
 */
public class UserCredentialService extends JpaService<UserCredential> implements IUserCredentialService {

    private final UserCredentialRepository repository;

    @Autowired
    public UserCredentialService(UserCredentialRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

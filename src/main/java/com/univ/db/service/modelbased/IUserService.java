package com.univ.db.service.modelbased;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.User;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IUserService {
    Optional<List<User>> getByName(String name);

    Optional<User> getByEmail(String email);
}

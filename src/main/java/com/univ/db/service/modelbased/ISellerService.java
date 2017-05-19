package com.univ.db.service.modelbased;

import com.univ.db.model.dao.Seller;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public interface ISellerService {
    Optional<List<Seller>> getByName(String name);

    Optional<Seller> getByEmail(String email);
}

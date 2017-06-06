package com.univ.db.service.modelbased.multilevel;

import com.univ.db.model.dao.sql.DiscountOfferStore;
import com.univ.db.repo.DiscountStoreRepository;
import com.univ.db.service.modelbased.impl.prime.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Service
public class DiscountStoreService extends JpaService<DiscountOfferStore, Long> {

    private final DiscountStoreRepository repository;

    @Autowired
    public DiscountStoreService(DiscountStoreRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

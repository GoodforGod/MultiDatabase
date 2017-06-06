package com.univ.db.repo;

import com.univ.db.model.dao.sql.DiscountOfferStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Repository
public interface DiscountStoreRepository extends JpaRepository<DiscountOfferStore, Long> {

}

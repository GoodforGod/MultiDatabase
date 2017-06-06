package com.univ.db.repo;

import com.univ.db.model.dao.mongo.DiscountOfferCached;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Repository
public interface DiscountCachedRepository extends MongoRepository<DiscountOfferCached, String> {

}

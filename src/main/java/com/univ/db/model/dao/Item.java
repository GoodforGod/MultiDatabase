package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.util.MongoResolver;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Default Comment
 */
@Document(collection = MongoResolver.ITEMS_COLLECTION)
public class Item {

}

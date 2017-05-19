package com.univ.db.service.modelbased.impl.prime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
class PrimeUtilService<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(PrimeUtilService.class);

    protected boolean invalidModel(T t) {
        if(t == null) {
            logger.warn("NULL MODEL");
            return true;
        }
        return false;
    }

    protected boolean invalidId(ID id) {
        if(id == null) {
            logger.warn("NULL ID");
            return true;
        }
        return false;
    }
}

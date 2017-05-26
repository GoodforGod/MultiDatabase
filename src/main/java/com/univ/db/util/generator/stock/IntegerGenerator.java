package com.univ.db.util.generator.stock;

import com.univ.db.util.generator.IGenerator;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class IntegerGenerator implements IGenerator<Integer> {

    @Override
    public Integer generate() {
        return ThreadLocalRandom.current().nextInt();
    }
}

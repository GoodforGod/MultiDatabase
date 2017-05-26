package com.univ.db.util.generator.stock;

import io.netty.util.internal.ThreadLocalRandom;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class PassGenerator extends StringGenerator {

    @Override
    public String generate() {
        int passLength = ThreadLocalRandom.current().nextInt(5, 31);
        return super.generate().substring(0, passLength);
    }
}

package com.univ.db.util.generator.stock;

import com.univ.db.util.generator.IGenerator;

import static io.netty.util.internal.ThreadLocalRandom.current;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class PhoneGenerator implements IGenerator<String> {

    @Override
    public String generate() {
        return current().nextInt(10)
                + "("
                + current().nextInt(100, 999)
                + ")"
                + current().nextInt(100, 999)
                + current().nextInt(1000, 9999);
    }
}

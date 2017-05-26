package com.univ.db.util.generator.stock;

import com.univ.db.util.generator.IGenerator;

import java.util.UUID;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class StringGenerator implements IGenerator<String> {

    @Override
    public String generate() {
        return UUID.randomUUID().toString().replace('-', ' ');
    }
}

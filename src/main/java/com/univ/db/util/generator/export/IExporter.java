package com.univ.db.util.generator.export;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public interface IExporter<T> {
    public String export(T t);
}

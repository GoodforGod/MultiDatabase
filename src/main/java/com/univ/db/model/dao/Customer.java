package com.univ.db.model.dao;

import org.neo4j.ogm.annotation.GraphId;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public class Customer {

    public static final Customer EMPTY = new Customer();

    @GraphId
    private Long id;

    private String name;
    private String email;

    private Customer() {

    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //</editor-fold>

}

package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import java.util.Date;

/**
 * Default Comment
 */
public class Manufacture {

    public static final Manufacture EMPTY = new Manufacture();

    private String firm;
    private String country;
    private String city;
    private Date created;

    public Manufacture() {
        this.firm = "";
        this.country = "";
        this.city = "";
        this.created = new Date();
    }

    public Manufacture(String firm, String country, String city, Date created) {
        this.firm = firm;
        this.country = country;
        this.city = city;
        this.created = created;
    }

    //<editor-fold desc="GetterAndSetter">

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //</editor-fold>
}

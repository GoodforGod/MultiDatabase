package com.univ.db.model.dao.mongo;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import io.dummymaker.annotation.GenLocalDateTime;
import io.dummymaker.annotation.GenName;
import io.dummymaker.annotation.prime.GenForceExport;

import java.util.Date;

/**
 * Default Comment
 */
public class Manufacture {

    public static final Manufacture EMPTY = new Manufacture();

    @GenName
    private String firm;

    @GenForceExport
    private String country = "Russia";

    @GenForceExport
    private String city = "Saint-Petersbirg";

    @GenLocalDateTime
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

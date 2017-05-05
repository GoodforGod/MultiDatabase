package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import java.time.LocalDateTime;

/**
 * Default Comment
 */
public class Manufacture {

    public static final Manufacture EMPTY = new Manufacture();

    private String firm;
    private LocalDateTime designed;
    private String country;
    private String city;
    private LocalDateTime warranty;

    public Manufacture() {
        this.firm = "";
        this.designed = LocalDateTime.MIN;
        this.country = "";
        this.city = "";
        this.warranty = LocalDateTime.MIN;
    }

    public Manufacture(String firm, LocalDateTime designed, String country, String city, LocalDateTime warranty) {
        this.firm = firm;
        this.designed = designed;
        this.country = country;
        this.city = city;
        this.warranty = warranty;
    }

    //<editor-fold desc="GetterAndSetter">

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public LocalDateTime getDesigned() {
        return designed;
    }

    public void setDesigned(LocalDateTime designed) {
        this.designed = designed;
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

    public LocalDateTime getWarranty() {
        return warranty;
    }

    public void setWarranty(LocalDateTime warranty) {
        this.warranty = warranty;
    }
    //</editor-fold>
}

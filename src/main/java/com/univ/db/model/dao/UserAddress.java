package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.util.JpaResolver;

import javax.persistence.*;

/**
 * Default Comment
 */
@Entity
@Table(name = JpaResolver.TABLE_USER_ADDRESSES, schema = JpaResolver.SCHEMA)
public class UserAddress {

    public static final UserAddress EMPTY = new UserAddress();

    private String address;
    private String country;
    private String city;
    private Integer index;
    private UserCredential credential;

    public UserAddress() {
        this.address = "";
        this.country = "";
        this.city = "";
        this.index = -1;
    }

    public UserAddress(String country, String city, String address, Integer index) {
        this.index = index;
        this.country = country;
        this.city = city;
        this.address = address;
    }

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    public UserCredential getCredential() {
        return credential;
    }

    //<editor-fold desc="GetterAndSetter">

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }
    //</editor-fold>
}

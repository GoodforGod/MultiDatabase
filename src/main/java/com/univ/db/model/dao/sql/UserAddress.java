package com.univ.db.model.dao.sql;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.util.JpaResolver;
import io.dummymaker.annotation.GenInteger;
import io.dummymaker.annotation.GenString;
import io.dummymaker.annotation.prime.GenForceExport;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Default Comment
 */
@Entity
@Table(name = JpaResolver.TABLE_USER_ADDRESSES, schema = JpaResolver.SCHEMA)
public class UserAddress implements Serializable {

    public static final UserAddress EMPTY = new UserAddress();

    @GenString
    private String address;

    @GenForceExport
    private String country = "Russia";

    @GenForceExport
    private String city = "Saint-Petersburg";

    @GenInteger
    private Integer index;
    private User user;

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
    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }
    //</editor-fold>
}

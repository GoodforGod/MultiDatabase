package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

/**
 * Default Comment
 */
public class UserAddressDTO {
    public static final UserAddressDTO EMPTY = new UserAddressDTO();

    private String address;
    private String country;
    private String city;
    private Integer index;

    public UserAddressDTO() {
        this.address = "";
        this.country = "";
        this.city = "";
        this.index = -1;
    }

    public UserAddressDTO(String country, String city, String address, Integer index) {
        this.index = index;
        this.country = country;
        this.city = city;
        this.address = address;
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
    //</editor-fold>
}

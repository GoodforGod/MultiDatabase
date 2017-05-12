package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import java.io.Serializable;

/**
 * Default Comment
 */
public class ItemRecent implements Serializable {

    public static final ItemRecent EMPTY = new ItemRecent();

    private Long catalogCode;
    private String title;
    private String descr;
    private String specs;

    private ItemRecent() {
        this.catalogCode = 0L;
        this.title = "";
        this.descr = "";
        this.specs = "";
    }

    public ItemRecent(Long catalogCode, String title, String descr, String specs) {
        this.catalogCode = catalogCode;
        this.title = title;
        this.descr = descr;
        this.specs = specs;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(Long catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "ItemRecent{" +
                "catalogCode=" + catalogCode +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", specs='" + specs + '\'' +
                '}';
    }
}

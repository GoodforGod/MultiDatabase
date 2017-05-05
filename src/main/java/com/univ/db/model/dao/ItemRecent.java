package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

/**
 * Default Comment
 */
public class ItemRecent {

    public static final ItemRecent EMPTY = new ItemRecent();

    private Integer catalogCode;
    private String title;
    private String descr;
    private String specs;

    public ItemRecent() {
        this.catalogCode = -1;
        this.title = "";
        this.descr = "";
        this.specs = "";
    }

    public ItemRecent(Integer catalogCode, String title, String descr, String specs) {
        this.catalogCode = catalogCode;
        this.title = title;
        this.descr = descr;
        this.specs = specs;
    }

    //<editor-fold desc="GetterAndSetter">

    public Integer getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(Integer catalogCode) {
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
}

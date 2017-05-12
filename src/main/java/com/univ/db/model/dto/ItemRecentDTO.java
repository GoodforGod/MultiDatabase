package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

/**
 * Default Comment
 */
public class ItemRecentDTO {
    public static final ItemRecentDTO EMPTY = new ItemRecentDTO();

    private Long catalogCode;
    private String title;
    private String descr;
    private String specs;

    private ItemRecentDTO() {
        this.catalogCode = 0L;
        this.title = "";
        this.descr = "";
        this.specs = "";
    }

    public ItemRecentDTO(Long catalogCode, String title, String descr, String specs) {
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
}

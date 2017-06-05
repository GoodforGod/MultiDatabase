package com.univ.db.model.dao.redis;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dto.ItemDTO;
import io.dummymaker.annotation.GenLong;
import io.dummymaker.annotation.GenName;
import io.dummymaker.annotation.GenPass;
import io.dummymaker.annotation.GenString;

import java.io.Serializable;

/**
 * Default Comment
 */
public class ItemRecent implements Serializable {

    public static final ItemRecent EMPTY = new ItemRecent();

    @GenLong
    private Long catalogCode;

    @GenName
    private String title;

    @GenString
    private String descr;

    @GenPass
    private String specs;

    public ItemRecent() {
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

    public ItemRecent(ItemDTO item) {
        this.catalogCode = item.getCatalogCode();
        this.title = item.getTitle();
        this.descr = item.getDescr();
        this.specs = item.getSpecs().toString();
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

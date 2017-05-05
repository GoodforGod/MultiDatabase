package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Manufacture;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 */
public class ItemDTO {
    public static final ItemDTO EMPTY = new ItemDTO();

    private String id;
    private Integer catalogCode;
    private String title;
    private String descr;
    private List<String> specs;
    private List<String> tags;
    private Manufacture manufacture;

    public ItemDTO() {
        this.id = "-1";
        this.catalogCode = -1;
        this.title = "";
        this.descr = "";
        this.specs = Collections.emptyList();
        this.tags = Collections.emptyList();
        this.manufacture = new Manufacture();
    }

    public ItemDTO(Integer catalogCode, String title, String descr,
                List<String> specs, List<String> tags, Manufacture manufacture) {
        this.catalogCode = catalogCode;
        this.title = title;
        this.descr = descr;
        this.specs = specs;
        this.tags = tags;
        this.manufacture = manufacture;
    }

    public ItemDTO(Integer catalogCode, String title, String descr,
                   List<String> specs, List<String> tags,
                   String firm, LocalDateTime designed, String country, String city, LocalDateTime warranty) {
        this.catalogCode = catalogCode;
        this.title = title;
        this.descr = descr;
        this.specs = specs;
        this.tags = tags;
        this.manufacture = new Manufacture(firm, designed, country, city, warranty);
    }

    //<editor-fold desc="GetterAndSetter">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<String> getSpecs() {
        return specs;
    }

    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }
    //</editor-fold>
}

package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.mongo.Manufacture;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Default Comment
 */
public class ItemDTO {
    public static final ItemDTO EMPTY = new ItemDTO();

    private String id;
    private Long catalogCode;
    private String title;
    private String descr;
    private List<String> specs;
    private List<String> tags;
    private Manufacture manufacture;

    private ItemDTO() {
        this.id = "0";
        this.catalogCode = 0L;
        this.title = "";
        this.descr = "";
        this.specs = Collections.emptyList();
        this.tags = Collections.emptyList();
        this.manufacture = new Manufacture();
    }

    public ItemDTO(String id, Long catalogCode, String title, String descr,
                List<String> specs, List<String> tags, Manufacture manufacture) {
        this.id = id;
        this.catalogCode = catalogCode;
        this.title = title;
        this.descr = descr;
        this.specs = specs;
        this.tags = tags;
        this.manufacture = manufacture;
    }

    public ItemDTO(String id, Long catalogCode, String title, String descr,
                   List<String> specs, List<String> tags,
                   String firm, LocalDateTime designed, String country, String city) {
        this(id, catalogCode, title, descr, specs, tags, new Manufacture(firm, country, city, new Date(designed.getYear(), designed.getMonthValue(), designed.getDayOfMonth(), designed.getHour(), designed.getMinute())));
    }

    //<editor-fold desc="GetterAndSetter">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

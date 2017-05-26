package com.univ.db.model.dao;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */

@Table(value = "declarations")
public class Declaration {

    public static final Declaration EMPTY = new Declaration();

    @PrimaryKey
    private String catalogCode;

    private String data;
    private String accepted;
    private String supplier;

    private Declaration() {
        this.data = LocalDateTime.now().toString();
    }

    public Declaration(Long catalogCode, String accepted, String supplier) {
        this();
        this.catalogCode = String.valueOf(catalogCode);
        this.accepted = accepted;
        this.supplier = supplier;
    }

    //<editor-fold desc="GetterAndSetter">

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(Long catalogCode) {
        this.catalogCode = String.valueOf(catalogCode);
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    //</editor-fold>

}

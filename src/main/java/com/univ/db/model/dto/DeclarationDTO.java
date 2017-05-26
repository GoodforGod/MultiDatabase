package com.univ.db.model.dto;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class DeclarationDTO {

    public static final DeclarationDTO EMPTY = new DeclarationDTO();

    private Long catalogCode;

    private String date;
    private String accepted;
    private String supplier;

    public DeclarationDTO() {
        this.catalogCode = 0L;
    }

    public DeclarationDTO(Long catalogCode, String date, String accepted, String supplier) {
        this.catalogCode = catalogCode;
        this.date = date;
        this.accepted = accepted;
        this.supplier = supplier;
    }

    public Long getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(Long catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}

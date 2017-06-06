package com.univ.db.model.dao.redis;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
public class DiscountOfferHot implements Serializable {

    private String title;

    private Long code;

    private String description;

    private String endDate;

    public DiscountOfferHot() {
        this.title = "";
        this.description = "";
        this.code = 0L;
        this.endDate = LocalDateTime.MIN.toString();
    }

    public DiscountOfferHot(String title, Long code, String description, String endDate) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

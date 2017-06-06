package com.univ.db.model.dao.sql;

import com.univ.db.util.JpaResolver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Entity
@Table(name = JpaResolver.TABLE_DISCOUNT, schema = JpaResolver.SCHEMA)
public class DiscountOfferStore {

    private String title;

    @Id
    @Column(name = "code", nullable = false, unique = true)
    private Long code;

    private String description;

    private String endDate;

    public DiscountOfferStore() {
        this.title = "";
        this.description = "";
        this.code = 0L;
        this.endDate = LocalDateTime.MIN.toString();
    }

    public DiscountOfferStore(String title, Long code, String description, String endDate) {
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

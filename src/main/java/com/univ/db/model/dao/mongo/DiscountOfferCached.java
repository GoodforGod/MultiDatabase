package com.univ.db.model.dao.mongo;

import com.univ.db.util.MongoResolver;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author GoodforGod (Anton Kurako)
 * @since 06.06.2017
 */
@Document(collection = MongoResolver.DISCOUNT)
public class DiscountOfferCached {
    private String title;

    @Id
    private String code;

    private String description;

    private String endDate;

    public DiscountOfferCached() {
        this.title = "";
        this.description = "";
        this.code = String.valueOf(0L);
        this.endDate = LocalDateTime.MIN.toString();
    }

    public DiscountOfferCached(String title, Long code, String description, String endDate) {
        this.title = title;
        this.code = code.toString();
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
        return Long.valueOf(code);
    }

    public void setCode(Long code) {
        this.code = code.toString();
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

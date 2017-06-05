package com.univ.db.model.dao.neo4j;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.dummymaker.annotation.GenLocalDateTime;
import io.dummymaker.annotation.GenString;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
@RelationshipEntity(type = "ORDERED")
public class Order implements Serializable {

    public static final Order EMPTY = new Order();

    @GraphId
    private Long id;

    @GenLocalDateTime
    private String placedOn;

    @GenString
    private String item;

    @EndNode
    @JsonIgnore
    private Seller seller;

    public Order() {
        this.placedOn = LocalDateTime.now().toString();
    }

    public Order(Seller seller, String item) {
        this();
        this.seller = seller;
        this.item = item;
    }

    public Order(String placedOn, String item) {
        this.placedOn = placedOn;
        this.item = item;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getPlacedOn() {
        return placedOn;
    }

    public void setPlacedOn(String placedOn) {
        this.placedOn = placedOn;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id != null ? id.equals(order.id) : order.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", placedOn='" + placedOn + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}

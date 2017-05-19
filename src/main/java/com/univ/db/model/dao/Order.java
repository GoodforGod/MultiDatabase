package com.univ.db.model.dao;

import org.neo4j.ogm.annotation.GraphId;

import java.time.LocalDateTime;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
public class Order {

    @GraphId
    private Long id;

    private Long customerId;
    private String placedOn;
    private String item;

    private Order() {
        this.placedOn = LocalDateTime.now().toString();
    }

    public Order(Long customerId, String item) {
        this();
        this.customerId = customerId;
        this.item = item;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
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
                ", customerId=" + customerId +
                ", placedOn='" + placedOn + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}

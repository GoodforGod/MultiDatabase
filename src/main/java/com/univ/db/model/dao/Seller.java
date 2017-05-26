package com.univ.db.model.dao;

import org.hibernate.validator.constraints.Email;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 19.05.2017
 */
@NodeEntity
public class Seller implements Serializable {

    public static final Seller EMPTY = new Seller();

    @GraphId
    private Long id;

    private String name;

    @Email
    private String email;

    @Relationship(type="ORDERED")
    private Set<Order> orders = new HashSet<>();

    private Seller() {

    }

    public Seller(Long id, String name, String email) {
//        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}

package com.univ.db.model.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class SellerDTO {

    public static final SellerDTO EMPTY = new SellerDTO();

    private Long id;

    private String name;
    private String email;

    private Set<OrderDTO> orders = new HashSet<>();

    public SellerDTO() {
        this.id = 0L;
    }

    public SellerDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public SellerDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public SellerDTO(Long id, String name, String email, Set<OrderDTO> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public Set<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDTO> orders) {
        this.orders = orders;
    }
}

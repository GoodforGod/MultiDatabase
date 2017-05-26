package com.univ.db.model.dto;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 26.05.2017
 */
public class OrderDTO {

    public static final OrderDTO EMPTY = new OrderDTO();

    private Long id;

    private String placedOn;
    private String item;

    public OrderDTO() {
        this.id = 0L;
    }

    public OrderDTO(String placedOn, String item) {
        this.placedOn = placedOn;
        this.item = item;
    }

    public OrderDTO(Long id, String placedOn, String item) {
        this.id = id;
        this.placedOn = placedOn;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDTO orderDTO = (OrderDTO) o;

        return id != null ? id.equals(orderDTO.id) : orderDTO.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

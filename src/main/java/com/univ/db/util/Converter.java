package com.univ.db.util;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.cassandra.Declaration;
import com.univ.db.model.dao.mongo.Item;
import com.univ.db.model.dao.neo4j.Order;
import com.univ.db.model.dao.neo4j.Seller;
import com.univ.db.model.dao.redis.ItemRecent;
import com.univ.db.model.dao.sql.User;
import com.univ.db.model.dao.sql.UserAddress;
import com.univ.db.model.dto.*;

/**
 * Default Comment
 */
public class Converter {

    //<editor-fold desc="toDTO">

    public static DeclarationDTO toDTO(Declaration t) {
        return (t == null)
                ? DeclarationDTO.EMPTY
                : new DeclarationDTO(Long.valueOf(t.getCatalogCode()), t.getData(), t.getAccepted(), t.getSupplier());
    }

    public static SellerDTO toDTO(Seller t){
        return (t == null)
                ? SellerDTO.EMPTY
                : new SellerDTO(t.getName(), t.getEmail());
    }

    public static OrderDTO toDTO(Order t) {
        return (t == null)
                ? OrderDTO.EMPTY
                : new OrderDTO(t.getItem(), t.getPlacedOn());
    }

    public static ItemDTO toDTO(Item t) {
        return (t == null)
                ? ItemDTO.EMPTY
                : new ItemDTO(t.getId(),
                                t.getCatalogCode(),
                                t.getTitle(),
                                t.getDescr(),
                                t.getSpecs(),
                                t.getTags(),
                                t.getManufacture());
    }

    public static ItemRecentDTO toDTO(ItemRecent t) {
        return (t == null)
                ? ItemRecentDTO.EMPTY
                : new ItemRecentDTO(t.getCatalogCode(),
                                    t.getTitle(),
                                    t.getDescr(),
                                    t.getSpecs());
    }

    public static UserDTO toDTO(User t) {
        return (t == null)
                ? UserDTO.EMPTY
                : new UserDTO(t.getId(),
                            t.getName(),
                            t.getEmail(),
                            t.getPassword());
    }

    public static UserAddressDTO toDTO(UserAddress t) {
        return (t == null)
                ? UserAddressDTO.EMPTY
                : new UserAddressDTO(t.getUser().getId(),
                                    t.getCountry(),
                                    t.getCity(),
                                    t.getAddress(),
                                    t.getIndex());
    }
    //</editor-fold>

    //<editor-fold desc="toDAO">

    public static Declaration toDAO(DeclarationDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");

        return new Declaration(t.getCatalogCode(), t.getAccepted(), t.getSupplier());
    }

    public static Order toDAO(OrderDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");

        return new Order(t.getItem(), t.getPlacedOn());
    }

    public static Seller toDAO(SellerDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");

        return new Seller(t.getName(), t.getEmail());
    }

    public static Item toDAO(ItemDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");

        return new Item(t.getId(), t.getCatalogCode(), t.getTitle(), t.getDescr(), t.getSpecs(), t.getTags(), t.getManufacture());
    }

    public static ItemRecent toDAO(ItemRecentDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");
        return new ItemRecent(t.getCatalogCode(), t.getTitle(), t.getDescr(), t.getSpecs());
    }

    public static UserAddress toDAO(UserAddressDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");
        return new UserAddress(t.getCountry(), t.getCity(), t.getAddress(), t.getIndex());
    }

    public static User toDAO(UserDTO t) {
        if(t == null)
            throw new NullPointerException("NULLABLE");

        return new User(t.getId(), t.getName(), t.getEmail(), t.getPassword());
    }
    //</editor-fold>

    public static boolean isStrValid(String value) {
        return value != null && !value.trim().isEmpty();
    }


    public static Order update(Order origin, OrderDTO update) {
        if(update == null || origin == null)
            throw new NullPointerException();

        origin.setItem((isStrValid(update.getItem())) ? update.getItem() : origin.getItem());
        origin.setPlacedOn((isStrValid(update.getPlacedOn())) ? update.getPlacedOn() : origin.getPlacedOn());

        return origin;
    }

    public static Order update(Order origin, Order update) {
        if(update == null || origin == null)
            throw new NullPointerException();

        origin.setItem((isStrValid(update.getItem())) ? update.getItem() : origin.getItem());
        origin.setPlacedOn((isStrValid(update.getPlacedOn())) ? update.getPlacedOn() : origin.getPlacedOn());

        return origin;
    }
}

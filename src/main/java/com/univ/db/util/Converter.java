package com.univ.db.util;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.model.dao.Item;
import com.univ.db.model.dao.ItemRecent;
import com.univ.db.model.dao.User;
import com.univ.db.model.dao.UserAddress;
import com.univ.db.model.dto.ItemDTO;
import com.univ.db.model.dto.ItemRecentDTO;
import com.univ.db.model.dto.UserAddressDTO;
import com.univ.db.model.dto.UserDTO;

/**
 * Default Comment
 */
public class Converter {

    //<editor-fold desc="toDTO">

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
}

package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Default Comment
 */
public class UserDTO {
    public static final UserDTO EMPTY = new UserDTO();

    @NotNull private Long id;
    @NotEmpty private String name;

    @Email private String email;
    @NotEmpty private String password;

    private UserDTO() {
        this.id = 0L;
        this.name   = "";
        this.email  = "";
        this.password = "";
    }

    public UserDTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name   = name;
        this.email  = email;
        this.password = password;
    }

    //<editor-fold desc="GetterAndSetter">

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //</editor-fold>
}

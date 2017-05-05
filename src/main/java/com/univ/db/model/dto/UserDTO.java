package com.univ.db.model.dto;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

/**
 * Default Comment
 */
public class UserDTO {
    public static final UserDTO EMPTY = new UserDTO();

    private Long id;
    private String name;
    private String email;
    private String password;

    public UserDTO() {
        this.name   = "";
        this.email  = "";
        this.password = "";
    }

    public UserDTO(String name, String email, String password) {
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

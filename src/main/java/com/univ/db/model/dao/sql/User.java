package com.univ.db.model.dao.sql;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.util.JpaResolver;
import io.dummymaker.annotation.GenEmail;
import io.dummymaker.annotation.GenName;
import io.dummymaker.annotation.GenPass;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Default Comment
 */
@Entity
@Table(name = JpaResolver.TABLE_USER_CREDENTIALS, schema = JpaResolver.SCHEMA)
public class User {

    public static final User EMPTY = new User();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @GenName
    private String name;

    @Column(unique = true)
    @Email
    @GenEmail
    private String email;

    @NotEmpty
    @GenPass
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private UserAddress address;

    public User() {
        this.name   = "";
        this.email  = "";
        this.password = "";
    }

    public User(String name, String email, String password) {
        this.name   = name;
        this.email  = email;
        this.password = password;
    }

    public User(Long id, String name, String email, String password) {
        this(name, email, password);
        this.id = id;
    }

    public User(Long id, String name, String email, String password, UserAddress address) {
        this(id, name, email, password);
        this.address = address;
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

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }
    //</editor-fold>
}

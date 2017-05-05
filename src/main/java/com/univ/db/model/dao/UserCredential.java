package com.univ.db.model.dao;

/*
 * Created by @GoodforGod on 05.05.2017.
 */

import com.univ.db.util.JpaResolver;

import javax.persistence.*;

/**
 * Default Comment
 */
@Entity
@Table(name = JpaResolver.TABLE_USER_CREDENTIALS, schema = JpaResolver.SCHEMA)
public class UserCredential {

    public static final UserCredential EMPTY = new UserCredential();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "credential")
    private UserAddress address;

    public UserCredential() {
        this.name   = "";
        this.email  = "";
        this.password = "";
    }

    public UserCredential(String name, String email, String password) {
        this.name   = name;
        this.email  = email;
        this.password = password;
    }
}

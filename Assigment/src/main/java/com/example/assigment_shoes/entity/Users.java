package com.example.assigment_shoes.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.example.assigment_shoes.entity.Enum.user.RoleEnum;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @NotBlank(message = "Please enter your's username")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Please enter your's password")
    @Length(min = 6, max = 12, message = "Length of password must be from 6 to 12 chacracter")
    @Column(length = 12, nullable = false)
    private String password;

    private Boolean rememberMe;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }


}

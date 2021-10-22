package com.ticket.manger.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name="register_users")
public class RegisterUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "p_password", nullable = false)
    private String password;

    @Column(name="expirede_on", nullable = false)
    private Date expiredOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }
}

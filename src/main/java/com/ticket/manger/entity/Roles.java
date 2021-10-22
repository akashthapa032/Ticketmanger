package com.ticket.manger.entity;


import com.ticket.manger.enums.RoleType;

import javax.persistence.*;


@Entity(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="name", nullable = false, unique = true)
    private RoleType name;

    @Column(name="display_name", nullable = false, unique = true)
    private String displayname;

    public Roles() {
    }

    public Roles(RoleType name, String displayname) {
        this.name = name;
        this.displayname = displayname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getName() {
        return name;
    }

    public void setName(RoleType name) {
        this.name = name;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}

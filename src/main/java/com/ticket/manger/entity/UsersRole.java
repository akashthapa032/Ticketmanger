package com.ticket.manger.entity;


import javax.management.relation.Role;
import javax.persistence.*;

@Entity(name="users_roles")
public class UsersRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name ="role_id")
    @ManyToOne
    private Roles role;

    @JoinColumn(name="user_id")
    @ManyToOne
    private  Users users;

    public UsersRole() {
    }

    public UsersRole(Roles role, Users users) {
        this.role = role;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

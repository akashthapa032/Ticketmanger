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
    private Role role;

    @JoinColumn(name="user_id")
    @ManyToOne
    private  Users users;

    public UsersRole() {
    }

    public UsersRole(Role role, Users users) {
        this.role = role;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

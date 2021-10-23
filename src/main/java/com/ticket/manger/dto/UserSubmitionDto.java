package com.ticket.manger.dto;

import com.ticket.manger.enums.RoleType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

//Data transfering object to transfer data to database
public class UserSubmitionDto {
    private Long id;

    @NotBlank
    @NotNull
    @Email
    private String username;

    @NotBlank
    @NotNull
    private String name;

    @NotNull
    @NotBlank
    private String password;


    private List<RoleType> roles;

    public UserSubmitionDto() {
    }

    public UserSubmitionDto(Long id, @NotBlank @NotNull @Email String username, @NotBlank @NotNull String name, List<RoleType> roles) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.roles = roles;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public List<RoleType> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleType> roles) {
        this.roles = roles;
    }
}

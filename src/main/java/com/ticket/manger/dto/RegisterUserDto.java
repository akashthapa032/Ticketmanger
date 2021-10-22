package com.ticket.manger.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserDto {
    @NotNull
    @NotBlank
    @Email
    private String username;

    @NotBlank
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(min =2)
    private String password;

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
}

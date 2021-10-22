package com.ticket.manger.controller;

import com.ticket.manger.dto.RegisterUserDto;
import com.ticket.manger.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterUserController {
    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("")
    public void registerNewUser(@Valid @RequestBody RegisterUserDto registerUserDto){
                registerUserService.registerNewUser(registerUserDto);
    }


}

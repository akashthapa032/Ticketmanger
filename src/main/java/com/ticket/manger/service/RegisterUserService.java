package com.ticket.manger.service;

import com.ticket.manger.dto.RegisterUserDto;
import org.springframework.stereotype.Service;



public interface RegisterUserService {
    void registerNewUser(RegisterUserDto registerUserDto);



}

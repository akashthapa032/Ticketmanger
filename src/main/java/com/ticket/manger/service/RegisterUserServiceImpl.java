package com.ticket.manger.service;

import com.ticket.manger.dto.RegisterUserDto;
import com.ticket.manger.entity.RegisterUser;
import com.ticket.manger.repository.RegisterUserRepository;
import com.ticket.manger.repository.UsersRepository;
import com.ticket.manger.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl implements RegisterUserService{
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private Util util;
    @Autowired
    private RegisterUserRepository registerUserRepository;


    @Override
    public void registerNewUser(RegisterUserDto registerUserDto) {
        long count = usersRepository.countByUsername(registerUserDto.getUsername());
        if (count <= 0){
            RegisterUser registerUser = new RegisterUser();
            registerUser.setUsername(registerUserDto.getUsername());
            registerUser.setName(registerUserDto.getName());
            registerUser.setPassword(registerUserDto.getPassword());
            registerUser.setExpiredOn(util.addDays(100));
            registerUserRepository.save(registerUser);
        }
        else {
            throw new RuntimeException("User Already exits");
        }

    }
}

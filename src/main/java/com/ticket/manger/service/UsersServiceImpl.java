package com.ticket.manger.service;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;
import com.ticket.manger.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

public class UsersServiceImpl implements UsersService{
        @Autowired
        private UsersRepository usersRepository;




    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findAllById(Long id) {
        return null;
    }

    @Override
    public void save(UserSubmitionDto userSubmitionDto) {

    }

    @Override
    public void update(Long id, @Valid UserSubmitionDto userSubmitionDto) {

    }

    @Override
    public void delete(Long id) {

    }
}

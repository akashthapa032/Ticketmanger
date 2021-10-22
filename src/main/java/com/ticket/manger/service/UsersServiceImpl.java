package com.ticket.manger.service;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;

import javax.validation.Valid;
import java.util.List;

public class UsersServiceImpl implements UsersService{


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

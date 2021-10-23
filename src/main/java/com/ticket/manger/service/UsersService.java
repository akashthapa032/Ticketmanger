package com.ticket.manger.service;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface UsersService {
    List<UserDto> findAll();
    UserDto findAllById(Long id);
    void save(UserSubmitionDto userSubmitionDto);
    void update (Long id, @Valid UserSubmitionDto userSubmitionDto);
    void delete(Long id);

}

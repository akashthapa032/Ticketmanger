package com.ticket.manger.controller;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;
import com.ticket.manger.dto.UserWrapperDto;
import com.ticket.manger.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public UserWrapperDto getUserlist(){
        List<UserDto> data = usersService.findAll();
        UserWrapperDto userWrapperDto = new UserWrapperDto();
        userWrapperDto.setData(data);
        return userWrapperDto;
    }

    @GetMapping("/{id}")
    public UserDto get (@PathVariable Long id){
        return usersService.findAllById(id);

    }

    @PostMapping("")
    public void save(@Valid @RequestBody UserSubmitionDto userSubmitionDto){
        usersService.save(userSubmitionDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody UserSubmitionDto userSubmitionDto){
        usersService.update(id,userSubmitionDto);

    }
    @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            usersService.delete(id);
        }

}

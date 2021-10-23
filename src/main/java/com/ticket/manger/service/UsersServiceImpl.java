package com.ticket.manger.service;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;
import com.ticket.manger.entity.Users;
import com.ticket.manger.entity.UsersRole;
import com.ticket.manger.enums.RoleType;
import com.ticket.manger.repository.RoleRepository;
import com.ticket.manger.repository.UsersRepository;
import com.ticket.manger.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public class UsersServiceImpl implements UsersService{
        @Autowired
        private UsersRepository usersRepository;
        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private UsersRoleRepository usersRoleRepository;

    @Override
    public List<UserDto> findAll() {

        return usersRepository.findAll().stream().map(this::mapUser).collect(Collectors.toList());
    }
    private UserDto mapUser( Users users){
         
        List<UsersRole> userRoles = usersRoleRepository.findAllByUsers(users);
        List<RoleType> roles = userRoles.stream().map(userRole -> userRole.getRole().getName())
                .collect(Collectors.toList());
        return new UserDto(users.getId(), users.getUsername(), users.getName(), users.getEnabled(), roles);
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

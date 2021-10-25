package com.ticket.manger.service;

import com.ticket.manger.dto.UserDto;
import com.ticket.manger.dto.UserSubmitionDto;
import com.ticket.manger.entity.Roles;
import com.ticket.manger.entity.Users;
import com.ticket.manger.entity.UsersRole;
import com.ticket.manger.enums.RoleType;
import com.ticket.manger.repository.RoleRepository;
import com.ticket.manger.repository.UsersRepository;
import com.ticket.manger.repository.UsersRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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

        List<UsersRole> usersRoles = usersRoleRepository.findAllByUsers(users);
        List<RoleType> roles = usersRoles.stream().map(userRole -> userRole.getRole().getName()).collect(Collectors.toList());
        return new UserDto(users.getId(),users.getUsername(),users.getName(),users.getEnabled(),roles);

    }

    @Override
    public UserDto findAllById(Long id) {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if(usersOptional.isPresent()){
            return mapUser(usersOptional.get());

        }
        else {
            throw new RuntimeException("User Not found");
        }

    }

    @Override
    public void save(UserSubmitionDto userSubmitionDto) {
            Users users = new Users();
            users.setUsername(userSubmitionDto.getUsername());
            users.setName(userSubmitionDto.getName());
            users.setEnabled(true);
            users.setPassword(userSubmitionDto.getPassword());
            usersRepository.save(users);
            List<Roles> roles = roleRepository.findAllByNameIn(userSubmitionDto.getRoles());
            for( Roles role : roles){
                UsersRole urole2 = new UsersRole(role, users);
                usersRoleRepository.save(urole2);
            }
    }

    @Override
    public void update(Long id, @Valid UserSubmitionDto userSubmitionDto) {
        Optional<Users> userOptional = usersRepository.findById(id);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            List<UsersRole> roles = usersRoleRepository.findAllByUsers(user);
            usersRoleRepository.deleteAll(roles);
            user.setUsername(userSubmitionDto.getUsername());
            user.setName(userSubmitionDto.getName());
            usersRepository.save(user);
            List<Roles> addRoles = roleRepository.findAllByNameIn(userSubmitionDto.getRoles());
            for (Roles role : addRoles) {
                UsersRole uRole2 = new UsersRole(role, user);
                usersRoleRepository.save(uRole2);
            }
        } else {
            throw new RuntimeException("User not found");
        }


    }

    @Override
    public void delete(Long id) {
        Optional<Users> userOptional = usersRepository.findById(id);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            user.setEnabled(false);
            usersRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }


    }
}

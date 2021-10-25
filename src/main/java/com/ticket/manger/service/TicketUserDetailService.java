package com.ticket.manger.service;


import com.ticket.manger.entity.UsersRole;
import com.ticket.manger.repository.UsersRepository;
import com.ticket.manger.repository.UsersRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;



import java.util.ArrayList;
import java.util.List;

@Service
public class TicketUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersRoleRepository usersRoleRepository;

    /**
     * load user and its roles from database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ticket.manger.entity.Users user = usersRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        else if ( !user.getEnabled()){
            throw new RuntimeException(("User is disabled. Please contact to admin"));
        } else{
            //get role from database
            List<UsersRole> usersRoles = usersRoleRepository.findAllByUsers(user);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for ( UsersRole usersRole : usersRoles){
                authorities.add( new SimpleGrantedAuthority(usersRole.getRole().getName().name()));
            }
            return new User(user.getUsername(), user.getPassword(), authorities);

        }

    }
    /**
     * get logged in user
     *
     * @return
     */

    com.ticket.manger.entity.Users currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return usersRepository.findByUsername(user.getUsername());
    }
}

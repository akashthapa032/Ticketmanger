package com.ticket.manger.repository;

import com.ticket.manger.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//it wil make connection with database

@Repository //donot forget to put @Repository in repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    long countByUsername(String name);
    Users findByUsername(String username);
}

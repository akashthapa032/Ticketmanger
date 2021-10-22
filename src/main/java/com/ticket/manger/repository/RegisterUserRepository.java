package com.ticket.manger.repository;

import com.ticket.manger.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    RegisterUser findByExpiredOn(Date expiredOn);
}

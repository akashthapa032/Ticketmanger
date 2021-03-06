package com.ticket.manger.repository;

import com.ticket.manger.entity.Roles;
import com.ticket.manger.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(RoleType name);

    List<Roles> findAllByNameIn(List<RoleType> roles);
}

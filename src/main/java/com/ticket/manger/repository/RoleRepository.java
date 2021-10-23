package com.ticket.manger.repository;

import com.ticket.manger.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);

    List<Role> findAllByNameIn(List<RoleType> roles);
}

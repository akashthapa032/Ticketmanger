package com.ticket.manger.repository;

import com.ticket.manger.entity.Users;
import com.ticket.manger.entity.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;

@Repository
public interface UsersRoleRepository extends JpaRepository <UsersRole, Long> {
    List<UsersRole> findAllByUsers(Users users);

    List<UsersRole> findAllByRole(Role role);


}

package com.example.storeeverything.repositories;

import com.example.storeeverything.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    /*Optional<Role> findByName(@Param("name") String name);*/

    Role findByName(String name);
}

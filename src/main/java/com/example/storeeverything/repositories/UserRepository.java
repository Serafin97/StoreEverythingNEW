package com.example.storeeverything.repositories;

import com.example.storeeverything.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

/*    Optional<User> findByUsernameIgnoreCase(@Param("username")String username);
    Optional<User> findByEmail(@Param("email") String email);*/

    User findByUsername(@Param("username")String username);
    User findByEmail(@Param("email") String email);

}

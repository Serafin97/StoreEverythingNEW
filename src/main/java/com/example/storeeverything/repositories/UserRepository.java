package com.example.storeeverything.repositories;

import com.example.storeeverything.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

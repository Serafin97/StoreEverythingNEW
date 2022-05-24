package com.example.storeeverything.security;

import com.example.storeeverything.models.User;
import com.example.storeeverything.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements  UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(username);
        }

/*
        return userRepository
                .findByUsernameIgnoreCase(username)
                .map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
*/

        return new MyUserDetails(user);

    }

}

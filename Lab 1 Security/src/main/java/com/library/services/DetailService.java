package com.library.services;

import com.library.entity.SecurityUser;
import com.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity=userService.findByUsername(username);
        if(userEntity==null)
            throw new UsernameNotFoundException("Username/password is invalid");
        return new SecurityUser(userEntity);
    }
}
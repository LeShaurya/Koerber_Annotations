package com.library.services.implementations;

import com.library.entity.User;
import com.library.repositories.UserRepository;
import com.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addUserEntity(User userEntity) {
        userRepository.save(userEntity);
    }
}

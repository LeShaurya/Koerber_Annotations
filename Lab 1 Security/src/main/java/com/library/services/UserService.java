package com.library.services;

import com.library.entity.User;

public interface UserService {
    User findByUsername(String username);
    void addUserEntity(User userEntity);
}

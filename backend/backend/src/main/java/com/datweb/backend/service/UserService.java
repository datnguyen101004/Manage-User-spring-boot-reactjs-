package com.datweb.backend.service;

import com.datweb.backend.dto.UserRegister;
import com.datweb.backend.entity.User;

import java.util.List;

public interface UserService {
    User save(UserRegister userRegister);

    List<User> getAllUser();

    User getUserByUsername(String username);

    List<User> getUserByKeyUserName(User user);

    User editUser(Long id, User user);

    User getUserById(Long id);

    Object deleteUser(Long id);
}

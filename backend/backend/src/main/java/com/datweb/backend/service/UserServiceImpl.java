package com.datweb.backend.service;

import com.datweb.backend.dto.UserRegister;
import com.datweb.backend.entity.User;
import com.datweb.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User save(UserRegister userRegister) {
        User user = new User();
        user.setEmail(userRegister.getEmail());
        user.setPassword(userRegister.getPassword());
        user.setUsername(userRegister.getUsername());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    @Override
    public List<User> getUserByKeyUserName(User user) {
        List<User> _user = userRepository.findUserByKeyUsername(user.getUsername());
        return _user;
    }

    @Override
    public User editUser(Long id, User user) {
        User _user = userRepository.findById(id).get();
        _user.setUsername(user.getUsername());
        _user.setEmail(user.getEmail());
        _user.setPassword(user.getPassword());
        userRepository.save(_user);
        return _user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Object deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return "success";
        }
        catch (Exception e){
            throw new RuntimeException("Not found user");
        }
    }


}

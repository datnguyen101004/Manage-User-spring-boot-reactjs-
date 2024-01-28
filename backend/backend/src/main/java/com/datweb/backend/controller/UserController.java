package com.datweb.backend.controller;

import com.datweb.backend.dto.UserRegister;
import com.datweb.backend.entity.User;
import com.datweb.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRegister userRegister){
        return ResponseEntity.ok().body(userService.save(userRegister));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/search")
    public ResponseEntity<List<User>> findUsernameContainingKey(@RequestBody User user){
        return ResponseEntity.ok().body(userService.getUserByKeyUserName(user));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") Long id,
                                         @RequestBody User user){
        return ResponseEntity.ok().body(userService.editUser(id, user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.accepted().body(userService.deleteUser(id));
    }
}

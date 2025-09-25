package com.example.controller;

import com.example.entity.UserUjwal;
import com.example.service.UserServiceUjwal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllerUjwal {

    private final UserServiceUjwal userService;

    public UserControllerUjwal(UserServiceUjwal userService) {
        this.userService = userService;
    }

    // Add User
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserUjwal user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserUjwal> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
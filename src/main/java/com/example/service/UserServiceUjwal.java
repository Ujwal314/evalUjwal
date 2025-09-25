package com.example.service;

import com.example.entity.UserUjwal;
import com.example.repository.UserRepositoryUjwal;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceUjwal {
    private final UserRepositoryUjwal userRepositoryUjwal;

    public UserServiceUjwal(UserRepositoryUjwal userRepositoryUjwal){
        this.userRepositoryUjwal = userRepositoryUjwal;
    }

    public String addUser(UserUjwal user) {
        userRepositoryUjwal.save(user);
        return "User added!";
    }

    public Optional<UserUjwal> getUserById(Long id) {
        return userRepositoryUjwal.findById(id);
    }

}
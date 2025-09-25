package com.example.service;

import com.example.entity.UserUjwal;
import com.example.repository.UserRepositoryUjwal;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceUjwalTest {

    @Mock
    private UserRepositoryUjwal userRepositoryUjwal;

    @InjectMocks
    private UserServiceUjwal userService;

    public UserServiceUjwalTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUser_ShouldReturnSuccessMessage() {
        UserUjwal user = new UserUjwal(null, "John", "john@example.com");
        when(userRepositoryUjwal.save(user)).thenReturn(user);

        String response = userService.addUser(user);

        assertEquals("User added!", response);
        verify(userRepositoryUjwal, times(1)).save(user);
    }

    @Test
    void getUserById_ShouldReturnUser_WhenUserExists() {
        UserUjwal user = new UserUjwal(1L, "John", "john@example.com");
        when(userRepositoryUjwal.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserUjwal> foundUser = userService.getUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals("John", foundUser.get().getName());
    }

    @Test
    void getUserById_ShouldReturnEmptyOptional_WhenUserNotFound() {
        when(userRepositoryUjwal.findById(1L)).thenReturn(Optional.empty());

        Optional<UserUjwal> foundUser = userService.getUserById(1L);

        assertFalse(foundUser.isPresent());
    }
}

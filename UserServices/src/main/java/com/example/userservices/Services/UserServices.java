package com.example.userservices.Services;

import com.example.userservices.Entities.User;

import java.util.List;

public interface UserServices {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    void deleteUser(String userId);

    User updateUser(User user);
}

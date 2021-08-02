package com.epam.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.springexample.model.entities.User;

@Service
public class UserService {

    UserService() {
    }

    public User getUserById(long userId) {
        return null;
    }

    public User getUserByEmail(String email) {
        return null;
    }

    public List<User> getUserByName(String name) {
        return null;
    }

    public boolean createUser(User user) {
        return false;
    }

    public boolean updateUser(User user) {
        return false;
    }

    public boolean deleteUser(long userId) {
        return false;
    }
}

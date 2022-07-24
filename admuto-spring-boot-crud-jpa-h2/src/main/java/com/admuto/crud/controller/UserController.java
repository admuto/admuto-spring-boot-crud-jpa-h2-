package com.admuto.crud.controller;

import com.admuto.crud.entity.User;
import com.admuto.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    @GetMapping("/add{id}")
    public User getUserByUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }
}

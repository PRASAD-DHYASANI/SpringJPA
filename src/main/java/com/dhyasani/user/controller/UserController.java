package com.dhyasani.user.controller;

import com.dhyasani.user.model.User;
import com.dhyasani.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="", method= RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value="/getUsersByFirstName", method= RequestMethod.GET)
    public List<User> getUsersByFirstName(@RequestParam String firstName) {
        return userService.findByName(firstName);
    }

    @RequestMapping(value="/getUsersById", method= RequestMethod.GET)
    public User getById(@RequestParam Long userId) {
        return userService.getById(userId);
    }

    @RequestMapping(value="/deleteUser", method= RequestMethod.DELETE)
    public void deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping(value="/addUser", method= RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/updateUser", method= RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}

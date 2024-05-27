package com.principal.miapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.miapi.model.User;
import com.principal.miapi.service.UserService;

@RestController
@RequestMapping("/users")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

        User newUser = userService.createUser(user);
        return newUser;

    }

    @PutMapping("/update/{id}")
    public User updateUser() {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser() {

    }

}

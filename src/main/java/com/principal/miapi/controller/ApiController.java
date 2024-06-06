package com.principal.miapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.principal.miapi.dto.request.UserRequestDTO;
import com.principal.miapi.dto.response.UserResponseDTO;
import com.principal.miapi.service.UserService;

@RestController
@RequestMapping("/users")
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        return new ResponseEntity<>( userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

package com.principal.miapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.principal.miapi.model.User;
import com.principal.miapi.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        
        return userRepository.save(user);

    }

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public User findUser(Long id) {
        //User user =  userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado con el id "+id));
        Optional<User> user =  userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }else{
            throw new EntityNotFoundException("Usuario no encontrado con");
        }
        
    }








}

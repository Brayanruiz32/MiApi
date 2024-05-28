package com.principal.miapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.principal.miapi.dto.request.UserRequestDTO;
import com.principal.miapi.dto.response.UserResponseDTO;
import com.principal.miapi.model.User;
import com.principal.miapi.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper = new ModelMapper();

    public List<UserResponseDTO> findAll() {
        List<UserResponseDTO> listUsers= userRepository.findAll().stream().map(u -> modelMapper.map(u, UserResponseDTO.class)).toList();
        return listUsers;
    }

    public UserResponseDTO createUser(UserRequestDTO user) {
        User newUser = modelMapper.map(user, User.class);
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepository.save(newUser), UserResponseDTO.class);
    }

    public UserResponseDTO findUser(Long id) {
        //User user =  userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado con el id "+id));
        User user =  userRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        return modelMapper.map(user, UserResponseDTO.class);
        
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO user) {
        User updateUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException()); 
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        updateUser.setRol(user.getRol());
        return modelMapper.map(userRepository.save(updateUser), UserResponseDTO.class);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        userRepository.deleteById(id);    
    }



}

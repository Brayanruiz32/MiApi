package com.principal.miapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.principal.miapi.model.User;
import com.principal.miapi.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //encuentro mi usuario
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No se encontró el usuario"));    
        //creo una listita de authorities
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //agregp a la listita las authorities
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRol().name()));
        //retornamos un usuario de tipo springsecurity
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }


    

}

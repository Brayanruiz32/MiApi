package com.principal.miapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.principal.miapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {




}

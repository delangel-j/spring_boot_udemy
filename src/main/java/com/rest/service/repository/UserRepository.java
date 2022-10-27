package com.rest.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.service.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
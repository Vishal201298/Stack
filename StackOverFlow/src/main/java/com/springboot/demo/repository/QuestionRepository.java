package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long>{

}
package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
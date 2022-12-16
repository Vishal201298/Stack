package com.springboot.demo.controller;

import java.util.List;

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

import com.springboot.demo.Questions;
import com.springboot.demo.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@PostMapping
	public ResponseEntity<Questions> saveQuestion(@RequestBody Questions question){
		return new ResponseEntity<Questions>(questionService.saveQuestions(question), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Questions> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Questions> getQuestionsById(@PathVariable("id") long id){
		return new ResponseEntity<Questions>(questionService.getQuestionsById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Questions> updateQuestion(@PathVariable("id") long id, @RequestBody Questions question){
		return new ResponseEntity<Questions>(questionService.updateQuestions(question, id), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteQuestions(@PathVariable("id") long id){
		questionService.deleteQuestions(id);
		return new ResponseEntity<String>("Question deleted successfully", HttpStatus.OK);
	}
}

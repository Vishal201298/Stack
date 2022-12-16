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

import com.springboot.demo.Answer;
import com.springboot.demo.service.AnswerService;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		super();
		this.answerService = answerService;
	}
	
	@PostMapping
	public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer){
		return new ResponseEntity<Answer>(answerService.saveAnswer(answer), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Answer> getAllAnswers(){
		return answerService.getAllAnswers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Answer> getAnswerById(@PathVariable("id") long id){
		return new ResponseEntity<Answer>(answerService.getAnswerById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Answer> updateAnswer(@PathVariable("id") long id, @RequestBody Answer answer){
		return new ResponseEntity<Answer>(answerService.updateAnswer(answer, id), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("id") long id){
		answerService.deleteAnswer(id);
		return new ResponseEntity<String>("Answer deleted successfully", HttpStatus.OK);
	}
}

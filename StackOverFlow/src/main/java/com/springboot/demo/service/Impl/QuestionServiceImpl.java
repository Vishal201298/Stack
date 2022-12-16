package com.springboot.demo.service.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.Questions;
import com.springboot.demo.repository.QuestionRepository;
import com.springboot.demo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	private QuestionRepository questionRepository;
	
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		super();
		this.questionRepository = questionRepository;
	}


	@Override
	public Questions saveQuestions(Questions question) {
		return questionRepository.save(question);
	}


	@Override
	public List<Questions> getAllQuestions() {
		return questionRepository.findAll();
	}


	@Override
	public Questions getQuestionsById(long id) {
		Optional<Questions> question = questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new ResourceNotFoundException("Question", "id", id);
		}
	}


	@Override
	public Questions updateQuestions(Questions question, long id) {
		Optional<Questions> existingQuestions = questionRepository.findById(id);
		if (!existingQuestions.isPresent()) {
			throw new ResourceNotFoundException("Question", "id", id);
		}
		
		Questions updateQuestions = existingQuestions.get();
		
		updateQuestions.setQuestion(question.getQuestion());
		updateQuestions.setLangauge(question.getLangauge());
	//	updateQuestions.setUserid(question.getUserid());
		
		questionRepository.save(updateQuestions);
		
		return updateQuestions;
	}


	@Override
	public void deleteQuestions(long id) {
		Optional<Questions> question = questionRepository.findById(id);
		if (question.isPresent()) {
			questionRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("question", "id", id);
		}
		
	}


}
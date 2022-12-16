package com.springboot.demo.service;


import java.util.List;

import com.springboot.demo.Questions;

public interface QuestionService {
	Questions saveQuestions(Questions question);
	List<Questions> getAllQuestions();
	Questions getQuestionsById(long id);
	Questions updateQuestions(Questions question, long id);
	void deleteQuestions(long id);
}
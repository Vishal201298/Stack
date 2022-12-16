package com.springboot.demo.service;


import java.util.List;

import com.springboot.demo.Answer;

public interface AnswerService {
	Answer saveAnswer(Answer answer);
	List<Answer> getAllAnswers();
	Answer getAnswerById(long id);
	Answer updateAnswer(Answer answer, long id);
	void deleteAnswer(long id);
}
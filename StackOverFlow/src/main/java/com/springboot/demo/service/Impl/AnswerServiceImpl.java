package com.springboot.demo.service.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.Answer;
import com.springboot.demo.repository.AnswerRepository;
import com.springboot.demo.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	private AnswerRepository answerRepository;
	
	
	public AnswerServiceImpl(AnswerRepository answerRepository) {
		super();
		this.answerRepository = answerRepository;
	}


	@Override
	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}


	@Override
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}


	@Override
	public Answer getAnswerById(long id) {
		Optional<Answer> answer = answerRepository.findById(id);
		if (answer.isPresent()) {
			return answer.get();
		} else {
			throw new ResourceNotFoundException("Answer", "id", id);
		}
	}


	@Override
	public Answer updateAnswer(Answer answer, long id) {
		Optional<Answer> existingAnswer = answerRepository.findById(id);
		if (!existingAnswer.isPresent()) {
			throw new ResourceNotFoundException("Answer", "id", id);
		}
		
		Answer updateAnswer = existingAnswer.get();
		
		updateAnswer.setAnswer(answer.getAnswer());
		updateAnswer.setQuestionid(answer.getQuestionid());
		
		
		
		answerRepository.save(updateAnswer);
		
		return updateAnswer;
	}


	@Override
	public void deleteAnswer(long id) {
		Optional<Answer> answer = answerRepository.findById(id);
		if (answer.isPresent()) {
			answerRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Answer", "id", id);
		}
		
	}


}
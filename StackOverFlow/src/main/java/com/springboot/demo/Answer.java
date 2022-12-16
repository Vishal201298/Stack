package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;



@Entity

@Table(name = "answers")

public @Data class Answer {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    

    @Column(name = "questionid")

    private int questionid;


    @Column(name = "answer")

    private String answer;

    
    
    @Column(name = "upvoting")

    private int upvoting;
    
    
    @Column(name = "dwvoting")

    private int dwvoting;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Questions>question=new ArrayList<>();
    


	public List<Questions> getQuestion() {
		return question;
	}


	public void setQuestion(List<Questions> question) {
		this.question = question;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuestionid() {
		return questionid;
	}


	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public int getUpvoting() {
		return upvoting;
	}


	public void setUpvoting(int upvoting) {
		this.upvoting = upvoting;
	}


	public int getDwvoting() {
		return dwvoting;
	}


	public void setDwvoting(int dwvoting) {
		this.dwvoting = dwvoting;
	}


	


	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionid=" + questionid + ", answer=" + answer + ", upvoting=" + upvoting
				+ ", dwvoting=" + dwvoting + ", question=" + question + "]";
	}


	public Answer(long id, int questionid, String answer, int upvoting, int dwvoting, List<Questions> question) {
		super();
		this.id = id;
		this.questionid = questionid;
		this.answer = answer;
		this.upvoting = upvoting;
		this.dwvoting = dwvoting;
		this.question = question;
	}


	
    
}
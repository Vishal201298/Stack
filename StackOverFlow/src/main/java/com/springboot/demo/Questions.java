package com.springboot.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;



@Entity

@Table(name = "questions")

public @Data class Questions {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    

//    @Column(name = "userid")
//
//    private int userid;


    @Column(name = "question")

    private String question;

    

    @Column(name = "langauge")

    private String langauge;
    
    
    @Column(name = "upvoting")

    private int upvoting;
    
    
    @Column(name = "dwvoting")

    private int dwvoting;
    
    
    
    
//    private User user;


//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}



	@Override
	public String toString() {
		return "Questions [id=" + id + ", question=" + question + ", langauge=" + langauge
				+ ", upvoting=" + upvoting + ", dwvoting=" + dwvoting + "]";
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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


//
//	public int getUserid() {
//		return userid;
//	}
//
//
//
//	public void setUserid(int userid) {
//		this.userid = userid;
//	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getLangauge() {
		return langauge;
	}



	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}


	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

    
   


}

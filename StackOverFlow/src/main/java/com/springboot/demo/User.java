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

@Table(name = "users")

public class User {

	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    

    @Column(name = "username")

    private String username;
    
    
    @Column(name = "technology")

    private String technology;

    

    @Column(name = "password")

    private String password;
    
    @OneToMany(targetEntity = Questions.class,cascade=CascadeType.ALL)
    @JoinColumn(name="userid",referencedColumnName ="id")
    private List<Questions>question=new ArrayList<>();


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Questions> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}


	public User(long id, String username, String technology, String password, List<Questions> questions) {
		super();
		this.id = id;
		this.username = username;
		this.technology = technology;
		this.password = password;
		this.questions = questions;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", technology=" + technology + ", password=" + password
				+ ", questions=" + questions + "]";
	}


}


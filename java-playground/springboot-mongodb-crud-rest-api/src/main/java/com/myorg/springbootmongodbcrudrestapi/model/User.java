package com.myorg.springbootmongodbcrudrestapi.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "UserDB")
public class User {
	
	@Id
	private String id;
	
	@NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
	private String username;
	
	private String correctAnswer;
	private int numberOfTries;
	private List<String> attemptedWords;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getNumberOfTries() {
		return numberOfTries;
	}
	public void setNumberOfTries(int numberOfTries) {
		this.numberOfTries = numberOfTries;
	}
	public List<String> getAttemptedWords() {
		return attemptedWords;
	}
	public void setAttemptedWords(List<String> attemptedWords) {
		this.attemptedWords = attemptedWords;
	}

}

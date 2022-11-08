package com.example.GameLibrary.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long developerId;
	private String developerName;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "developer")
	private List<Game> games;
	
	public Developer() {}

	public Developer(String developerName) {
		super();
		this.developerName = developerName;
	}

	public Long getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(Long developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGarmets(List<Game> games) {
		this.games = games;
	}
	
	
}

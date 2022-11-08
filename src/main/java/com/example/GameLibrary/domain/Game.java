package com.example.GameLibrary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "This Field Cannot Be Empty")
	private String name;

	private String genre;
	@PositiveOrZero
	@Digits(integer=6, fraction=2, message = "Price must be in a 2-decimal format")
	private double price;
	@NotBlank(message = "This field cannot be empty")
	private String developer;
	

	public Game() {
	}

	public Game(String name, String genre, double price, String developer) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		this.developer = developer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", genre=" + genre + ", price=" + price + ", developer="
				+ developer + "]";
	}

}

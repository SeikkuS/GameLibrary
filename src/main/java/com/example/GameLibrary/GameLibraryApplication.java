package com.example.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.GameLibrary.domain.Game;
import com.example.GameLibrary.domain.GameRepository;
import com.example.GameLibrary.domain.Developer;
import com.example.GameLibrary.domain.DeveloperRepository;
import com.example.GameLibrary.domain.Genre;
import com.example.GameLibrary.domain.GenreRepository;
@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}
	@Bean
	public CommandLineRunner gameDemo(GameRepository gRepository, DeveloperRepository devRepository, GenreRepository genRepository) {
		return (args) -> {
			gRepository.save(new Game("Crysis", "Action, Shooter, FPS", 20.00, "Crytek"));
		
			devRepository.save(new Developer("Crytek"));
			devRepository.save(new Developer("Bethesda Game Studios"));
			devRepository.save(new Developer("Riot Games"));
			devRepository.save(new Developer("Valve"));
			devRepository.save(new Developer("2K"));
			
			genRepository.save(new Genre ("Horror"));
			genRepository.save(new Genre ("Action"));
			genRepository.save(new Genre ("FPS"));
			genRepository.save(new Genre ("RPG"));
			genRepository.save(new Genre ("Co-op"));
			genRepository.save(new Genre ("Survival"));
			genRepository.save(new Genre ("Casual"));
			genRepository.save(new Genre ("Competitive"));
			genRepository.save(new Genre ("Strategy"));
			genRepository.save(new Genre ("Adventure"));
			genRepository.save(new Genre ("Sci-fi"));
			genRepository.save(new Genre ("Sports"));
			genRepository.save(new Genre ("Medieval"));
			genRepository.save(new Genre ("Fantasy"));
			genRepository.save(new Genre ("Crafting"));
			genRepository.save(new Genre ("Indie"));
			genRepository.save(new Genre ("Early Access"));
			genRepository.save(new Genre ("Free to Play"));
			genRepository.save(new Genre ("Racing"));
			genRepository.save(new Genre ("Military"));
			genRepository.save(new Genre ("VR Titles"));
			
			
		
		
		};
	}
}
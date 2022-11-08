package com.example.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.GameLibrary.domain.Game;
import com.example.GameLibrary.domain.GameRepository;
import com.example.GameLibrary.domain.Developer;
import com.example.GameLibrary.domain.DeveloperRepository;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}
	@Bean
	public CommandLineRunner gameDemo(GameRepository gRepository, DeveloperRepository devRepository) {
		return (args) -> {
			gRepository.save(new Game("Crysis", "Action, Shooter, FPS", 20.00, "Crytek"));
		
			devRepository.save(new Developer("Crytek"));
			devRepository.save(new Developer("Bethesda Game Studios"));
			devRepository.save(new Developer("Riot Games"));
			devRepository.save(new Developer("Valve"));
			devRepository.save(new Developer("2K"));
		
		
		};
	}
}
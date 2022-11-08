package com.example.GameLibrary.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository <Developer, Long> {
	List<Developer> findByDeveloperName(String DeveloperName);
}

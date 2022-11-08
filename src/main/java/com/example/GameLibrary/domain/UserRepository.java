package com.example.GameLibrary.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Useri, Long> {
	Useri findByUsername(String username);
}
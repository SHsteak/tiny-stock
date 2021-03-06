package com.ts.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.api.entity.UserEntity;
import com.ts.api.repository.UserRepo;

@RestController
public class UserCtrl {

	@Autowired
	UserRepo userRepo;

	@GetMapping(value = "/api/user")
	List<UserEntity> list() {
		List<UserEntity> list = new ArrayList<>();
		Iterable<UserEntity> it = userRepo.findAll();
		it.forEach(list::add);
		return list;
	}

	@GetMapping(value = "/api/user/{id}")
	Optional<UserEntity> info(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}

	@PostMapping(value = "/api/user")
	UserEntity create(@RequestBody UserEntity userEntity) {
		UserEntity created = userRepo.save(userEntity);
		return created;
	}

	@PutMapping(value = "/api/user/{id}")
	UserEntity update(@PathVariable("id") Long id,
			@RequestBody UserEntity userEntity) {
		userEntity.setId(id);
		UserEntity updated = userRepo.save(userEntity);
		return updated;
	}

	@DeleteMapping(value = "/api/user/{id}")
	public void delete(@PathVariable("id") Long id) {
		userRepo.deleteById(id);
	}
}

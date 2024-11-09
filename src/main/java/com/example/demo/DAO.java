package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DAO {
	
	@Autowired
	UserInterface repo;
	
	public void insert(User u1) {
		repo.save(u1);
	}
	
	public User findUser(String email) {
		return repo.findByEmail(email);
	}
	
	public List<User> find(){
		return repo.findAll();
	}
	
	public List<User> findPage() {
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		Pageable pageable = PageRequest.of(0, 1, sort);
		return repo.findAll(pageable).toList();
	}
}

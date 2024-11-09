package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Service {
	
	@Autowired
	DAO dao;
	
	@GetMapping("/")
	public String fun1() {
		return "This is Home Page";
	}
	
	@GetMapping("/welcome/{name}")
	public String fun2(@PathVariable("name") String name) {
		return "welcome " + name;
	}
	
	@PostMapping("/user")
	public String fun3(@RequestBody User user) {
		dao.insert(user);
		return "User Inserted";
	}
	
	//@GetMapping("/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String fun4(@RequestParam("email") String email) {
		return dao.findUser(email).toString();
	}
	
	@GetMapping("/all")
	public String fun6() {
		return dao.find().toString();
	}
	
	@GetMapping("/page")
	public String fun5() {
		return dao.findPage().toString();
	}

}

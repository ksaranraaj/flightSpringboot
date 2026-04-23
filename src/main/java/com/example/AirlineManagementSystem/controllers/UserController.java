package com.example.AirlineManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineManagementSystem.beans.User;
import com.example.AirlineManagementSystem.service.AuthService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	 private AuthService authService;

	 @PostMapping("/login")
	 public ResponseEntity<User> login(@RequestParam String userName, @RequestParam String password) {
	     User user = authService.authenticate(userName, password);
	     if (user != null) {
	         return ResponseEntity.ok(user);  // Return the user with role if authentication succeeds
	     }
	     return ResponseEntity.status(401).build();  // Unauthorized if authentication fails
	 }
	 
	 @PostMapping("/register")
	 public void addUser(@RequestBody User user)
	 {
		 authService.addUser(user);
	 }
	 
}






 

package com.example.AirlineManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AirlineManagementSystem.beans.User;
import com.example.AirlineManagementSystem.repo.UserRepo;

@Service
public class AuthService {

	 @Autowired
	 private UserRepo userRepository;

	 public User authenticate(String userName, String password) {
	     User user = userRepository.findByUserName(userName);
	     if (user != null && user.getPassword().equals(password)) {
	         return user;  // Return the user object with role and other details
	     }
	     return null;  // Authentication failed
	 }

	public void addUser(User user) {
	userRepository.save(user);
	}
}




package com.example.AirlineManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AirlineManagementSystem.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepositroy;
	

}

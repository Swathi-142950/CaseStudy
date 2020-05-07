package com.casestudy.casestudy.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.model.User;
import com.casestudy.casestudy.repository.UserDetailsRepo;

@Service
public class UserDetailsOperations {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	public List<User> fetchUsers() {
		return userDetailsRepo.findAll();
	}

	public User saveUsers(User user) {
		return userDetailsRepo.save(user);
	}
	
}


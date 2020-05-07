package com.casestudy.casestudy.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.User;
import com.casestudy.casestudy.operations.UserDetailsOperations;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {

	@Autowired
	private UserDetailsOperations userDetailsOp;
	
	@GetMapping("/fetchUsers")
	public ResponseEntity<List<User>> fetchUsers() throws CaseStudyException {
		List<User> userList = userDetailsOp.fetchUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUsers(@RequestBody User user) throws CaseStudyException {
		Random random = new Random();
		user.setId(random.nextInt(100));
		User userResponse = userDetailsOp.saveUsers(user);
		if (null != userResponse) {
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/loginByRole/{role}")
	public ResponseEntity<List<User>> fetchUsersByRole(@PathVariable String role) throws CaseStudyException {
		List<User> userList = userDetailsOp.fetchUsersByRole(role);
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	
	@GetMapping("/fetchUserById/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable int id) throws CaseStudyException {
		User user = userDetailsOp.fetchUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}

package com.casestudy.casestudy.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.dto.UserDto;
import com.casestudy.casestudy.dto.WasherDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.operations.UserDetailsOperations;
import com.casestudy.casestudy.operations.WasherOperations;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserDetailsController {

	@Autowired
	private UserDetailsOperations userDetailsOp;
	
	@Autowired
	private WasherOperations washerOp;
	
	@GetMapping("/fetchUsers")
	public ResponseEntity<List<UserDto>> fetchUsers() throws CaseStudyException {
		List<UserDto> userList = userDetailsOp.fetchUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<UserDto> saveUsers(@RequestBody UserDto user) throws CaseStudyException {
		Random random = new Random();
		user.setId(random.nextInt(1000));
		UserDto userResponse = userDetailsOp.saveUsers(user);
		if (null != userResponse) {
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/loginByRole/{role}")
	public ResponseEntity<List<UserDto>> fetchUsersByRole(@PathVariable String role) throws CaseStudyException {
		List<UserDto> userList = userDetailsOp.fetchUsersByRole(role);
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
	
	
	@GetMapping("/fetchUserById/{id}")
	public ResponseEntity<UserDto> fetchUserById(@PathVariable int id) throws CaseStudyException {
		UserDto user = userDetailsOp.fetchUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable int id) throws CaseStudyException {
		UserDto userResponse =userDetailsOp.updateUser(user, id);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}
	
	@PostMapping("/updateUserList/{status}")
	public ResponseEntity<List<UserDto>> saveUsersList(@RequestBody List<UserDto> user, @PathVariable String status) throws CaseStudyException {
		List<UserDto> userResponse = userDetailsOp.saveUserListUpdate(user, status);
		if (null != userResponse) {
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/washer/getWasher")
	public ResponseEntity<List<WasherDto>> getAllWashers() {
		return new ResponseEntity<>(washerOp.getAllWashers(),HttpStatus.OK);
	}
	
	@PostMapping("/washer/addUpdateWasher")
	public ResponseEntity<List<WasherDto>> addOrUpdateWasher(@RequestBody List<WasherDto> washerDtos) throws CaseStudyException {
		return new ResponseEntity<>(washerOp.addOrUpdateWasher(washerDtos),HttpStatus.OK);
	}
	
	@GetMapping("/washer/{status}")
	public ResponseEntity<List<WasherDto>> activeOrInactiveWasher(@RequestBody List<WasherDto> washers) throws CaseStudyException {
		return new ResponseEntity<>(washerOp.activeOrInactiveWasher(washers),HttpStatus.OK);
	}

	@GetMapping(value = "/washer/download/washerReport.xlsx")
    public ResponseEntity<InputStreamResource> excelWasherReport() throws CaseStudyException {
    ByteArrayInputStream in = washerOp.washerReportToExcelFile();
   
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=washerReport.xlsx");
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in));
    }
}

package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.UserDto;
import com.casestudy.casestudy.model.User;
import com.casestudy.casestudy.model.Washer;
import com.casestudy.casestudy.repository.UserDetailsRepo;
import com.casestudy.casestudy.repository.WashDetailsRepo;
import com.casestudy.casestudy.repository.WasherRepo;

@Service
public class UserDetailsOperations {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Autowired
	WasherRepo washerDetailsRepo;
	
	public List<UserDto> fetchUsers() {
		List<User> users = userDetailsRepo.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		users.stream().forEach(usersFetch -> {
			UserDto userDto = new UserDto();
			userDto.setEmail(usersFetch.getEmail());
			userDto.setFullname(usersFetch.getFullname());
			userDto.setId(usersFetch.getId());
			userDto.setPassword(usersFetch.getPassword());
			userDto.setPhoneno(usersFetch.getPhoneno());
			userDto.setRole(usersFetch.getRole());
			userDto.setUsername(usersFetch.getUsername());
			userDto.setStatus(usersFetch.getStatus());
			userDtoList.add(userDto);
		});
		return userDtoList;
	}

	public UserDto saveUsers(UserDto userdto) {
		User user = new User();
		user.setEmail(userdto.getEmail());
		user.setFullname(userdto.getFullname());
		user.setId(userdto.getId());
		user.setPassword(userdto.getPassword());
		user.setPhoneno(userdto.getPhoneno());
		user.setRole(userdto.getRole());
		user.setUsername(userdto.getUsername());
		user.setStatus(userdto.getStatus());
		if (userdto.getRole().equalsIgnoreCase("washer")) {
			Washer washer = new Washer();
			washer.setEmailId(userdto.getEmail());
			washer.setId(userdto.getId());
			washer.setName(userdto.getFullname());
			washer.setPhoneNumber(userdto.getPhoneno());
			washer.setStatus(userdto.getStatus());
			washer.setRatings(0.0f);
			washerDetailsRepo.save(washer);
		}
		userDetailsRepo.save(user);
		return userdto;
	}
	
	public List<UserDto> saveUserListUpdate(List<UserDto> userdtos, String role) {
		List<User> userList = new ArrayList<>();
		for(UserDto userPackage : userdtos) {
			User userFetch = userDetailsRepo.findById((userPackage.getId()));
			userFetch.setEmail(userPackage.getEmail());
			userFetch.setFullname(userPackage.getFullname());
			userFetch.setPhoneno(userPackage.getPhoneno());
			userFetch.setStatus(userPackage.getStatus());
			userList.add(userFetch);
			userDetailsRepo.save(userList);
		}
		if (role == "customer") return fetchUsersByRole("customer");
		else return fetchUsersByRole("washer");
	}
	
	public List<UserDto> fetchUsersByRole(String role) {
		List<User> users = userDetailsRepo.findByRole(role);
		List<UserDto> userDtoList = new ArrayList<>();
		users.stream().forEach(usersFetch -> {
			UserDto userDto = new UserDto();
			userDto.setEmail(usersFetch.getEmail());
			userDto.setFullname(usersFetch.getFullname());
			userDto.setId(usersFetch.getId());
			userDto.setPassword(usersFetch.getPassword());
			userDto.setPhoneno(usersFetch.getPhoneno());
			userDto.setRole(usersFetch.getRole());
			userDto.setUsername(usersFetch.getUsername());
			userDto.setStatus(usersFetch.getStatus());
			userDtoList.add(userDto);
		});
		return userDtoList;
	}
	
	public UserDto fetchUserById(int id) {
		User user = userDetailsRepo.findById(id);
		UserDto userdto = new UserDto();
		userdto.setEmail(user.getEmail());
		userdto.setFullname(user.getFullname());
		userdto.setId(user.getId());
		userdto.setPassword(user.getPassword());
		userdto.setPhoneno(user.getPhoneno());
		userdto.setRole(user.getRole());
		userdto.setUsername(user.getUsername());
		return userdto;
	}

	public UserDto updateUser(UserDto userdto, int id) {
		User foundUser = userDetailsRepo.findById(id);
		if (null != foundUser) {
			foundUser.setEmail(userdto.getEmail());
			foundUser.setFullname(userdto.getFullname());
			foundUser.setPhoneno(userdto.getPhoneno());
		}
		userDetailsRepo.save(foundUser);
		return userdto;
	}
}


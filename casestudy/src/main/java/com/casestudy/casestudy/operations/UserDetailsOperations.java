package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.UserDto;
import com.casestudy.casestudy.model.User;
import com.casestudy.casestudy.repository.UserDetailsRepo;

@Service
public class UserDetailsOperations {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
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
		userDetailsRepo.save(user);
		return userdto;
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


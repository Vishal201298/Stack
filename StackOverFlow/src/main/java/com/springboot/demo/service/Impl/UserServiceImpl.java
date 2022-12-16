package com.springboot.demo.service.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.exception.ResourceNotFoundException;
import com.springboot.demo.User;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new ResourceNotFoundException("User", "id", id);
		}
	}


	@Override
	public User updateUser(User user, long id) {
		Optional<User> existingUser = userRepository.findById(id);
		if (!existingUser.isPresent()) {
			throw new ResourceNotFoundException("User", "id", id);
		}
		
		User updateUser = existingUser.get();
		
		updateUser.setUsername(user.getUsername());
		updateUser.setTechnology(user.getTechnology());
		updateUser.setPassword(user.getPassword());
		
		userRepository.save(updateUser);
		
		return updateUser;
	}


	@Override
	public void deleteUser(long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("User", "id", id);
		}
		
	}


}
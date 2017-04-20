package com.simple.springboot.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simple.springboot.Repositories.UserRepository;
import com.simple.springboot.models.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		saveUser(user);
	}
	
	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}
	
	public void deleteAllUser() {
		userRepository.deleteAll();
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

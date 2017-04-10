package com.simple.springboot.Service;

import java.util.List;

import com.simple.springboot.models.User;

public interface UserService {
	User findById(Long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUserById(Long id);
	void deleteAllUser();
	List<User> findAllUser();
	boolean isUserExist(User user);
	
}

package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {
	public void saveUser(User usr);
	public List<User> findAllUsers();
	public void deleteUserById(int id);
	public User findById(int id);
	public void updateUser(User User);
}

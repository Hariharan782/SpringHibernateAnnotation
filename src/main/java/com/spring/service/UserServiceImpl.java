package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	public void saveUser(User usr) {
		dao.saveUser(usr);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public void updateUser(User User) {
		dao.updateUser(User);
	}
}

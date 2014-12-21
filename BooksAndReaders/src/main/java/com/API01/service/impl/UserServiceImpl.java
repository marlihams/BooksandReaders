package com.API01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.API01.dao.UserDao;
import com.API01.model.User;
import com.API01.service.UserService;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;
	@Override
	@Transactional
	public void addUser(User user) {
	userDao.addUser(user);	
	}

	@Override
	@Transactional
	public void edit(User user) {
		userDao.editUser(user);
		
	}

	@Override
	@Transactional
	public void delete(int userId) {
	userDao.deleteUser(userId);
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		
		return userDao.findUser(userId);
		
	}
	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}

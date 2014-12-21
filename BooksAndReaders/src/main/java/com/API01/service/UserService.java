package com.API01.service;

import java.util.List;

import com.API01.model.User;


public interface UserService {
	public void addUser(User user);
	public void edit(User user);
	public void delete(int userId);
	public User getUser(int userId);
	public List<User> getAllUsers();
}

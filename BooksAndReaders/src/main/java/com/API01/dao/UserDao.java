package com.API01.dao;

import java.util.List;

import com.API01.model.User;

public interface UserDao {
	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUser(int userId);
	User findUserByName(String username);
	List<User> getAllUsers();
}

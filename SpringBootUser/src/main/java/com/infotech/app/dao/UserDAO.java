package com.infotech.app.dao;

import com.infotech.app.model.User;

public interface UserDAO {
	
	public abstract void createUser(User user);
	public abstract User getUserById(Integer userId);
	public abstract void deleteUserById(Integer userId);
	public abstract void updateUserNameById(Integer userId, String newName);

}

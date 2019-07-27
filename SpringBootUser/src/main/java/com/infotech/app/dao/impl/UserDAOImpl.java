package com.infotech.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.app.dao.UserDAO;
import com.infotech.app.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void createUser(User user) {
		String CREATE_USER_SQL = "INSERT INTO user_details(userName,phoneNo,address,pwd) VALUES(?,?,?,MD5(?))";
		int update = jdbcTemplate.update(CREATE_USER_SQL, user.getUserName(), user.getPhoneNo(), user.getAddress(), user.getPwd());

		if(update == 1) {
			System.out.println("User is created");
		}
	}

	@Override
	public User getUserById(Integer userId) {
		
		String GET_USER_SQL="SELECT * FROM user_details WHERE userId = ?";
		User user = jdbcTemplate.queryForObject(GET_USER_SQL, new UserRowMapper(), userId);
		return user;
	}

	@Override
	public void deleteUserById(Integer userId) {
		String DELETE_USER_SQL="DELETE FROM user_details WHERE userId=?";
		int update = jdbcTemplate.update(DELETE_USER_SQL, userId);
		if(update == 1) {
			System.out.println("User is deleted....");
		}


	}

	@Override
	public void updateUserNameById(Integer userId, String newName) {
		String UPDATE_USER_SQL="UPDATE user_details set userName=? WHERE userId=?";
		int update = jdbcTemplate.update(UPDATE_USER_SQL, newName, userId);
		if(update == 1) {
			System.out.println("User name is updated....");
		}

	}

}

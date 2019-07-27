package com.infotech.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.infotech.app.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserId(rs.getInt("userId"));
		user.setUserName(rs.getString("userName"));
		user.setPhoneNo(rs.getString("phoneNo"));
		user.setAddress(rs.getString("address"));
		return user;
	}

}

package com.infotech.app;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.app.dao.UserDAO;
import com.infotech.app.model.User;
@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner{
	
	Scanner sc = new Scanner(System.in);
	@Autowired
	private UserDAO userDAO;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//createUser();
		getUserById();
		//userDAO.updateUserNameById(2, "Mayank");
		//userDAO.deleteUserById(3);
	}
	private void getUserById() {
		
		System.out.println("enter user Id : ");
		int i = sc.nextInt();
		User user = userDAO.getUserById(i);
		System.out.println(user);
		
	}
	private void createUser() {
		User user = new User();
		user.setUserName("vibhor");
		user.setPhoneNo("9758834106");
		user.setAddress("People Tree hostel, Dehradun");
		user.setPwd("user1");
		
		userDAO.createUser(user);
	}

}

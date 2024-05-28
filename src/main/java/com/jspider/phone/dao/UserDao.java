package com.jspider.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.phone.connection.PhoneConnection;
import com.jspider.phone.dto.User;
import com.mysql.cj.xdevapi.Result;

public class UserDao {
	Connection connection = PhoneConnection.getDirectoryConnection();

	public boolean userRegister(User user) {
		String insertQry = "Insert into user(name,email,password) values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQry);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			// execute
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User loginUser(String email) {
		String selectQry = "select * from user where email=? ";
		try {
			PreparedStatement ps = connection.prepareStatement(selectQry);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			User user = null;
			while (result.next()) {
				String email1 = result.getString("email");
				String password = result.getString("password");
				user = new User(email1, password);
				// Important for display the name iD after log in if not set we will get null and 0  
				user.setName(result.getString("name"));
				user.setId(result.getInt("id"));
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

						package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int insertData(User user) {
		int status = 0;

		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into user (firstname,lastname,email,password) values(?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmailId());
			ps.setString(4, user.getPassword());

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static boolean checkUserData(String email) {
		boolean is_valid_user = false;
		

		try {
			Connection con = UserDao.getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery( "select email from user where email='"+email+"'");
			is_valid_user = resultSet.isBeforeFirst();
			return is_valid_user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is_valid_user;
	}

}

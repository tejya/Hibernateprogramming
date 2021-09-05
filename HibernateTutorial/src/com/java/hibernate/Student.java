package com.java.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class Student {
	public static void main(String args[]) {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/teju";
			String userName="root";
			String pass="";
			Connection con=DriverManager.getConnection(dbUrl,userName,pass);
			System.out.println("Connect success:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

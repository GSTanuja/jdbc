package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreUpdateDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		//ResultSet resultSet=null;
		Scanner scanner=new Scanner(System.in);
		try {
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("enter food type");
			String type=scanner.next();

			String sql="update food set type=? where food_id=10"; //inserting placehoder
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, type);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			connection=DriverManager.getConnection(url,username,password);
			String sql="insert into food values(?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			Scanner scanner=new Scanner(System.in);
			for(int i=0; i<1;i++) {
				System.out.println("Enter food name");
				String name=scanner.next();
				System.out.println("Enter food Id");
				int food_Id=scanner.nextInt();
				System.out.println("Enter  cost");
				float cost=scanner.nextFloat();
				System.out.println("Enter food type");
				String type=scanner.next();

				//set values for the place holders
				preparedStatement.setString(1,name);
				preparedStatement.setInt(2, food_Id);
				preparedStatement.setFloat(3,cost);
				preparedStatement.setString(4, type);

				//execute the statement
				preparedStatement.execute();

			}

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



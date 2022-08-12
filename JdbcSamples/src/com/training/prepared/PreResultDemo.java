package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreResultDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;

		try {
			connection=DriverManager.getConnection(url,username,password);
			String sql="select * from food ";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString("name");
				int foodId=resultSet.getInt("food_id");
				String type=resultSet.getString("type");
				float cost=resultSet.getFloat("cost");
				System.out.println(name+ "\t "+foodId+ "\t "+type+"\t "+cost);
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
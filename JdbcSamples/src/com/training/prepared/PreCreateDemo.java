package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreCreateDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
  try {
	 connection=DriverManager.getConnection(url,username,password);
	String sql="create table food(name varchar(20),food_id int primary key,cost float,type varchar(20))";
	preparedStatement=connection.prepareStatement(sql);
	preparedStatement.execute();
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



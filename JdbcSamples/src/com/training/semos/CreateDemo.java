package com.training.semos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDemo {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		Statement statement=null;
  try {
	 connection=DriverManager.getConnection(url,username,password);
	 statement=connection.createStatement();
	String sql="create table policy(name varchar(20),policy_id int primary key,type varchar(20),premium float)";
	boolean result=statement.execute(sql);
	System.out.println("Table created "+result);
} catch (SQLException e) {
	e.printStackTrace();
}finally {
	try {
		if(connection!=null)
			connection.close();
		if(statement!=null)
			statement.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
	}

}

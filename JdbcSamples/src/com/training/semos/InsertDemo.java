package com.training.semos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trialdb ";
		String username="root";
		String password="root";
		Connection connection=null;
		Statement statement=null;
		Scanner scanner=null;
		try {
			connection=DriverManager.getConnection(url,username,password);
			statement=connection.createStatement();
			//String sql="insert into policy values('Janvi',10,'life',2000)";
			//int result=statement.executeUpdate(sql);
			//System.out.println("Inserted "+result);
			 scanner=new Scanner(System.in);
			for(int i=0; i<4;i++) {
				System.out.println("Enter policy name");
				String name=scanner.next();
				System.out.println("Enter policy Id");
				int policyId=scanner.nextInt();
				System.out.println("Enter policy type");
				String type=scanner.next();
				System.out.println("Enter policy premium");
				float premium=scanner.nextFloat();
				String sql="insert into policy values('"+name+"',"+policyId+",'"+type+"',"+premium+")";
				int result=statement.executeUpdate(sql);
				System.out.println("Inserted "+result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				if(statement!=null)
					statement.close();
				scanner.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



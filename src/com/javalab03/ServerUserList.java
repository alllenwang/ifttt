package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerUserList {
	public static ArrayList<String> userList = new ArrayList<String>();

	public static void setUserList()
	{
		userList.clear();
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟�");
			System.exit(0);
		}
		// System.out.println("锟斤拷菘锟斤拷锟缴癸拷");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷
			// System.out.println("锟斤拷锟斤拷锟斤拷菘锟缴癸拷");
			Statement stmt = con.createStatement();// 锟斤拷锟斤拷SQL锟斤拷锟斤拷锟斤拷锟�
			// System.out.println("锟斤拷始锟斤拷锟斤拷锟斤拷");

			TableUser.CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser"
							);// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				if(!rs.getBoolean("isAdmin"))
				{
					String name = rs.getString("userName");
					ServerUserList.userList.add(name);
				}
				
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		
	}
}

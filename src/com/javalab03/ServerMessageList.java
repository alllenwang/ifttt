package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerMessageList {
	public static ArrayList<MessageInfo> list = new ArrayList<MessageInfo>();
	public static void setMessageList()
	{
		list.clear();
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
		ArrayList<MessageInfo> a = new ArrayList<MessageInfo>();
		try {
			Class.forName(JDriver);// ¼ÓÔØÊý¾Ý¿âÒýÇæ£¬·µ»Ø¸ø¶¨×Ö·û´®ÃûµÄÀà
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("¼ÓÔØÊý¾Ý¿âÒýÇæÊ§°Ü");
			System.exit(0);
		}
		// System.out.println("Êý¾Ý¿âÇý¶¯³É¹¦");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// Á¬½ÓÊý¾Ý¿â¶ÔÏó
			// System.out.println("Á¬½ÓÊý¾Ý¿â³É¹¦");
			Statement stmt = con.createStatement();// ´´½¨SQLÃüÁî¶ÔÏó
			// System.out.println("¿ªÊ¼´´½¨±í");

			TableUserMessage.CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUserMessage ");// ·µ»ØSQLÓï¾ä²éÑ¯½á¹û¼¯(¼¯ºÏ)
			while (rs.next()) {
				// Êä³öÃ¿¸ö×Ö¶Î-
				MessageInfo temp = new MessageInfo();
				temp.userName = rs.getString("UserName");
				temp.date = rs.getString("date");
				temp.message = rs.getString("message");
				temp.time = rs.getString("time");
				temp.sendUserName = rs.getString("sendUserName");
				temp.isRead = rs.getBoolean("isRead");
				list.add(temp);
			}
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
	}
}

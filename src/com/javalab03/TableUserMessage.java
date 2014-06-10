package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TableUserMessage {
	public static boolean CheckExist() {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
		try {
			Class.forName(JDriver);// ¼ÓÔØÊý¾Ý¿âÒýÇæ£¬·µ»Ø¸ø¶¨×Ö·û´®ÃûµÄÀà
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("¼ÓÔØÊý¾Ý¿âÒýÇæÊ§°Ü");
			System.exit(0);
		}
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// Á¬½ÓÊý¾Ý¿â¶ÔÏó
			ResultSet rs = con.getMetaData().getTables(null, null,
					"TableUserMessage".toUpperCase(), null);
			System.out.println("table already exist");

			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableUserMessage")) {
					System.out.println("table already exist");
					return true;
				}

			}
			System.out.println("start create table tableusermessage");
			Statement stmt = con.createStatement();// ´´½¨SQLÃüÁî¶ÔÏó
			// System.out.println("¿ªÊ¼´´½¨±í");
			String query = "create table TableUserMessage(userName VARCHAR(20) "
					+ ",message VARCHAR(200)"
					+ ",date VARCHAR(20)"
					+ ",time VARCHAR(20)"
					+ ",sendUserName VARCHAR(20)"
					+ ",isRead bit" + ")";
			// ´´½¨±íSQLÓï¾ä
			stmt.executeUpdate(query);// Ö´ÐÐSQLÃüÁî¶ÔÏó
			// System.out.println("±í´´½¨³É¹¦");
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}

		return false;
	}

	public static void insert(String userName, String message, String date,
			String time, String sendUserName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
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
			CheckExist();
			System.out.println("start insert tableusermessage");
			// System.out.println(userName);
			String a = "INSERT INTO TableUserMessage VALUES('" + userName
					+ "','" + message + "','" + date + "','" + time + "','"
					+ sendUserName + "','" + 0 + "')";
			stmt.executeUpdate(a);
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
	}

	public static void delete(String userName, String date, String time,
			String sendUserName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
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
			CheckExist();

			// System.out.println(userName);
			String a = "DELETE FROM TableUserMessage where userName = '"
					+ userName + "'and date = '" + date + "'and time = '"
					+ time + "'and sendUserName = '" + sendUserName + "'";
			stmt.executeUpdate(a);
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
	}

	public static void delete(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
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
			CheckExist();
			// System.out.println(userName);
			String a = "DELETE FROM TableUserMessage where userName = '"
					+ userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
	}

	public static void setIsRead(String userName, String message, String date,
			String time) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQLÊý¾Ý¿âÒýÇæ
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// Êý¾ÝÔ´
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
			CheckExist();

			// System.out.println(userName);

			String a = "UPDATE TableUserMessage SET isRead = " + 1
					+ "where userName = '" + userName + "'and message = '"
					+ message + "'and date = '" + date + "'and time = '" + time
					+ "'";
			stmt.executeUpdate(a);
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
	}

	public static ArrayList<MessageInfo> MessageInfo(String userName) {
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUserMessage where userName = '"
							+ userName + "'");// ·µ»ØSQLÓï¾ä²éÑ¯½á¹û¼¯(¼¯ºÏ)
			while (rs.next()) {
				// Êä³öÃ¿¸ö×Ö¶Î-
				MessageInfo temp = new MessageInfo();
				temp.userName = rs.getString("UserName");
				temp.date = rs.getString("date");
				temp.message = rs.getString("message");
				temp.time = rs.getString("time");
				temp.sendUserName = rs.getString("sendUserName");
				temp.isRead = rs.getBoolean("isRead");
				a.add(temp);
			}
			stmt.close();// ¹Ø±ÕÃüÁî¶ÔÏóÁ¬½Ó
			con.close();// ¹Ø±ÕÊý¾Ý¿âÁ¬½Ó
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Êý¾Ý¿âÁ¬½Ó´íÎó");
			System.exit(0);
		}
		return a;
	}
	
}

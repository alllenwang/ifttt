package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableUser {
	public static boolean CheckExist() {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
			System.exit(0);
		}
		// System.out.println("锟斤拷菘锟斤拷锟缴癸拷");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷
			ResultSet rs = con.getMetaData().getTables(null, null,
					"TableUser".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableUser"))
					return true;
			}
			Statement stmt = con.createStatement();// 锟斤拷锟斤拷SQL锟斤拷锟斤拷锟斤拷锟�
			// System.out.println("锟斤拷始锟斤拷锟斤拷锟斤拷");
			String query = "create table TableUser(userName VARCHAR(20) primary key"
					+ ",userPassword VARCHAR(20)"
					+ ",userMail VARCHAR(50)"
					+ ",isAdmin bit"
					+ ",balance INT"
					+ ",level INT"
					+ ",point INT" + ")";
			// 锟斤拷锟斤拷锟斤拷SQL锟斤拷锟�
			stmt.executeUpdate(query);// 执锟斤拷SQL锟斤拷锟斤拷锟斤拷锟�
			// System.out.println("锟�锟斤拷锟缴癸拷");
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);
		}
		return false;
	}

	public static void insert(String userName, String userPassword,
			String userMail, boolean isAdmin) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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
			CheckExist();

			// System.out.print("asdasdasdasdas");
			int temp;
			if (isAdmin)
				temp = 1;
			else
				temp = 0;
			String a = "INSERT INTO TableUser VALUES('" + userName + "','"
					+ userPassword + "','" + userMail + "','" + temp + "','"
					+ 1000 + "','" + 0 + "','" + 0 + "')";
			stmt.executeUpdate(a);

			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);
		}
	}

	public static void delete(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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
			CheckExist();
			String a = "DELETE FROM Tableuser where userName = '" + userName
					+ "'";
			stmt.executeUpdate(a);
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);
		}
	}

	public static void updateUser(String userName, String userPassword,
			String userMail, boolean isAdmin, int balance, int level, int point) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			int temp;
			if (isAdmin)
				temp = 1;
			else
				temp = 0;
			String a = "UPDATE TABLEUSER SET " + "userPassword = '"
					+ userPassword + "'," + "userMail = '" + userMail + "',"
					+ "isAdmin = '" + temp + "'," + "balance = '" + balance
					+ "'," + "level = '" + level + "'," + "point = '" + point
					+ "'" + "WHERE userName = '" + userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);
		}
	}

	public static String userName(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getString("userName");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return null;
	}

	public static String userPassword(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getString("userPassword");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return null;
	}

	public static String userMail(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getString("userMail");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return null;
	}

	public static boolean isAdmin(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				if (rs.getString("isAdmin").equals("1"))
					return true;
				else
					return false;
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return false;
	}

	public static int balance(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getInt("balance");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return -1;
	}

	public static int level(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getInt("level");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟");
			System.exit(0);
		}
		return -1;
	}

	public static int point(String userName) {
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return rs.getInt("point");
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		return -1;
	}

	public static void addBalance(String userName, int num) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			String a = "UPDATE TABLEUSER SET balance = balance + " + num
					+ "WHERE userName = '" + userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);

		}
	}

	public static void addpoint(String userName, int point) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		try {
			Class.forName(JDriver);// 锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷妫拷锟斤拷馗锟斤拷址锟斤拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟绞э拷锟");
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

			CheckExist();
			String a = "UPDATE TABLEUSER SET point = point + " + point
					+ "WHERE userName = '" + userName + "'";
			stmt.executeUpdate(a);
			a = "UPDATE TABLEUSER SET level = point/100 WHERE userName = '"
					+ userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�);
			System.exit(0);

		}
	}

	public static boolean signIn(String userName, String userPassword) {
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

			CheckExist();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "' and userPassword = '"
							+ userPassword + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return true;
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		return false;
	}

	public static boolean checkUser(String userName) {
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

			CheckExist();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TableUser");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				if (rs.getString("userName").equals(userName))
					return true;
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		return false;
	}

	public static ArrayList<TaskInfo> TaskInfo(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL锟斤拷菘锟斤拷锟斤拷锟�
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 锟斤拷锟皆�
		ArrayList<TaskInfo> a = new ArrayList<TaskInfo>();
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

			CheckExist();
			// TableTaskDateMail t1 = new TableTaskDateMail();
			// TableTaskDateWeibo t2 = new TableTaskDateWeibo();
			// TableTaskMailMail t3 = new TableTaskMailMail();
			// TableTaskMailWeibo t4 = new TableTaskMailWeibo();
			// TableTaskWeiboMail t5 = new TableTaskWeiboMail();
			// TableTaskWeiboWeibo t6 = new TableTaskWeiboWeibo();
			ResultSet rs;
			if (TableTaskDateMail.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskDateMail where userName = '"
								+ userName + "'");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "DateMail";
					a.add(temp);
				}
			}
			if (TableTaskDateWeibo.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskDateWeibo where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "DateWeibo";
					a.add(temp);
				}
			}
			if (TableTaskMailWeibo.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailWeibo where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "MailWeibo";
					a.add(temp);
				}
			}
			if (TableTaskMailMail.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailMail where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "MailMail";
					a.add(temp);
				}
			}
			if (TableTaskWeiboWeibo.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskWeiboWeibo where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "WeiboWeibo";
					a.add(temp);
				}
			}
			if (TableTaskWeiboMail.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskWeiboMail where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "WeiboMail";
					a.add(temp);
				}
			}
			if (TableTaskDateRenren.CheckExist()) {
				rs = stmt
						.executeQuery("SELECT * FROM TableTaskDateRenren where userName = '"
								+ userName + "'");
				while (rs.next()) {
					// 锟斤拷锟矫匡拷锟斤拷侄锟�
					TaskInfo temp = new TaskInfo();
					temp.taskName = rs.getString("taskName");
					temp.createDay = rs.getString("createDay");
					temp.createTime = rs.getString("createTime");
					temp.taskType = "DateRenren";
					a.add(temp);
				}
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		return a;
	}
	public static boolean signInAdmin(String userName, String userPassword) {
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

			CheckExist();

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUser where userName = '"
							+ userName + "' and userPassword = '"
							+ userPassword + "' and isAdmin = 1");// 锟斤拷锟斤拷SQL锟斤拷锟斤拷询锟斤拷锟�锟斤拷锟斤拷)
			// 循锟斤拷锟斤拷锟矫恳伙拷锟斤拷锟铰�
			while (rs.next()) {
				// 锟斤拷锟矫匡拷锟斤拷侄锟�
				return true;
			}
			stmt.close();// 锟截憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			con.close();// 锟截憋拷锟斤拷菘锟斤拷锟斤拷锟�
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("锟斤拷菘锟斤拷锟斤拷哟锟斤拷锟�");
			System.exit(0);
		}
		return false;
	}
}
package com.javalab03;

import java.sql.*;

public class TableUserTaskName {
	public static boolean CheckExist() {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 数据源
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			ResultSet rs = con.getMetaData().getTables(null, null,
					"TableUserTaskName".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableUserTaskName"))
					return true;
				else {
					Statement stmt = con.createStatement();// 创建SQL命令对象
					// System.out.println("开始创建表");
					String query = "create table TableUserTaskName(userName VARCHAR(20) "
							+ ",taskName VARCHAR(50)" + ")";
					// 创建表SQL语句
					stmt.executeUpdate(query);// 执行SQL命令对象
					// System.out.println("表创建成功");
					stmt.close();// 关闭命令对象连接
					con.close();// 关闭数据库连接
					return false;
				}
			}
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
		return false;
	}

	public static void insert(String userName, String taskName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 数据源
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			// System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");
			CheckExist();

			// System.out.println(userName);
			String a = "INSERT INTO TableUserTaskName VALUES('" + userName
					+ "','" + taskName + "')";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static void delete(String userName, String taskName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 数据源
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			// System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");
			CheckExist();

			// System.out.println(userName);
			String a = "DELETE FROM TableUserTaskName where userName = '"
					+ userName + "'and taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static void delete(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 数据源
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			// System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");
			CheckExist();
			// System.out.println(userName);
			String a = "DELETE FROM TableUserTaskName where userName = '"
					+ userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static String[] taskName(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// 数据源
		String[] a = new String[10];
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		// System.out.println("数据库驱动成功");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			// System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUserTaskName where userName = '"
							+ userName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			int temp = 0;
			while (rs.next()) {
				// 输出每个字段
				a[temp] = rs.getString("taskName");
				temp++;
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return a;
	}
}

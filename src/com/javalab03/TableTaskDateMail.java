package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableTaskDateMail {
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
					"TableTaskDateMail".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableTaskDateMail"))
					return true;
			}
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");
			String query = "create table TableTaskDateMail(taskName VARCHAR(50) primary key "
					+ ",createDay VARCHAR(20)"
					+ ",createTime VARCHAR(20)"
					+ ",date VARCHAR(20)"
					+ ",time VARCHAR(20)"
					+ ",sendMailID VARCHAR(50)"
					+ ",sendMailPassword VARCHAR(20)"
					+ ",receiveMailID VARCHAR(60)"
					+ ",subject VARCHAR(50)"
					+ ",text VARCHAR(140)"
					+ ",state INT"
					+ ",userName VARCHAR(20)" + ")";
			// 创建表SQL语句
			stmt.executeUpdate(query);// 执行SQL命令对象
			// System.out.println("表创建成功");
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
		return false;
	}


	public static void insert(String taskName, String date, String time,
			String sendMailID, String sendMailPassword, String receiveMailID,
			String subject, String text, String userName) {
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
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat d3 = DateFormat.getTimeInstance();
			String timeString = d3.format(currentTime);
			String dateString = formatter.format(currentTime);

			String a = "INSERT INTO TableTaskDateMail VALUES('" + taskName
					+ "','" + dateString + "','" + timeString + "','" + date
					+ "','" + time + "','" + sendMailID + "','"
					+ sendMailPassword + "','" + receiveMailID + "','"
					+ subject + "','" + text + "','" + 2 + "','" + userName
					+ "')";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static void delete(String taskName) {
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
			String a = "DELETE FROM TableTaskDateMail where taskName = '"
					+ taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static void updateTask(String taskName, String date, String time,
			String sendMailID, String sendMailPassword, String receiveMailID,
			String subject, String text) {
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
			String a = "UPDATE TableTaskDateMail SET date = '" + date + "',"
					+ "time = '" + time + "'," + "sendMailID = '" + sendMailID
					+ "'," + "sendMailPassword = '" + sendMailPassword + "',"
					+ "receiveMailID = '" + receiveMailID + "',"
					+ "subject = '" + subject + "'," + "text = '" + text + "'"
					+ "WHERE taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static String date(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("date");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String time(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("time");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String sendMailID(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("sendMailID");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String sendMailPassword(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("sendMailPassword");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String receiveMailID(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("receiveMailID");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String subject(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("subject");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String text(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("text");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public int thisChoose() {
		return 1;
	}

	public int thatChoose() {
		return 2;
	}

	public static boolean checkTaskName(String taskName) {
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM TableTaskDateMail");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					return true;
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return false;
	}

	public static String userName(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("userName");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static int state(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getInt("state");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return -1;
	}

	public static void setState(String taskName, int state) {
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
			String a = "UPDATE TableTaskDateMail SET state = '" + state + "'"
					+ "WHERE taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

	public static String createDay(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("CreateDay");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}

	public static String createTime(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where taskName = '"
							+ taskName + "'");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				return rs.getString("CreateTime");
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return null;
	}
}

package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class User {
	public static boolean signIn(String userName, String userPassword,
			boolean isAdmin) {
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userName).find()
				|| (userName.length() <= 0) || (userName.length() > 15)) {
			return false;
		}
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userPassword).find()
				|| (userPassword.length() < 6) || (userPassword.length() > 15)) {
			return false;
		}

		return TableUser.signIn(userName, userPassword);
	}

	public static boolean signUp(String userName, String userPassword,
			String userMail, boolean isAdmin) {
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userName).find()
				|| (userName.length() <= 0) || (userName.length() > 15)) {
			return false;
		}
		if (!((Pattern.compile("([\\w|\\d]+)[@]([\\w|\\d]+)\\.([\\w|\\d]+)"))
				.matcher(userMail).find()) || (userMail.length() < 5)) {
			return false;
		}
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userPassword).find()
				|| (userPassword.length() < 6) || (userPassword.length() > 15)) {
			return false;
		}

		if (TableUser.checkUser(userName)) {
			return false;
		} else {
			TableUser.insert(userName, userPassword, userMail, isAdmin);
			Message.sendMessage(userName, "Welcome to IFTTT, " + userName,
					"Admin");
			return true;
		}
	}

	public static boolean charge(String userName, String strNumber) {
		if ((Pattern.compile("[^(\\.|,|\\d)]")).matcher(strNumber).find()
				|| (strNumber.length() <= 0) || (strNumber.length() > 5)) {
			return false;
		}
		int number = Integer.parseInt(strNumber);
		if (!TableUser.checkUser(userName)) {
			return false;
		} else {
			TableUser.addBalance(userName, number);
			return true;
		}
	}

	public static int getBalance(String userName) {
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userName).find()
				|| (userName.length() <= 0) || (userName.length() > 15)) {
			return -1;
		}
		if (!TableUser.checkUser(userName)) {
			return -1;
		} else {
			return TableUser.balance(userName);
		}
	}

	public static int getCredit(String userName) {
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userName).find()
				|| (userName.length() <= 0) || (userName.length() > 15)) {
			return -1;
		}
		if (!TableUser.checkUser(userName)) {
			return -1;
		} else {
			return TableUser.point(userName);
		}
	}

	public static int getLevel(String userName) {
		if ((Pattern.compile("[^(\\w|\\d)]")).matcher(userName).find()
				|| (userName.length() <= 0) || (userName.length() > 15)) {
			return -1;
		}
		if (!TableUser.checkUser(userName)) {
			return -1;
		} else {
			return TableUser.level(userName);
		}
	}

	public static void deleteUser(String userName) {
		TableUser.delete(userName);
		TableUserMessage.delete(userName);
		ArrayList<TaskInfo> a = TableUser.TaskInfo(userName);
		for (int i = 0; i < a.size(); i++) {
			if (TaskList.getTask(a.get(i).taskName) != null)
				TaskList.getTask(a.get(i).taskName).stop();
		}
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
			String w = "DELETE FROM TableTaskDateMail where userName = '"
					+ userName + "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskDateRenren where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskDateWeibo where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskMailWeibo where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskMailMail where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskWeiboWeibo where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			w = "DELETE FROM TableTaskWeiboMail where userName = '" + userName
					+ "'";
			stmt.executeUpdate(w);
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}
}

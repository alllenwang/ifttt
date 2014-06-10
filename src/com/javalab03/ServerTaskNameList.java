package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerTaskNameList {
	public static ArrayList<TaskNameType> list = new ArrayList<TaskNameType>();

	public static void setList() {
		list.clear();
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

			TableTaskDateMail.CheckExist();
			TableTaskDateWeibo.CheckExist();
			TableTaskMailMail.CheckExist();
			TableTaskMailWeibo.CheckExist();
			TableTaskWeiboMail.CheckExist();
			TableTaskWeiboWeibo.CheckExist();
			TableTaskDateRenren.CheckExist();
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// System.out.println("开始创建表");

			ResultSet rs = stmt.executeQuery("SELECT * FROM TableTaskDateMail");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录

			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "DateMail";
				list.add(a);

			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskDateWeibo");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "DateWeibo";
				list.add(a);
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskMailMail");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "MailMail";
				list.add(a);
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskMailWeibo");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "MailWeibo";
				list.add(a);

			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskWeiboMail");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "WeiboMail";
				list.add(a);

			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskWeiboWeibo");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "WeiboWeibo";
				list.add(a);

			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskDateRenren");
			while (rs.next()) {
				TaskNameType a = new TaskNameType();
				a.TaskName = rs.getString("taskName");
				a.TaskType = "DateRenren";
				list.add(a);
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
	}
}


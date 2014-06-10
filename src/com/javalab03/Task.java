package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task {
	public String taskName = null;
	public String taskType = null;
	public Object taskObject = null;
	private Thread a = new Thread();

	public Task(String taskName, String taskType) {
		this.taskName = taskName;
		this.taskType = taskType;
		if (taskType.compareTo("DateMail") == 0) {
			this.taskObject = new TaskDateMail(taskName);
		} else if (taskType.compareTo("DateWeibo") == 0) {
			this.taskObject = new TaskDateWeibo(taskName);
		} else if (taskType.compareTo("MailMail") == 0) {
			this.taskObject = new TaskMailMail(taskName);
		} else if (taskType.compareTo("MailWeibo") == 0) {
			this.taskObject = new TaskMailWeibo(taskName);
		} else if (taskType.compareTo("WeiboMail") == 0) {
			this.taskObject = new TaskWeiboMail(taskName);
		} else if (taskType.compareTo("WeiboWeibo") == 0) {
			this.taskObject = new TaskWeiboWeibo(taskName);
		} else if (taskType.compareTo("DateRenren") == 0) {
			this.taskObject = new TaskDateRenren(taskName);
		}
		TaskList.taskList.add(this);
	}

	public void start() {
		if (taskType.equals("DateMail")) {
			a = new Thread((TaskDateMail) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("DateWeibo")) {
			a = new Thread((TaskDateWeibo) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("MailMail")) {
			a = new Thread((TaskMailMail) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("MailWeibo")) {
			a = new Thread((TaskMailWeibo) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("WeiboMail")) {
			a = new Thread((TaskWeiboMail) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("WeiboWeibo")) {
			a = new Thread((TaskWeiboWeibo) this.taskObject);
			// TableTaskDateMail b = new TableTaskDateMail();
			a.start();
		} else if (taskType.equals("DateRenren")) {
			a = new Thread((TaskDateRenren) this.taskObject);
			a.start();
		}

	}

	public void stop() {
		if (taskType.equals("DateMail")) {
			((TaskDateMail) this.taskObject).stop();
		} else if (taskType.equals("DateWeibo")) {
			((TaskDateWeibo) this.taskObject).stop();
		} else if (taskType.equals("MailMail")) {
			((TaskMailMail) this.taskObject).stop();
		} else if (taskType.equals("MailWeibo")) {
			((TaskMailWeibo) this.taskObject).stop();
		} else if (taskType.equals("WeiboMail")) {
			((TaskWeiboMail) this.taskObject).stop();
		} else if (taskType.equals("WeiboWeibo")) {
			((TaskWeiboWeibo) this.taskObject).stop();
		} else if (taskType.equals("DateRenren")) {
			((TaskDateRenren) this.taskObject).stop();
		}
	}

	public static void setState(String taskName, int state) {
		if(getState(taskName) != 3)
		{
			TableTaskDateMail.setState(taskName, state);
			TableTaskDateWeibo.setState(taskName, state);
			TableTaskMailMail.setState(taskName, state);
			TableTaskMailWeibo.setState(taskName, state);
			TableTaskWeiboMail.setState(taskName, state);
			TableTaskWeiboWeibo.setState(taskName, state);
			TableTaskDateRenren.setState(taskName, state);
		}
	}

	public static void delete(String taskName) throws InterruptedException {
		System.out.println(taskName);
		if (TaskList.getTask(taskName) != null)
			TaskList.getTask(taskName).stop();
		TaskList.delete(taskName);
		TableTaskDateMail.delete(taskName);
		TableTaskDateWeibo.delete(taskName);
		TableTaskMailMail.delete(taskName);
		TableTaskMailWeibo.delete(taskName);
		TableTaskWeiboMail.delete(taskName);
		TableTaskWeiboWeibo.delete(taskName);
		TableTaskDateRenren.delete(taskName);
	}

	public static boolean checkAllTaskName(String taskName) {
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
			int count = 0;
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskDateWeibo");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskMailMail");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskMailWeibo");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskWeiboMail");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskWeiboWeibo");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			rs = stmt.executeQuery("SELECT * FROM TableTaskDateRenren");
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					count++;
			}
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
			if (count == 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接错误");
			System.exit(0);
		}
		return false;
	}
	public static int getState(String taskName)
	{
		int i = TableTaskDateMail.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskDateWeibo.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskDateRenren.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskMailMail.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskMailWeibo.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskWeiboMail.state(taskName);
		if(i != -1)
		{
			return i;
		}
		i = TableTaskWeiboWeibo.state(taskName);
		if(i != -1)
		{
			return i;
		}
		return -1;
	}
	public static String addTaskDateMail(String taskName, String date,
			String time, String sendMailID, String sendMailPassword,
			String receiveMailID, String subject, String text, String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| sendMailID.isEmpty() || sendMailPassword.isEmpty()
					|| receiveMailID.isEmpty() || subject.isEmpty()
					|| text.isEmpty() || !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskDateMail.insert(taskName, date, time, sendMailID,
							sendMailPassword, receiveMailID, subject, text,
							userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskDateWeibo(String taskName, String date,
			String time, String weiboID, String weiboPassword, String text,
			String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| weiboID.isEmpty() || weiboPassword.isEmpty()
					|| text.isEmpty() || !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskDateWeibo.insert(taskName, date, time, weiboID,
							weiboPassword, text, userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskMailMail(String taskName, String listenMailID,
			String listenMailPassword, String sendMailID,
			String sendMailPassword, String receiveMailID, String subject,
			String text, String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenMailID.isEmpty()
					|| listenMailPassword.isEmpty() || sendMailID.isEmpty()
					|| sendMailPassword.isEmpty() || receiveMailID.isEmpty()
					|| subject.isEmpty() || text.isEmpty()
					|| !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskMailMail.insert(taskName, listenMailID,
							listenMailPassword, sendMailID, sendMailPassword,
							receiveMailID, subject, text, userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskMailWeibo(String taskName, String listenMailID,
			String listenMailPassword, String weiboID, String weiboPassword,
			String text, String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenMailID.isEmpty()
					|| listenMailPassword.isEmpty() || weiboID.isEmpty()
					|| weiboPassword.isEmpty() || text.isEmpty()
					|| !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskMailWeibo.insert(taskName, listenMailID,
							listenMailPassword, weiboID, weiboPassword, text,
							userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskWeiboMail(String taskName,
			String listenWeiboID, String listenWeiboPassword,
			String containInfo, String sendMailID, String sendMailPassword,
			String receiveMailID, String subject, String text, String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenWeiboID.isEmpty()
					|| listenWeiboPassword.isEmpty() || sendMailID.isEmpty()
					|| sendMailPassword.isEmpty() || containInfo.isEmpty()
					|| receiveMailID.isEmpty() || subject.isEmpty()
					|| text.isEmpty() || !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskWeiboMail.insert(taskName, listenWeiboID,
							listenWeiboPassword, containInfo, sendMailID,
							sendMailPassword, receiveMailID, subject, text,
							userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskWeiboWeibo(String taskName,
			String listenWeiboID, String listenWeiboPassword,
			String containInfo, String weiboID, String weiboPassword,
			String text, String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenWeiboID.isEmpty()
					|| listenWeiboPassword.isEmpty() || containInfo.isEmpty()
					|| weiboID.isEmpty() || weiboPassword.isEmpty()
					|| text.isEmpty() || !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskWeiboWeibo.insert(taskName, listenWeiboID,
							listenWeiboPassword, containInfo, weiboID,
							weiboPassword, text, userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String addTaskDateRenren(String taskName, String date,
			String time, String RenrenID, String RenrenPassword, String text,
			String userName) {
		if (checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| RenrenID.isEmpty() || RenrenPassword.isEmpty()
					|| text.isEmpty() || !TableUser.checkUser(userName))
				return "The data can't be empty";
			else {

				int num = 0;
				int point = TableUser.point(userName);
				if (point >= 0 && point < 500) {
					num = 50;
				} else if (point >= 500 && point < 1000) {
					num = 45;
				} else if (point >= 1000 && point < 2000) {
					num = 40;
				} else {
					num = 30;
				}
				TableUser.addBalance(userName, -num);
				if (TableUser.balance(userName) < 0) {
					TableUser.addBalance(userName, num);
					return "Your balance is not enough. ";
				} else {
					TableTaskDateRenren.insert(taskName, date, time, RenrenID,
							RenrenPassword, text, userName);
					TableUser.addpoint(userName, 100);
					return "Succeed to add a task";
				}
			}
		} else {
			return "Taskname is illegal(duplication of name).";
		}
	}

	public static String updateTaskDateMail(String taskName, String date,
			String time, String sendMailID, String sendMailPassword,
			String receiveMailID, String subject, String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| sendMailID.isEmpty() || sendMailPassword.isEmpty()
					|| receiveMailID.isEmpty() || subject.isEmpty()
					|| text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskDateMail.updateTask(taskName, date, time, sendMailID,
						sendMailPassword, receiveMailID, subject, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskDateWeibo(String taskName, String date,
			String time, String weiboID, String weiboPassword, String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| weiboID.isEmpty() || weiboPassword.isEmpty()
					|| text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskDateWeibo.updateTask(taskName, date, time, weiboID,
						weiboPassword, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskMailMail(String taskName,
			String listenMailID, String listenMailPassword, String sendMailID,
			String sendMailPassword, String receiveMailID, String subject,
			String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenMailID.isEmpty()
					|| listenMailPassword.isEmpty() || sendMailID.isEmpty()
					|| sendMailPassword.isEmpty() || receiveMailID.isEmpty()
					|| subject.isEmpty() || text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskMailMail.updateTask(taskName, listenMailID,
						listenMailPassword, sendMailID, sendMailPassword,
						receiveMailID, subject, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskMailWeibo(String taskName,
			String listenMailID, String listenMailPassword, String weiboID,
			String weiboPassword, String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenMailID.isEmpty()
					|| listenMailPassword.isEmpty() || weiboID.isEmpty()
					|| weiboPassword.isEmpty() || text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskMailWeibo.updateTask(taskName, listenMailID,
						listenMailPassword, weiboID, weiboPassword, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskWeiboMail(String taskName,
			String listenWeiboID, String listenWeiboPassword,
			String containInfo, String sendMailID, String sendMailPassword,
			String receiveMailID, String subject, String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenWeiboID.isEmpty()
					|| listenWeiboPassword.isEmpty() || sendMailID.isEmpty()
					|| sendMailPassword.isEmpty() || containInfo.isEmpty()
					|| receiveMailID.isEmpty() || subject.isEmpty()
					|| text.isEmpty())
				return "The data can't be empty";
			else {

				TableTaskWeiboMail.updateTask(taskName, listenWeiboID,
						listenWeiboPassword, containInfo, sendMailID,
						sendMailPassword, receiveMailID, subject, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskWeiboWeibo(String taskName,
			String listenWeiboID, String listenWeiboPassword,
			String containInfo, String weiboID, String weiboPassword,
			String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || listenWeiboID.isEmpty()
					|| listenWeiboPassword.isEmpty() || containInfo.isEmpty()
					|| weiboID.isEmpty() || weiboPassword.isEmpty()
					|| text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskWeiboWeibo.updateTask(taskName, listenWeiboID,
						listenWeiboPassword, containInfo, weiboID,
						weiboPassword, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}

	public static String updateTaskDateRenren(String taskName, String date,
			String time, String RenrenID, String RenrenPassword, String text) {
		if (!checkAllTaskName(taskName)) {
			if (taskName.isEmpty() || date.isEmpty() || time.isEmpty()
					|| RenrenID.isEmpty() || RenrenPassword.isEmpty()
					|| text.isEmpty())
				return "The data can't be empty";
			else {
				TableTaskDateRenren.updateTask(taskName, date, time, RenrenID,
						RenrenPassword, text);
				return "Succeed to update a task";
			}
		} else {
			return "Taskname is none.";
		}
	}
}

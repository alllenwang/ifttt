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
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// ����Դ
		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		// System.out.println("���ݿ������ɹ�");
		try {
			String user = "sa";
			String password = "123";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// �������ݿ����
			// System.out.println("�������ݿ�ɹ�");
			Statement stmt = con.createStatement();// ����SQL�������
			// System.out.println("��ʼ������");
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
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}
}

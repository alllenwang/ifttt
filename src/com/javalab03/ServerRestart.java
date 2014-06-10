package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServerRestart {
	public static void restart() {
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

			TableTaskDateMail.CheckExist();
			TableTaskDateWeibo.CheckExist();
			TableTaskMailMail.CheckExist();
			TableTaskMailWeibo.CheckExist();
			TableTaskWeiboMail.CheckExist();
			TableTaskWeiboWeibo.CheckExist();
			TableTaskDateRenren.CheckExist();
			Statement stmt = con.createStatement();// ����SQL�������
			// System.out.println("��ʼ������");

			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateMail where state = 1 or state = 2");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "DateMail");
				a.start();

			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateWeibo where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "DateWeibo");
				a.start();
			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "MailMail");
				a.start();
			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailWeibo where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "MailWeibo");
				a.start();
			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskWeiboMail where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "WeiboMail");
				a.start();
			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskWeiboWeibo where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "WeiboWeibo");
				a.start();
			}
			rs = stmt
					.executeQuery("SELECT * FROM TableTaskDateRenren where state = 1 or state = 2");
			while (rs.next()) {
				String taskName = rs.getString("taskName");
				Task a = new Task(taskName, "DateRenren");
				a.start();
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}
}

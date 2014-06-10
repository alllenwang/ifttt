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

			ResultSet rs = stmt.executeQuery("SELECT * FROM TableTaskDateMail");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼

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
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}
}


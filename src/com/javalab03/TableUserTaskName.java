package com.javalab03;

import java.sql.*;

public class TableUserTaskName {
	public static boolean CheckExist() {
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
			ResultSet rs = con.getMetaData().getTables(null, null,
					"TableUserTaskName".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableUserTaskName"))
					return true;
				else {
					Statement stmt = con.createStatement();// ����SQL�������
					// System.out.println("��ʼ������");
					String query = "create table TableUserTaskName(userName VARCHAR(20) "
							+ ",taskName VARCHAR(50)" + ")";
					// ������SQL���
					stmt.executeUpdate(query);// ִ��SQL�������
					// System.out.println("�����ɹ�");
					stmt.close();// �ر������������
					con.close();// �ر����ݿ�����
					return false;
				}
			}
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return false;
	}

	public static void insert(String userName, String taskName) {
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
			CheckExist();

			// System.out.println(userName);
			String a = "INSERT INTO TableUserTaskName VALUES('" + userName
					+ "','" + taskName + "')";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static void delete(String userName, String taskName) {
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
			CheckExist();

			// System.out.println(userName);
			String a = "DELETE FROM TableUserTaskName where userName = '"
					+ userName + "'and taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static void delete(String userName) {
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
			CheckExist();
			// System.out.println(userName);
			String a = "DELETE FROM TableUserTaskName where userName = '"
					+ userName + "'";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static String[] taskName(String userName) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=exp1";// ����Դ
		String[] a = new String[10];
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

			CheckExist();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableUserTaskName where userName = '"
							+ userName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			int temp = 0;
			while (rs.next()) {
				// ���ÿ���ֶ�
				a[temp] = rs.getString("taskName");
				temp++;
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return a;
	}
}

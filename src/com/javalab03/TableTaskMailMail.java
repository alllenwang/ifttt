package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableTaskMailMail {
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
					"TableTaskMailMail".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableTaskMailMail"))
					return true;
			}
			Statement stmt = con.createStatement();// ����SQL�������
			// System.out.println("��ʼ������");
			String query = "create table TableTaskMailMail(taskName VARCHAR(50) primary key "
					+ ",createDay VARCHAR(20)"
					+ ",createTime VARCHAR(20)"
					+ ",listenMailID VARCHAR(50)"
					+ ",listenMailPassword VARCHAR(20)"
					+ ",sendMailID VARCHAR(50)"
					+ ",sendMailPassword VARCHAR(20)"
					+ ",receiveMailID VARCHAR(60)"
					+ ",subject VARCHAR(50)"
					+ ",text VARCHAR(140)"
					+ ",state INT"
					+ ",userName VARCHAR(20)" + ")";
			// ������SQL���
			stmt.executeUpdate(query);// ִ��SQL�������
			// System.out.println("�����ɹ�");
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return false;
	}

	public static void insert(String taskName, String listenMailID,
			String listenMailPassword, String sendMailID,
			String sendMailPassword, String receiveMailID, String subject,
			String text, String userName) {
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
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat d3 = DateFormat.getTimeInstance();
			String timeString = d3.format(currentTime);
			String dateString = formatter.format(currentTime);
			String a = "INSERT INTO TableTaskMailMail VALUES('" + taskName
					+ "','" + dateString + "','" + timeString + "','" + listenMailID 
					+ "','" + listenMailPassword + "','"
					+ sendMailID + "','" + sendMailPassword + "','"
					+ receiveMailID + "','" + subject + "','" + text +  "','" + 2 
					+ "','" + userName +  "')";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static void delete(String taskName) {
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
			String a = "DELETE FROM TableTaskMailMail where taskName = '"
					+ taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����

		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static void updateTask(String taskName, String listenMailID,
			String listenMailPassword, String sendMailID,
			String sendMailPassword, String receiveMailID, String subject,
			String text) {
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
			String a = "UPDATE TableTaskMailMail SET listenMailID = '"
					+ listenMailID + "'," + "listenMailPassword = '"
					+ listenMailPassword + "'," + "sendMailID = '" + sendMailID
					+ "'," + "sendMailPassword = '" + sendMailPassword + "',"
					+ "receiveMailID = '" + receiveMailID + "',"
					+ "subject = '" + subject + "'," + "text = '" + text + "'"
					+ "WHERE taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static String listenMailID(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("listenMailID");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String listenMailPassword(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("listenMailPassword");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String sendMailID(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("sendMailID");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String sendMailPassword(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("sendMailPassword");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String receiveMailID(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("receiveMailID");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String subject(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("subject");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static String text(String taskName) {
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("text");
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static int thisChoose() {
		return 2;
	}

	public static int thatChoose() {
		return 2;
	}

	public static boolean checkTaskName(String taskName) {
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM TableTaskMailMail");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				if (rs.getString("taskName").equals(taskName))
					return true;
			}
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return false;
	}
	public static String userName(String taskName) {
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
				ResultSet rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
								+ taskName + "'");// ����SQL����ѯ�����(����)
				// ѭ�����ÿһ����¼
				while (rs.next()) {
					// ���ÿ���ֶ�
					return rs.getString("userName");
				}
				stmt.close();// �ر������������
				con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}

	public static int state(String taskName) {
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
				ResultSet rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
								+ taskName + "'");// ����SQL����ѯ�����(����)
				// ѭ�����ÿһ����¼
				while (rs.next()) {
					// ���ÿ���ֶ�
					return rs.getInt("state");
				}
				stmt.close();// �ر������������
				con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return -1;
	}

	public static void setState(String taskName, int state) {
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
				String a = "UPDATE TableTaskMailMail SET state = '" + state
						+ "'" + "WHERE taskName = '" + taskName + "'";
				stmt.executeUpdate(a);
				stmt.close();// �ر������������
				con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}
	public static String createDay(String taskName)
	{
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
				ResultSet rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
								+ taskName + "'");// ����SQL����ѯ�����(����)
				// ѭ�����ÿһ����¼
				while (rs.next()) {
					// ���ÿ���ֶ�
					return rs.getString("CreateDay");
				}
				stmt.close();// �ر������������
				con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}
	public static String createTime(String taskName)
	{
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
				ResultSet rs = stmt
						.executeQuery("SELECT * FROM TableTaskMailMail where taskName = '"
								+ taskName + "'");// ����SQL����ѯ�����(����)
				// ѭ�����ÿһ����¼
				while (rs.next()) {
					// ���ÿ���ֶ�
					return rs.getString("CreateTime");
				}
				stmt.close();// �ر������������
				con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
		return null;
	}
}

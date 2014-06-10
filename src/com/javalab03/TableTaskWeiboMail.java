package com.javalab03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableTaskWeiboMail {
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
					"TableTaskWeiboMail".toUpperCase(), null);
			while (rs.next()) {
				if (rs.getObject(3).toString().equals("TableTaskWeiboMail"))
					return true;
			}
			Statement stmt = con.createStatement();// ����SQL�������
			// System.out.println("��ʼ������");
			String query = "create table TableTaskWeiboMail(taskName VARCHAR(50) primary key "
					+ ",createDay VARCHAR(20)"
					+ ",createTime VARCHAR(20)"
					+ ",listenWeiboID VARCHAR(50)"
					+ ",listenWeiboPassword VARCHAR(20)"
					+ ",listenAccessToken VARCHAR(50)"
					+ ",containInfo VARCHAR(50)"
					+ ",sendMailID VARCHAR(50)"
					+ ",sendMailPassword VARCHAR(20)"
					+ ",receiveMailID VARCHAR(60)"
					+ ",subject VARCHAR(100)"
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

	public static void insert(String taskName, String listenWeiboID,
			String listenWeiboPassword, String containInfo, String sendMailID,
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
			String listenAccessToken;
			if (listenWeiboID.equals("allenApril")
					&& listenWeiboPassword.equals("wangqi"))
				listenAccessToken = "2.00lP691CjhimlD6b434cddbbBZXC_C";
			else if (listenWeiboID.equals("Captsl")
					&& listenWeiboPassword.equals("tangshunlei"))
				listenAccessToken = "2.00sVZl4C3cEArD6e97d0591b0jdg2C";
			else if (listenWeiboID.equals("JimmyNovember")
					&& listenWeiboPassword.equals("sunmin"))
				listenAccessToken = "2.00lP691CjhimlD6b434cddbbBZXC_C";
			else
				listenAccessToken = null;
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat d3 = DateFormat.getTimeInstance();
			String timeString = d3.format(currentTime);
			String dateString = formatter.format(currentTime);
			String a = "INSERT INTO TableTaskWeiboMail VALUES('" + taskName
					+ "','" + dateString + "','" + timeString + "','"
					+ listenWeiboID + "','" + listenWeiboPassword + "','"
					+ listenAccessToken + "','" + containInfo + "','"
					+ sendMailID + "','" + sendMailPassword + "','"
					+ receiveMailID + "','" + subject + "','" + text + "','"
					+ 2 + "','" + userName + "')";
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
			String a = "DELETE FROM TableTaskWeiboMail where taskName = '"
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

	public static void updateTask(String taskName, String listenWeiboID,
			String listenWeiboPassword, String containInfo, String sendMailID,
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
			String listenAccessToken;
			if (listenWeiboID.equals("allenApril")
					&& listenWeiboPassword.equals("wangqi"))
				listenAccessToken = "2.00lP691CjhimlD6b434cddbbBZXC_C";
			else if (listenWeiboID.equals("Captsl")
					&& listenWeiboPassword.equals("tangshunlei"))
				listenAccessToken = "2.00sVZl4C3cEArD6e97d0591b0jdg2C";
			else if (listenWeiboID.equals("JimmyNovember")
					&& listenWeiboPassword.equals("sunmin"))
				listenAccessToken = "2.00lP691CjhimlD6b434cddbbBZXC_C";
			else
				listenAccessToken = null;
			String a = "UPDATE TableTaskWeiboMail SET listenWeiboID = '"
					+ listenWeiboID + "'," + "listenWeiboPassword = '"
					+ listenWeiboPassword + "'," + "listenAccesstoken = '"
					+ listenAccessToken + "'," + "containInfo = '"
					+ containInfo + "'," + "sendMailID = '" + sendMailID + "',"
					+ "sendMailPassword = '" + sendMailPassword + "',"
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

	public static String listenWeiboID(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("listenWeiboID");
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

	public static String listenWeiboPassword(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("listenWeiboPassword");
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

	public static String listenAccessToken(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("listenAccessToken");
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

	public static String containInfo(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
							+ taskName + "'");// ����SQL����ѯ�����(����)
			// ѭ�����ÿһ����¼
			while (rs.next()) {
				// ���ÿ���ֶ�
				return rs.getString("containInfo");
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
		return 3;
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
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM TableTaskWeiboMail");// ����SQL����ѯ�����(����)
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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
			String a = "UPDATE TableTaskWeiboMail SET state = '" + state + "'"
					+ "WHERE taskName = '" + taskName + "'";
			stmt.executeUpdate(a);
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

	public static String createDay(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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

	public static String createTime(String taskName) {
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
					.executeQuery("SELECT * FROM TableTaskWeiboMail where taskName = '"
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

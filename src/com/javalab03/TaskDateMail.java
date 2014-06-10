package com.javalab03;

import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TaskDateMail implements Runnable {
	private boolean flag;
	public String taskName;

	public TaskDateMail(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	public boolean THIS() throws ParseException {

		String date = TableTaskDateMail.date(taskName);
		String time = TableTaskDateMail.time(taskName);
		Date taskDate = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"))
				.parse(date + " " + time);
		Date currentTime = new Date();
		if (taskDate.before(currentTime))
			return true;
		else
			return false;

	}

	@SuppressWarnings("restriction")
	public void THAT() {
		try {
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			Properties props = System.getProperties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			// props.put("mail.host",Globals.MAIL_SERVER);
			props.put("mail.smtp.auth", "true");
			final String username = (String) TableTaskDateMail
					.sendMailID(taskName);
			final String password = (String) TableTaskDateMail
					.sendMailPassword(taskName);
			String receiveMailID = (String) TableTaskDateMail
					.receiveMailID(taskName);
			String subject = (String) TableTaskDateMail.subject(taskName);
			String text = (String) TableTaskDateMail.text(taskName);
			// System.out.println(username + password + receiveMailID + subject
			// + text);
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiveMailID, false));
			msg.setSubject(subject);
			msg.setText(text);
			msg.setSentDate(new Date());
			Transport.send(msg);
		} catch (AddressException e1) {
			System.out.println("发邮件出现异常（地址不正确）。");
		} catch (MessagingException e2) {
			System.out.println(e2);
		}
	}

	@Override
	public void run() {
		while (!flag) {
			if (TableTaskDateMail.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskDateMail.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						flag = true;
						System.out.println(TableTaskDateMail.state(taskName));
					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				TableTaskDateMail.setState(taskName, 3);
			} else if (TableTaskDateMail.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}

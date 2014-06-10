package com.javalab03;

import java.security.Security;
import java.text.ParseException;
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

import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class TaskWeiboMail implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskWeiboMail(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	public boolean THIS() throws ParseException, InterruptedException,
			WeiboException {

		Thread.sleep(5000);
		String access_token = TableTaskWeiboMail.listenAccessToken(taskName);
		String containInfo = TableTaskWeiboMail.containInfo(taskName);
		System.out.println(access_token);
		System.out.println(containInfo);
		Timeline tm = new Timeline();
		tm.client.setToken(access_token);
		Status a = new Status();

		// System.out.println();
		Date currentTime = new Date();
		// tm.client.setToken(access_token);
		// System.out.println(tm.getUserTimeline().getStatuses().get(0).getText());
		a = tm.getUserTimeline().getStatuses().get(0);
		if (currentTime.getTime() - a.getCreatedAt().getTime() <= 60000) {
			// System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
			if (a.getText().contains(containInfo)) {
				System.out.println("-----------------");
				return true;
			}
		}
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
			final String username = (String) TableTaskWeiboMail
					.sendMailID(taskName);
			final String password = (String) TableTaskWeiboMail
					.sendMailPassword(taskName);
			String receiveMailID = (String) TableTaskWeiboMail
					.receiveMailID(taskName);
			String subject = (String) TableTaskWeiboMail.subject(taskName);
			String text = (String) TableTaskWeiboMail.text(taskName);
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
			if (TableTaskWeiboMail.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskWeiboMail.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						flag = true;
						TableTaskWeiboMail.setState(taskName, 3);
					}

				} catch (ParseException | InterruptedException | WeiboException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (TableTaskWeiboMail.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(TableTaskWeiboMail.state(taskName));

		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}

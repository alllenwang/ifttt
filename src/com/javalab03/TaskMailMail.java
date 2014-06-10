package com.javalab03;

import java.security.Security;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TaskMailMail implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskMailMail(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	@SuppressWarnings("restriction")
	public boolean THIS() throws ParseException, MessagingException {

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", "995");
		props.setProperty("mail.pop3.socketFactory.port", "995");

		// 以下步骤跟一般的JavaMail操作相同
	
		final String username = TableTaskMailMail.listenMailID(taskName);
		final String password = TableTaskMailMail.listenMailPassword(taskName);
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop.gmail.com", 995, null,
				username, password);
		Store store = session.getStore(urln);
		Folder inbox = null;
		try {

			// get mail server
			store.connect();
			// get inbox directory
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			// get mails

			Message[] messages = inbox.getMessages();
			inbox.fetch(messages, profile);
			if (messages.length > 0
					&& (new Date()).getTime()
							- messages[messages.length - 1].getSentDate()
									.getTime() <= 120000) {
				System.out.println("Latest mail: "
						+ messages[messages.length - 1].getSentDate()
								.toString());
				System.out.println("Current time: " + (new Date()).toString());
				return true;
			}
		} finally {
			try {
				inbox.close(false);
			} catch (Exception e) {
			}
			try {
				store.close();
			} catch (Exception e) {
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
			final String username = (String) TableTaskMailMail
					.sendMailID(taskName);
			final String password = (String) TableTaskMailMail
					.sendMailPassword(taskName);
			String receiveMailID = (String) TableTaskMailMail
					.receiveMailID(taskName);
			String subject = (String) TableTaskMailMail.subject(taskName);
			String text = (String) TableTaskMailMail.text(taskName);
			System.out.println(username + password + receiveMailID + subject
					+ text);
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
			if (TableTaskMailMail.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskMailMail.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						System.out.println(TableTaskMailMail.state("OK"));
						TableTaskMailMail.setState(taskName, 3);
						flag = true;
					}
				} catch (ParseException | MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (TableTaskMailMail.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(TableTaskMailMail.state(taskName));
		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}

package com.javalab03;

import java.security.Security;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

import weibo4j.Timeline;
import weibo4j.model.WeiboException;

public class TaskMailWeibo implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskMailWeibo(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	@SuppressWarnings("restriction")
	public  boolean THIS() {
		
		Store store = null;
		Folder folder = null;
		try {
			// ��ȡĬ�ϻỰ
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");// ���õ����ʼ�Э��

			Session session = Session.getDefaultInstance(props, null);
			// ʹ��POP3�Ự���ƣ����ӷ�����
			store = session.getStore("imaps");
			final String username = TableTaskMailWeibo.listenMailID(taskName);
			final String password = TableTaskMailWeibo.listenMailPassword(taskName);
			store.connect("imap.gmail.com", username, password);
			// ��ȡĬ���ļ���
			folder = store.getDefaultFolder();
			if (folder == null)
				throw new Exception("No default folder");
			// ������ռ���
			folder = folder.getFolder("INBOX");
			if (folder == null)
				throw new Exception("No POP3 INBOX");
			// ʹ��ֻ����ʽ���ռ���
			folder.open(Folder.READ_ONLY);
			// �õ��ļ�����Ϣ����ȡ�ʼ��б�
			Message[] messages = folder.getMessages();
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

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public boolean THISa() throws ParseException, MessagingException {

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", "995");
		props.setProperty("mail.pop3.socketFactory.port", "995");

		// ���²����һ���JavaMail������ͬ
		final String username = TableTaskMailWeibo.listenMailID(taskName);
		final String password = TableTaskMailWeibo.listenMailPassword(taskName);
		Session session = Session.getDefaultInstance(props, null);
		URLName urln = new URLName("pop3", "pop.gmail.com", 995, null,
				username, password);
		Store store = session.getStore(urln);
	
		Folder inbox = null;
		try {
			// System.out.println(username+password);
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

	public void THAT() {
		try {
			System.out.println("send a weibo");
			String access_token = TableTaskMailWeibo.accessToken(taskName);// �����ӦaccessToken=XXXXXXXXXXXXXXXXXXX��ֵ
			String text = TableTaskMailWeibo.text(taskName);
			Timeline tm = new Timeline();
			tm.client.setToken(access_token);
			tm.UpdateStatus(text);
		} catch (WeiboException e) {
			System.out.println("��΢�������쳣��");
		}
	}

	@Override
	public void run() {
		while (!flag) {
			if (TableTaskMailWeibo.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskMailWeibo.state(taskName) == 1) {
				System.out.println("state = 1");
				if (THIS()) {
					System.out.println(TableTaskMailMail.state("ok"));
					THAT();
					TableTaskMailWeibo.setState(taskName, 3);
					flag = true;
				}

			} else if (TableTaskMailWeibo.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(TableTaskMailWeibo.state(taskName));
		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}
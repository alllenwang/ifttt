package com.javalab03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import weibo4j.Timeline;
import weibo4j.model.WeiboException;

public class TaskDateWeibo implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskDateWeibo(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	public boolean THIS() throws ParseException {

		String date = TableTaskDateWeibo.date(taskName);
		String time = TableTaskDateWeibo.time(taskName);
		Date taskDate = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"))
				.parse(date + " " + time);
		Date currentTime = new Date();
		if (taskDate.before(currentTime))
			return true;
		else
			return false;

	}

	public void THAT() {
		try {
			System.out.println("send a weibo");
			String access_token = TableTaskDateWeibo.accessToken(taskName);// 这里对应accessToken=XXXXXXXXXXXXXXXXXXX的值
			String text = TableTaskDateWeibo.text(taskName);
			Timeline tm = new Timeline();
			tm.client.setToken(access_token);
			tm.UpdateStatus(text);
		} catch (WeiboException e) {
			System.out.println("发微博出现异常。");
		}
	}

	@Override
	public void run() {
		while (!flag) {
			if (TableTaskDateWeibo.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskDateWeibo.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						TableTaskDateWeibo.setState(taskName, 3);
						flag = true;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (TableTaskDateWeibo.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
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

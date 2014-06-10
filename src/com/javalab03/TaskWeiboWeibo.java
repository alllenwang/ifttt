package com.javalab03;

import java.text.ParseException;
import java.util.Date;

import weibo4j.Timeline;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;

public class TaskWeiboWeibo implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskWeiboWeibo(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	public boolean THIS() throws ParseException, WeiboException,
			InterruptedException {
		Thread.sleep(5000);
		String access_token = TableTaskWeiboWeibo.listenAccessToken(taskName);
		String containInfo = TableTaskWeiboWeibo.containInfo(taskName);
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

	public void THAT() {
		try {
			System.out.println("send a weibo");
			String access_token = TableTaskWeiboWeibo.accessToken(taskName);// 这里对应accessToken=XXXXXXXXXXXXXXXXXXX的值
			String text = TableTaskWeiboWeibo.text(taskName);
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
			if (TableTaskWeiboWeibo.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskWeiboWeibo.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						TableTaskWeiboWeibo.setState(taskName, 3);
						flag = true;
					}
				} catch (ParseException | WeiboException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (TableTaskWeiboWeibo.state(taskName) == -1) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(TableTaskWeiboWeibo.state(taskName));
		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}

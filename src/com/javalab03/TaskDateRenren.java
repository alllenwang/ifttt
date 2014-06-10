package com.javalab03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDateRenren implements Runnable {
	private boolean flag;
	private String taskName;

	public TaskDateRenren(String taskName) {
		this.taskName = taskName;
		flag = false;
	}

	public boolean THIS() throws ParseException {

		String date = TableTaskDateRenren.date(taskName);
		String time = TableTaskDateRenren.time(taskName);
		Date taskDate = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"))
				.parse(date + " " + time);
		Date currentTime = new Date();
		if (taskDate.before(currentTime))
			return true;
		else
			return false;

	}

	public void THAT() {
		String RenrenID = TableTaskDateRenren.RenrenID(taskName);
		String RenrenPassword = TableTaskDateRenren.RenrenPassword(taskName);
		String text = TableTaskDateRenren.text(taskName);

		Renren a = new Renren(RenrenID, RenrenPassword);
		a.updateStatus(text);
		// System.out.println(RenrenID + " " + RenrenPassword + " " +text);
	}

	@Override
	public void run() {
		while (!flag) {
			if (TableTaskDateRenren.state(taskName) == 2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("state = 2");
			} else if (TableTaskDateRenren.state(taskName) == 1) {
				System.out.println("state = 1");
				try {
					if (THIS()) {
						THAT();
						TableTaskDateRenren.setState(taskName, 3);
						flag = true;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (TableTaskDateRenren.state(taskName) == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(TableTaskDateRenren.state(taskName));
		}
	}

	public void stop() {
		flag = true;
	}

	public String taskName() {
		return taskName;
	}
}
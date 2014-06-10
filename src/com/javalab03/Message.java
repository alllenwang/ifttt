package com.javalab03;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
	public static boolean sendMessage(String userName, String message,
			String sendUserName) {
		if (sendUserName.isEmpty()
				|| (message.isEmpty() && message.length() < 200)
				|| !TableUser.checkUser(userName))
			return false;
		else {
			StringBuffer dateString = new StringBuffer();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			dateString = format.format(new Date(), dateString,
					new FieldPosition(0));
			String[] date = (new String(dateString)).split("[ ]");

			TableUserMessage.insert(userName, message, date[0], date[1],
					sendUserName);
			return true;
		}
	}

	public static boolean deleteMessage(String userName, String date,
			String time, String sendUserName) {
		if (userName.isEmpty() || date.isEmpty() || time.isEmpty()
				|| sendUserName.isEmpty())
			return false;
		else {
			TableUserMessage.delete(userName, date, time, sendUserName);
			return true;
		}
	}
}

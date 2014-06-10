package com.javalab03;
import java.util.ArrayList;
public class MessageInfoList 
{
	public String userName = null;
	public ArrayList<MessageInfo> MessageList = new ArrayList<MessageInfo>();
	public MessageInfoList(String userName) {
		this.userName = userName;
		MessageList = TableUserMessage.MessageInfo(this.userName);
	}
}

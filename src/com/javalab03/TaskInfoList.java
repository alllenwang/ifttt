package com.javalab03;
import java.util.ArrayList;
public class TaskInfoList 
{
	public String userName = null;
	public ArrayList<TaskInfo> TaskList = null;
	public TaskInfoList(String userName) {
		this.userName = userName;
		TaskList = TableUser.TaskInfo(this.userName);
	}
	
}

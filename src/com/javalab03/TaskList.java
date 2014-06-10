package com.javalab03;

import java.util.ArrayList;

public class TaskList {

	public static ArrayList<Task> taskList = new ArrayList<Task>();

	public static int getSize() {
		return taskList.size();
	}

	public static void add(Task a) {
		taskList.add(a);
	}

	public static void delete(String taskName) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).taskName.equals("taskName")) {
				taskList.remove(i);
				break;
			}
		}
	}

	public static Task getTask(String taskName) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).taskName.equals(taskName)) {
				return taskList.get(i);
			}
		}
		return null;
	}
}

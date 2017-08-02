package com.susan.baskota.dao;
import com.susan.baskota.entity.Task;

public interface TaskDao {

	void createTask(Task task);
	void updateTask(Task task);
	void deleteTask(Task task);
	void readTask();
}

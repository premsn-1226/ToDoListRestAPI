package com.project.todolist.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TodoList")
public class ToDoListEntity {

	private int userId;
	private String username;
	@Id
	private int taskId;
	
	private String taskTitle;
	@Column(name = "taskDescription")
	private String taskDes;
	private String targetDate;
	private String completionDate;
	private String category;
	private String status;
	private boolean important;
	
	public ToDoListEntity() {}
	public ToDoListEntity(int userId, String username, int taskId, String taskTitle, String taskDes, String targetDate,
			String completionDate, String category, String status, boolean important) {
		super();
		this.userId = userId;
		this.username = username;
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDes = taskDes;
		this.targetDate = targetDate;
		this.completionDate = completionDate;
		this.category = category;
		this.status = status;
		this.important = important;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	
}

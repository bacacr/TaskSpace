package com.taskspace.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class TaskDTO 
{
	@Id
	@Column(name="TASK_ID")
	private int taskId;
	@Column(name="PRIORITY")
	private int taskPriority;
	@Column(name="DESCRIPTION")
	private String taskDescription;
	@Column(name="ASSIGNED_TO")
	private String taskAssignedTo;
	@Column(name="PROJECT_ID")
	private int projectId;
	@Column(name="TASK_COLOR")
	private String taskColor;
	/**
	 * Getters and setters for each task
	 * the user creates
	 * @return
	 */
	
	public int getTaskId() 
	{
		return taskId;
	}
	
	public void setTaskId(int taskId) 
	{
		this.taskId = taskId;
	}
	
	public String getTaskDescription() 
	{
		return taskDescription;
	}
	
	public void setTaskDescription(String taskDescription) 
	{
		this.taskDescription = taskDescription;
	}
	
	
	public int getTaskPriority() 
	{
		return taskPriority;
	}
	
	public void setTaskPriority(int taskPriority) 
	{
		this.taskPriority = taskPriority;
	}
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTaskAssignedTo() {
		return taskAssignedTo;
	}
	public void setTaskAssignedTo(String taskAssignedTo) {
		this.taskAssignedTo = taskAssignedTo;
	}
	public String getTaskColor() 
	{
		return taskColor;
	}
	
	public void setTaskColor(String taskColor) 
	{
		this.taskColor = taskColor;
	}
}
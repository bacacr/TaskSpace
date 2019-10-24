package com.taskspace.dto;

public class TaskDTO 
{
	private int[] taskList;
	private int taskId;
	private int taskLocation;
	private int taskPriorityLevel;
	private String taskColor;
	private boolean isUpdated;
	private boolean isTaskShareable;
	private int projectId;
	private String assignedTo;
	
	/**
	 * Getters and setters for each task
	 * the user creates
	 * @return
	 */
	public int[] getTaskList() 
	{
		return taskList;
	}
	
	public void setTaskList(int[] taskList) 
	{
		this.taskList = taskList;
	}
	
	public int getTaskId() 
	{
		return taskId;
	}
	
	public void setTaskId(int taskId) 
	{
		this.taskId = taskId;
	}
	
	public int getTaskLocation() 
	{
		return taskLocation;
	}
	
	public void setTaskLocation(int taskLocation) 
	{
		this.taskLocation = taskLocation;
	}
	
	public int getTaskPriorityLevel() 
	{
		return taskPriorityLevel;
	}
	
	public void setTaskPriorityLevel(int taskPriorityLevel) 
	{
		this.taskPriorityLevel = taskPriorityLevel;
	}
	
	public String getTaskColor() 
	{
		return taskColor;
	}
	
	public void setTaskColor(String taskColor) 
	{
		this.taskColor = taskColor;
	}
	
	public boolean isUpdated() 
	{
		return isUpdated;
	}
	
	public void setUpdated(boolean isUpdated) 
	{
		this.isUpdated = isUpdated;
	}
	
	public boolean isTaskShareable() 
	{
		return isTaskShareable;
	}
	
	public void setTaskShareable(boolean isTaskShareable) 
	{
		this.isTaskShareable = isTaskShareable;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
}
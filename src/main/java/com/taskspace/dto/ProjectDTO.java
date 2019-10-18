package com.taskspace.dto;

public class ProjectDTO 
{
	private int projectId;
	private String projectName;
	private int projectOwnerId;
	
	public int getProjectId() 
	{
		return projectId;
	}
	
	public void setProjectId(int projectId) 
	{
		this.projectId = projectId;
	}
	
	public String getProjectName() 
	{
		return projectName;
	}
	
	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}
	
	public int getProjectOwnerId() 
	{
		return projectOwnerId;
	}
	
	public void setProjectOwnerId(int projectOwnerId) 
	{
		this.projectOwnerId = projectOwnerId;
	}
}

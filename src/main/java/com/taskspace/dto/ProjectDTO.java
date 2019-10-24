package com.taskspace.dto;

public class ProjectDTO 
{
	private int projectId;
	private String projectName;
	private int projectOwnerId;
	private int linkId;
	private boolean isShareable;
	
	/**
	 * Getters and setters for each project
	 * the user creates
	 * @return
	 */
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
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public boolean getIsShareable() {
		return isShareable;
	}
	public void setIsShareable(boolean isShareable) {
		this.isShareable = isShareable;
	}
}

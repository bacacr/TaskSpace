package com.taskspace.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class ProjectDTO 
{
	@Id
	@Column(name="PROJECT_ID")
	private int projectId;
	@Column(name="NAME")
	private String projectName;
	@Column(name="DESCRIPTION")
	private String projectDesc;
	@Column(name="MEMBERS")
	private String projectMembers;
	//private int linkId;
	//private boolean isShareable;
	
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
	
	public String getProjectDesc() 
	{
		return projectDesc;
	}
	
	public void setProjectDesc(String projectDesc) 
	{
		this.projectDesc = projectDesc;
	}
	
	public String getProjectMembers() 
	{
		return projectMembers;
	}
	
	public void setProjectMembers(String projectMembers) 
	{
		this.projectMembers = projectMembers;
	}
	/*
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
	*/
}

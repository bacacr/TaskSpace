package com.taskspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.taskspace.dto.ProjectDTO;
@Component
public class ProjectServiceStub implements IProjectService{
	
	@Override
	public ProjectDTO fetchByProjectId(int projectId) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(projectId);
		projectDTO.setProjectName("Name");
		projectDTO.setProjectDesc("Description");
		projectDTO.setProjectMembers("Tyler, Richard, Arnold");
		return projectDTO;
	}
	
	@Override
	public List<ProjectDTO> fetchAllProjects(int linkId) {
		int i = 0;
		List<ProjectDTO> projectList = new ArrayList<ProjectDTO>();
		while(i < 10) {
			ProjectDTO projectDTO = new ProjectDTO();
			projectDTO.setProjectId(i);
			projectDTO.setProjectName("Name");
			projectDTO.setProjectDesc("Description");
			projectDTO.setProjectMembers("Tom, Abigail, Nikolai, Brianna");
			projectList.add(projectDTO);
			i++;
		}
		return projectList;
	}
}
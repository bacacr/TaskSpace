package com.taskspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskspace.dao.ProjectRepository;
import com.taskspace.dto.ProjectDTO;
@Component
public class ProjectServiceStub implements IProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
	
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
	public List<ProjectDTO> fetchAllProjects() {
		return (List<ProjectDTO>) projectRepository.findAll();
	}

	@Override
	public List<ProjectDTO> fetchAllProjects(int linkId) {
		// TODO Auto-generated method stub
		return null;
	}
}
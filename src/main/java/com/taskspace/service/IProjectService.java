package com.taskspace.service;

import java.util.List;
import com.taskspace.dto.ProjectDTO;

public interface IProjectService {

	ProjectDTO fetchByProjectId(int projectId);

	List<ProjectDTO> fetchAllProjects(int linkId);
}

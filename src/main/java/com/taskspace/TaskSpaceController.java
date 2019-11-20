package com.taskspace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskspace.dto.ProjectDTO;
import com.taskspace.dto.TaskDTO;
import com.taskspace.service.IProjectService;
import com.taskspace.service.ITaskService;

/**
 * @author Administrator
 * Added request to map to new endpoint
 */
@Controller
public class TaskSpaceController {

	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private IProjectService projectService;
	
	@GetMapping("/tasks")
	public String createTasks(Model model) {
		TaskDTO taskDTO = taskService.fetchByTaskId(10);
		List<TaskDTO> taskList = taskService.fetchAllTasks(20);
		model.addAttribute("taskDTO", taskDTO);
		model.addAttribute("taskList", taskList);
		return "tasks";
	}
	
	@GetMapping("/projects")
	public String createProjects(Model model) {
		ProjectDTO projectDTO = projectService.fetchByProjectId(10);
		List<ProjectDTO> projectList = projectService.fetchAllProjects(20);
		model.addAttribute("projectDTO", projectDTO);
		model.addAttribute("projectList", projectList);
		return "projects";
	}
	@GetMapping("/grid")
	public String createGrid(Model model) {
		List<TaskDTO> taskList = taskService.fetchTasksForGrid(20);
		List<TaskDTO> taskWorking = taskService.fetchInProgressTasks(taskList);
		List<TaskDTO> taskOpen = taskService.fetchOpenTasks(taskList);
		model.addAttribute("taskWorking", taskWorking);
		model.addAttribute("taskOpen", taskOpen);
		return "grid";
	}
}

package com.taskspace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taskspace.dao.TaskRepository;
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
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public String createTasks(Model model) {
		TaskDTO taskDTO = taskService.fetchByTaskId(10);
		List<TaskDTO> taskList = taskService.fetchAllTasks(20);
		model.addAttribute("taskDTO", taskDTO);
		model.addAttribute("taskList", taskList);
		return "tasks";
	}
	
	@GetMapping("/taskBoard")
	public String getTaskBoard(Model model) {
		List<TaskDTO> taskList = taskRepository.findAllProjectTasks(10);
		List<TaskDTO> taskWorking = taskService.fetchInProgressTasks(taskList);
		List<TaskDTO> taskOpen = taskService.fetchOpenTasks(taskList);
		model.addAttribute("taskWorking", taskWorking);
		model.addAttribute("taskOpen", taskOpen);
		return "grid";
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
	@GetMapping("/addTask")
	public String addTask(@ModelAttribute("newTask") TaskDTO form) {
		return "addTask";
	}
	@PostMapping("/addTask")
	public String addTaskSubmit(@ModelAttribute("newTask") TaskDTO form, RedirectAttributes redirectAttributes) {
		form.setProjectId(10);
		form.setTaskColor("#4A9FF9");
		taskRepository.save(form);
		return "redirect:/taskBoard";
	}

}

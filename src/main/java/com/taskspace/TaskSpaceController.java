package com.taskspace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taskspace.dao.ProjectRepository;
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
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/tasks")
	public String createTasks(Model model) {
		TaskDTO taskDTO = taskService.fetchByTaskId(10);
		List<TaskDTO> taskList = taskService.fetchAllTasks(20);
		model.addAttribute("taskDTO", taskDTO);
		model.addAttribute("taskList", taskList);
		return "tasks";
	}
	
	@GetMapping("/taskBoard")
	public String getTaskBoard(@ModelAttribute("newTask") TaskDTO form, @RequestParam("projectId") int projectId, Model model) {
		List<TaskDTO> taskList = taskRepository.findAllProjectTasks(projectId);
		List<TaskDTO> taskWorking = taskService.fetchInProgressTasks(taskList);
		List<TaskDTO> taskOpen = taskService.fetchOpenTasks(taskList);
		model.addAttribute("taskWorking", taskWorking);
		model.addAttribute("taskOpen", taskOpen);
		model.addAttribute("projectId", projectId);
		return "grid";
	}

	@GetMapping("/projects")
	public String createProjects(@ModelAttribute("newProject") ProjectDTO form, Model model) {
		Iterable<ProjectDTO> projectList = projectService.fetchAllProjects();
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
	@PostMapping("/addTask")
	public String addTaskSubmit(@ModelAttribute("newTask") TaskDTO form, RedirectAttributes redirectAttributes) {
		form.setProjectId(form.getProjectId());
		form.setTaskColor("#4A9FF9");
		taskRepository.save(form);
		return "redirect:/taskBoard?&projectId=" + form.getProjectId();
	}
	@GetMapping("/addTask")
	public String addProjectTask(@RequestParam("projectId") int projectId, @ModelAttribute("newTask") TaskDTO form, Model model) {
		model.addAttribute("projectId", projectId);
		return "addTask";
	}
	@GetMapping("/addProject")
	public String addNewProject(@ModelAttribute("newProject") ProjectDTO form) {
		return "addProject";
	}
	@PostMapping("/addProject")
	public String addProject(@ModelAttribute("newProject") ProjectDTO form, RedirectAttributes redirectAttributes) {
		projectRepository.save(form);
		return "redirect:/projects";
	}
}

package com.taskspace;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String getTaskBoard(@ModelAttribute("newTask") TaskDTO form,@ModelAttribute("editTask") TaskDTO task, @RequestParam("projectId") int projectId, Model model) {
		List<TaskDTO> taskList = taskRepository.findAllProjectTasks(projectId);
		List<TaskDTO> taskWorking = taskService.fetchInProgressTasks(taskList);
		List<TaskDTO> taskDone = taskService.fetchDoneTasks(taskList);
		List<TaskDTO> taskOpen = taskService.fetchOpenTasks(taskList);
		Optional<ProjectDTO> project = projectRepository.findById(projectId);
		ProjectDTO projectDTO = new ProjectDTO();
		if(project.isPresent()) {
			projectDTO = project.get();
		}
		model.addAttribute("taskWorking", taskWorking);
		model.addAttribute("taskOpen", taskOpen);
		model.addAttribute("taskDone", taskDone);
		model.addAttribute("projectId", projectId);
		model.addAttribute("project", projectDTO);
		return "taskBoard";
	}

	@GetMapping("/projects")
	public String createProjects(@ModelAttribute("newProject") ProjectDTO form, @ModelAttribute("editProject") ProjectDTO project, Model model) {
		Iterable<ProjectDTO> projectList = projectService.fetchAllProjects();
		model.addAttribute("projectList", projectList);
		return "projects";
	}
	@PostMapping("/addTask")
	public String addTaskSubmit(@ModelAttribute("newTask") TaskDTO form, RedirectAttributes redirectAttributes) {
		taskRepository.save(form);
		return "redirect:/taskBoard?&projectId=" + form.getProjectId();
	}
	@PostMapping("/addProject")
	public String addProject(@ModelAttribute("newProject") ProjectDTO form, RedirectAttributes redirectAttributes) {
		projectRepository.save(form);
		return "redirect:/projects";
	}
	@RequestMapping(value="/updateTaskColor", method= RequestMethod.POST, headers = {"Content-type=application/json"})
	public String updateTaskColor(@RequestBody TaskDTO task) {
		taskRepository.updateTaskColor(task.getTaskColor(), task.getTaskId());
		return "redirect:/taskBoard?&projectId=" + task.getProjectId();
	}
	@PostMapping("/editTask")
	public String editTask(@ModelAttribute("editTask") TaskDTO form, RedirectAttributes redirectAttributes) {
		taskRepository.editTask(form.getTaskId(), form.getTaskDescription(), form.getTaskAssignedTo(), form.getTaskPriority());
		return "redirect:/taskBoard?&projectId=" + form.getProjectId();
	}
	@RequestMapping(value="/deleteTask", method= RequestMethod.POST, headers = {"Content-type=application/json"})
	public String deleteTask(@RequestBody TaskDTO task) {
		taskRepository.deleteTask(task.getTaskId());
		return "redirect:/taskBoard?&projectId=" + task.getProjectId();
	}
	@PostMapping("/editProject")
	public String editProject(@ModelAttribute("editProject") ProjectDTO form, RedirectAttributes redirectAttributes) {
		projectRepository.editProject(form.getProjectId(), form.getProjectDesc(), form.getProjectMembers(), form.getProjectName());
		return "redirect:/projects";
	}
	@RequestMapping(value="/deleteProject", method= RequestMethod.POST, headers = {"Content-type=application/json"})
	public String deleteProject(@RequestBody ProjectDTO project) {
		projectRepository.deleteProject(project.getProjectId());
		taskRepository.deleteTasks(project.getProjectId());
		return "redirect:/projects";
	}
}

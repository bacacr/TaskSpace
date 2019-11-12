package com.taskspace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskspace.dto.TaskDTO;
import com.taskspace.service.ITaskService;

/**
 * @author Administrator
 * Added request to map to new endpoint
 */
@Controller
public class TaskSpaceController {

	@Autowired
	private ITaskService taskService;
	
	@GetMapping("/tasks")
	public String createTasks(Model model) {
		TaskDTO taskDTO = taskService.fetchByTaskId(10);
		List<TaskDTO> taskList = taskService.fetchAllTasks(20);
		model.addAttribute("taskDTO", taskDTO);
		model.addAttribute("taskList", taskList);
		return "tasks";
	}
}

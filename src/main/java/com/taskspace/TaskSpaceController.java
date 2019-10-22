package com.taskspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taskspace.dto.TaskDTO;

/**
 * @author Administrator
 * Added request to map to new endpoint
 */
@Controller
public class TaskSpaceController {
	
	
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String read() {
		
		return "start";
	}
	
	@RequestMapping(value = "/taskList/:projectId", method = RequestMethod.GET)
	public int[] getTaskList() {
		int[] taskList = {3, 4, 5};
		return taskList;
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST, consumes= "text/json")
	public TaskDTO addToTaskList(@RequestBody String newTask) {
		//Insert method to add task to project
		//Below is a placeholder for return of above method
		TaskDTO createdTask = new TaskDTO();
		return createdTask;
	}
	
	@RequestMapping(value = "/start", method = RequestMethod.GET, headers = {"content-type=text/json"})
	public String readJSON() {
		
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		
		return "start";
	}
	
	/**
	 * @author Administrator
	 * Handles the "/" endpoint
	 */
	@RequestMapping("/")
	public String index() {
			
		return "index";
	}
}

package com.taskspace.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.taskspace.dto.TaskDTO;

public class TaskDAO {
	
	@Autowired
	TaskRepository taskRepository;

	public TaskDTO[] getTaskList(int projectId) {
		return null;
		
	}
	public TaskDTO addToTaskList(TaskDTO newTask) {
		return newTask;
		
	}
	
	public boolean saveTask(TaskDTO newTask) {
		taskRepository.save(newTask);
		return false;
	}
	
	//public List<TaskDTO> getProjectTasks(int project) {
		//return taskRepository.getProjectTasks(project);
	//}
}

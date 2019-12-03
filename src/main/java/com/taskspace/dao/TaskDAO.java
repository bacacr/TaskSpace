package com.taskspace.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskspace.dto.TaskDTO;

@Component
public class TaskDAO {
	
	@Autowired
	TaskRepository taskRepository;
	
	public boolean saveTask(TaskDTO newTask) {
		taskRepository.save(newTask);
		return false;
	}
	public List<TaskDTO> fetchInProgressTasks(List<TaskDTO> tasks) {
		List<TaskDTO> taskWorking = new ArrayList<TaskDTO>();
		for (TaskDTO task: tasks) {
			if(task.getTaskColor().equals("#f9944a")) {
				taskWorking.add(task);
			}
		}
		if(taskWorking.isEmpty()) {
			TaskDTO task = new TaskDTO();
			taskWorking.add(task);
		}
		return taskWorking;
	}
	public List<TaskDTO> fetchDoneTasks(List<TaskDTO> tasks) {
		List<TaskDTO> taskDone = new ArrayList<TaskDTO>();
		for (TaskDTO task: tasks) {
			if(task.getTaskColor().equals("#2ac06d")) {
				taskDone.add(task);
			}
		}
		if(taskDone.isEmpty()) {
			TaskDTO task = new TaskDTO();
			taskDone.add(task);
		}
		return taskDone;
	}
	public List<TaskDTO> fetchOpenTasks(List<TaskDTO> tasks) {
		List<TaskDTO> taskOpen = new ArrayList<TaskDTO>();;
		for (TaskDTO task: tasks) {
			if(task.getTaskColor().equals("#4A9FF9")) {
				taskOpen.add(task);
			}
		}
		if(taskOpen.isEmpty()) {
			TaskDTO task = new TaskDTO();
			taskOpen.add(task);
		}
		return taskOpen;
	}
}

package com.taskspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskspace.dao.TaskRepository;
import com.taskspace.dto.TaskDTO;
@Component
public class TaskServiceStub implements ITaskService{
	@Autowired
	TaskRepository taskRepository;
	@Override
	public TaskDTO fetchByTaskId(int taskId) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskId(taskId);
		taskDTO.setTaskDescription("blue");
		taskDTO.setTaskPriority(5);
		taskDTO.setTaskAssignedTo("Thomas");
		return taskDTO;
	}
	
	@Override
	public List<TaskDTO> fetchAllTasks(int projectId) {
		int i = 0;
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		while(i < 10) {
			TaskDTO taskDTO = new TaskDTO();
			if(i % 2 == 0) {
				taskDTO.setTaskId(i);
				taskDTO.setTaskColor("blue");
				taskDTO.setTaskPriority(5);
				taskDTO.setTaskAssignedTo("Thomas");
			}
			else {
				taskDTO.setTaskId(i);
				taskDTO.setTaskColor("red");
				taskDTO.setTaskPriority(2);
				taskDTO.setTaskAssignedTo("David");
			}
			taskList.add(taskDTO);
			i++;
		}
		return taskList;
	}
	@Override
	public List<TaskDTO> fetchTasksForGrid(int projectId) {
		int i = 0;
		List<TaskDTO> taskList = new ArrayList<TaskDTO>();
		while(i < 10) {
			TaskDTO taskDTO = new TaskDTO();
			if(i % 2 == 0) {
				taskDTO.setTaskId(i);
				taskDTO.setTaskColor("#4A9FF9");
				taskDTO.setTaskPriority(5);
				taskDTO.setTaskAssignedTo("Thomas");
			}
			else {
				taskDTO.setTaskId(i);
				taskDTO.setTaskColor("#f9944a");
				taskDTO.setTaskPriority(2);
				taskDTO.setTaskAssignedTo("David");
			}
			taskList.add(taskDTO);
			i++;
		}
		return taskList;
	}
	@Override
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
	@Override
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
	@Override
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
	
	@Override
	public List<TaskDTO> fetchTasks(int projectId) {
		
		return (List<TaskDTO>) taskRepository.findAllProjectTasks(projectId);
	}
}

package com.taskspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.taskspace.dao.TaskDAO;
import com.taskspace.dao.TaskRepository;
import com.taskspace.dto.TaskDTO;
@Component
public class TaskServiceStub implements ITaskService{
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	TaskDAO taskDAO;
	
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
		return taskDAO.fetchInProgressTasks(tasks);
	}
	@Override
	public List<TaskDTO> fetchDoneTasks(List<TaskDTO> tasks) {
		return taskDAO.fetchDoneTasks(tasks);
	}
	@Override
	public List<TaskDTO> fetchOpenTasks(List<TaskDTO> tasks) {
		return taskDAO.fetchOpenTasks(tasks);
	}
	
	@Override
	public List<TaskDTO> fetchTasks(int projectId) {
		
		return (List<TaskDTO>) taskRepository.findAllProjectTasks(projectId);
	}
}

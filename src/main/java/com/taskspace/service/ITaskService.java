package com.taskspace.service;

import java.util.List;

import com.taskspace.dto.TaskDTO;

public interface ITaskService {

	TaskDTO fetchByTaskId(int taskId);

	List<TaskDTO> fetchAllTasks(int projectId);
	public List<TaskDTO> fetchTasksForGrid(int projectId);
	List<TaskDTO> fetchInProgressTasks(List<TaskDTO> tasks);
	List<TaskDTO> fetchOpenTasks(List<TaskDTO> tasks);

}

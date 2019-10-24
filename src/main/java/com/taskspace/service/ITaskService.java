package com.taskspace.service;

import java.util.List;

import com.taskspace.dto.TaskDTO;

public interface ITaskService {

	TaskDTO fetchByTaskId(int taskId);

	List<TaskDTO> fetchAllTasks(int projectId);

}

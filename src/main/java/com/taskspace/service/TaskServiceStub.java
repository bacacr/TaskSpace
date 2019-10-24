package com.taskspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.taskspace.dto.TaskDTO;
@Component
public class TaskServiceStub implements ITaskService{
	
	@Override
	public TaskDTO fetchByTaskId(int taskId) {
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTaskId(taskId);
		taskDTO.setTaskColor("blue");
		taskDTO.setTaskPriorityLevel(5);
		taskDTO.setAssignedTo("Thomas");
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
				taskDTO.setTaskPriorityLevel(5);
				taskDTO.setAssignedTo("Thomas");
			}
			else {
				taskDTO.setTaskId(i);
				taskDTO.setTaskColor("red");
				taskDTO.setTaskPriorityLevel(2);
				taskDTO.setAssignedTo("David");
			}
			taskList.add(taskDTO);
			i++;
		}
		return taskList;
	}
}

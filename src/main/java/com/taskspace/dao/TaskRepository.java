package com.taskspace.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.taskspace.dto.TaskDTO;

public interface TaskRepository extends CrudRepository<TaskDTO, Integer> {
	
	@Query("SELECT t FROM TaskDTO t WHERE t.projectId = :project")
	List<TaskDTO> findAllProjectTasks(int project);

}

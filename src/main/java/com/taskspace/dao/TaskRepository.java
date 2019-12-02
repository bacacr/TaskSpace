package com.taskspace.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.taskspace.dto.TaskDTO;

public interface TaskRepository extends CrudRepository<TaskDTO, Integer> {
	
	@Query("SELECT t FROM TaskDTO t WHERE t.projectId = :project ORDER BY t.taskPriority DESC")
	List<TaskDTO> findAllProjectTasks(int project);
	
	@Transactional
	@Modifying
	@Query("UPDATE TaskDTO t SET t.taskColor = :taskColor WHERE t.taskId = :taskId")
	void updateTaskColor(@Param("taskColor") String taskColor, @Param("taskId") int taskId);
}

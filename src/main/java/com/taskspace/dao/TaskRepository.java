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
	
	@Transactional
	@Modifying
	@Query("UPDATE TaskDTO t SET t.taskDescription = :taskDescription, t.taskAssignedTo = :taskAssignedTo, t.taskPriority = :taskPriority WHERE t.taskId = :taskId")
	void editTask(@Param("taskId") int taskId, @Param("taskDescription") String taskDescription, @Param("taskAssignedTo") String taskAssignedTo,@Param("taskPriority") int taskPriority);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM TaskDTO t WHERE t.taskId = :taskId")
	void deleteTask(@Param("taskId") int taskId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM TaskDTO t WHERE t.projectId = :projectId")
	void deleteTasks(@Param("projectId") int projectId);
}

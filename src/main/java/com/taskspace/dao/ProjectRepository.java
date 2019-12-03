package com.taskspace.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.taskspace.dto.ProjectDTO;

public interface ProjectRepository extends CrudRepository<ProjectDTO, Integer> {
	@Transactional
	@Modifying
	@Query("DELETE FROM ProjectDTO p WHERE p.projectId = :projectId")
	void deleteProject(@Param("projectId") int projectId);
	
	@Transactional
	@Modifying
	@Query("UPDATE ProjectDTO p SET p.projectDesc = :projectDesc, p.projectMembers = :projectMembers, p.projectName = :projectName WHERE p.projectId = :projectId")
	void editProject(@Param("projectId") int projectId, @Param("projectDesc") String projectDesc, @Param("projectMembers") String projectMembers, @Param("projectName") String projectName);
}

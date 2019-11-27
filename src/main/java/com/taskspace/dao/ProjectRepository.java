package com.taskspace.dao;

import org.springframework.data.repository.CrudRepository;

import com.taskspace.dto.ProjectDTO;

public interface ProjectRepository extends CrudRepository<ProjectDTO, Integer> {

}

package de.vw.f73.docker.exercise.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.vw.f73.docker.exercise.backend.entity.ToDo;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long>{

    
}
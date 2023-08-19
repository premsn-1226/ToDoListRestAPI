package com.project.todolist.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.todolist.Entity.ToDoListEntity;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Integer> {

	List<ToDoListEntity> findByStatus(String status);

}

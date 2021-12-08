package com.todolist.run.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.todolist.run.Entity.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long>{
	
	List<TodoList> findTodoListById(Long id);
	
	@Modifying
	@Query("update TodoList t set t.status = ?2 where t.id = ?1")
	boolean updateStatusById(Long id, boolean status);
}

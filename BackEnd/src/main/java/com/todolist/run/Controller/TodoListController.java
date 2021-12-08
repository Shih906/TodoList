package com.todolist.run.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.run.Entity.TodoList;
import com.todolist.run.Repository.TodoListRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@ResponseBody()
public class TodoListController {

	@Autowired
	private TodoListRepository todoListRepository;
	
	@GetMapping("/todoList")
	public List<TodoList> getAllTodoList(){
		return todoListRepository.findAll();
	}
	
	@GetMapping("/todoList/{id}")
	public List<TodoList> getTodoListById(@PathVariable("id")Long id){
		return todoListRepository.findTodoListById(id);
	}
	
	@PostMapping("/todoList")
	public TodoList createTodoList(@RequestBody TodoList todoList) {
		return todoListRepository.save(todoList);
	}
	
	@PutMapping("/todoList/{id}")
	public void updateTodoListById(@PathVariable("id") long id,@RequestBody TodoList todolist) {
		todolist.getId();
		Optional<TodoList> todoItem = todoListRepository.findById(id);
		if (todoItem.isPresent()) {
			todoListRepository.save(todolist);
		}
		
	}	
	@DeleteMapping("/todoList/{id}")
	public void deleteTodoListById(@PathVariable("id")Long id) {
		todoListRepository.deleteById(id);
	}
	
	@DeleteMapping("/todoList")
	public void deleteTodoList() {
		todoListRepository.deleteAll();
	}

}

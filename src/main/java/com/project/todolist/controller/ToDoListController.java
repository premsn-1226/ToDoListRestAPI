package com.project.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.todolist.Entity.ToDoListEntity;
import com.project.todolist.Exception.AlreadyTaskExistsException;
import com.project.todolist.Exception.RecordNotFoundException;
import com.project.todolist.Repository.ToDoListRepository;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/todolist")
//@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
public class ToDoListController implements ErrorController {
	
	@Autowired
	private ToDoListRepository todolist;
	
	@RequestMapping("/error")
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Please check the api url")
    public String handleErrors() {
        return "";
    }
		
	@GetMapping("/getTaskList")
	
	public List<ToDoListEntity> getTaskList() throws RecordNotFoundException {
		try {
			List<ToDoListEntity> res = null;
		System.out.println("Api hit for getting task list");
		res = todolist.findAll();
		System.out.println("result : "+res);
		if(res == null) {
			throw new RecordNotFoundException("Eror in Fetching the task");
		}
		return res;
	}catch(IllegalArgumentException e) {
		throw new IllegalArgumentException("Please check the data entered");
	}
	}
	
	@GetMapping("/getStatus")
	public List<ToDoListEntity> getStatus(@RequestParam String status) throws RecordNotFoundException {
		try {
			List<ToDoListEntity> res =null;
		System.out.println("Api hit for "+status+" status");
		res = todolist.findByStatus(status);
		System.out.println("result : "+res);
		if(res == null) {
			throw new RecordNotFoundException("Eror in Fetching the task");
		}
		return res;
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Please check the data entered");
		}
	}
	
	public boolean getTaskbyId(int id) {
		Optional<ToDoListEntity> res = todolist.findById(id);
		if(!res.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	@PostMapping("/addTask")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "Task added successfully in the database")
	public String addTask(@RequestBody ToDoListEntity data) throws AlreadyTaskExistsException {
		try {
			if(getTaskbyId(data.getTaskId())) {
				todolist.save(data);	
			}else {
				throw new AlreadyTaskExistsException("The specified task id is already present in database");
			}
			return "";
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Please check the data entered");
		}
	}
	
}

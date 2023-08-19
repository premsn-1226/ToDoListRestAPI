package com.project.todolist.Exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AlreadyTaskExistsException.class)
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Task already exists")
	public String handleAlreadyExistsException(AlreadyTaskExistsException e){
		return "";		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error in fetching or updating the task")
	public String handleAlreadyExistsException(IllegalArgumentException e){
		return "";		
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error in Fetching the task")
	public String handleRecordNotFoundException(RecordNotFoundException e){
		return "";		
	}
}

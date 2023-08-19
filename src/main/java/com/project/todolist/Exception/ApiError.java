package com.project.todolist.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.todolist.Entity.ToDoListEntity;

public class ApiError {
	private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private String data;
	   private HttpStatus link;
	   //private List<ApiSubError> subErrors;

	   public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   ApiError(HttpStatus status, String message, String todo, HttpStatus link) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.data = todo;
	       this.link = link;
	   }
}

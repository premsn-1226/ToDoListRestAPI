package com.project.todolist.Exception;

public class AlreadyTaskExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AlreadyTaskExistsException() {}
	public AlreadyTaskExistsException(String s) {
		super(s);
		}
	
}

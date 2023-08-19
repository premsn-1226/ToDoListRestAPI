package com.project.todolist.Exception;

public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public RecordNotFoundException() {}
	public RecordNotFoundException(String s) {
		super(s);
		}
}

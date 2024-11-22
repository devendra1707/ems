package com.ems.department.exception;

public class DepartmentNotFoundException extends RuntimeException {

	public DepartmentNotFoundException(String msg) {
		super(msg);
	}
}

package com.assignment.exception;

public class SomethingWentWrong extends RuntimeException {

	private String message;

	public SomethingWentWrong() {
		super();
	}

	/**
	 * @param message
	 */
	public SomethingWentWrong(String message) {
		super();
		this.message = message;
	}

}

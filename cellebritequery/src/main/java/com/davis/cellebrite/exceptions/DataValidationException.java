package com.davis.cellebrite.exceptions;

public class DataValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataValidationException() {
		super();
	}


	public DataValidationException(String msg, Throwable arg1) {
		super(msg, arg1);
	}

	public DataValidationException(String msg) {
		super(msg);
	}

	

}

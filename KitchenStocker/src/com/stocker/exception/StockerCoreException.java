package com.stocker.exception;

public class StockerCoreException extends Exception {
	private static final long serialVersionUID = 1L;

	public StockerCoreException() {
		super();

	}

	public StockerCoreException(String message) {
		super(message);
	}

	public StockerCoreException(String message, Exception e) {
		super(message, e);
	}
}

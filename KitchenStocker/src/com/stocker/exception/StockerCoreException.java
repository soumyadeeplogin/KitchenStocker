package com.stocker.exception;

public class StockerCoreException extends Exception {

	public StockerCoreException() {
		super();

	}

	public StockerCoreException(String message) {
		super(message);
	}

	public StockerCoreException(String message, Exception e) {
		super(message, e);
	}

	public StockerCoreException(Exception e) {
		super(e);
	}
}

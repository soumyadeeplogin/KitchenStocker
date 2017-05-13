package com.stocker.core;

public class StockerBaseResult<Result> {
	private Result result;

	/**
	 * 
	 */
	public StockerBaseResult() {
		super();
	}

	public StockerBaseResult(Result result) {
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}

}

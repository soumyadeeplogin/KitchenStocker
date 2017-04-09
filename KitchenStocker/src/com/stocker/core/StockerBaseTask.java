package com.stocker.core;

import com.stocker.exception.StockerCoreException;

/**
 * Base class to maintain the flow of controls in the project
 * 
 * @author amar
 *
 */
public abstract class StockerBaseTask {

	/**
	 * method to initialize all the required hibernate configuration
	 * 
	 * @throws StockerCoreException
	 */
	public void init() throws StockerCoreException {

	}

	/**
	 * closes all the connections
	 * 
	 * @throws StockerCoreException
	 */
	public void close() throws StockerCoreException {

	}

	/**
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	public StockerBaseResult<Object> execute() throws StockerCoreException {
		StockerBaseResult<Object> stockerBaseResult = new StockerBaseResult<>();
		try {
			stockerBaseResult = executeTask();
		} catch (Exception e) {
			throw new StockerCoreException(e);
		}
		return stockerBaseResult;
	}

	/**
	 * 
	 * @throws StockerCoreException
	 */
	protected abstract void validateParameter() throws StockerCoreException;

	/**
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	protected abstract StockerBaseResult<Object> executeTask() throws StockerCoreException;

}

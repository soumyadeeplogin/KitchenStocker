package com.stocker.core;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.stocker.exception.StockerCoreException;

/**
 * Base class to maintain the flow of controls in the project
 * 
 * @author amar
 *
 */
public abstract class StockerBaseTask<T> {

	/**
	 * method to initialize all the required hibernate configuration
	 * 
	 * @throws StockerCoreException
	 */
	public void init(StockerSession session, StockerStorageContext context) throws StockerCoreException {
		/*
		 * todo : session check for existance of session
		 */

		Transaction transaction = null;
		try {
			transaction = context.getHibernateSession().beginTransaction();
			context.setTransaction(transaction);
		} catch (HibernateException | StockerCoreException e) {
			throw new StockerCoreException(e);
		}
	}

	/**
	 * closes all the connections
	 * 
	 * @throws StockerCoreException
	 */
	public void close(StockerSession session, StockerStorageContext context) throws StockerCoreException {
		try {
			context.close();
		} catch (Exception e) {
			throw new StockerCoreException(e);
		}
	}

	/**
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	public StockerBaseResult<T> executeTask(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult<T> result = null;
		try {
			init(session, context);
			validateParameter(session, context);
			result = execute(session, context);
			context.commitTransaction();
		} catch (Exception e) {
			context.rollbackTransaction();
			throw new StockerCoreException(e);
		} finally {
			try {
				close(session, context);
			} catch (Exception e) {
				throw new StockerCoreException(e);
			}
		}
		return result;
	}

	/**
	 * 
	 * @throws StockerCoreException
	 */
	protected abstract void validateParameter(StockerSession session, StockerStorageContext context)
			throws StockerCoreException;

	/**
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	protected abstract StockerBaseResult<T> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException;

}

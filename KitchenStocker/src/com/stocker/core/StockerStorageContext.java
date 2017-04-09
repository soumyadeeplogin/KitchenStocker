/**
 * 
 */
package com.stocker.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class StockerStorageContext {
	private SessionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Transaction transaction = null;

	/**
	 * Constructor to initialize the StockerStorageContext object
	 * 
	 * @throws StockerCoreException
	 */
	public StockerStorageContext() throws StockerCoreException {
		try {
			init();
		} catch (StockerCoreException sce) {
			throw sce;
		}
	}

	/**
	 * Bundles the step to initialize the StockerStorageContext object
	 * 
	 * @throws StockerCoreException
	 */
	private void init() throws StockerCoreException {
		createFactory();
		createConnection();
		openHibernateSession();
	}

	/**
	 * Opens hibernate session
	 * 
	 * @throws StockerCoreException
	 */
	private void openHibernateSession() throws StockerCoreException {
		try {
			if (session == null) {
				session = factory.openSession();
			}
		} catch (HibernateException he) {
			throw new StockerCoreException(he);
		}

	}

	/**
	 * Creates Session Factory object
	 * 
	 * @throws StockerCoreException
	 */
	private void createFactory() throws StockerCoreException {
		try {
			Configuration configuration = new Configuration();
			factory = configuration.configure().buildSessionFactory();
		} catch (Exception ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new StockerCoreException(ex);
		}
	}

	/**
	 * Creates simple JDBC connection
	 * 
	 * @throws StockerCoreException
	 */
	private void createConnection() throws StockerCoreException {
		try {
			instantiateDatabaseDriverClass();
			connection = DriverManager.getConnection(
					"jdbc:mysql://stocker.cc2ml4k9vlsh.us-west-2.rds.amazonaws.com:3306/stocker", "rootstocker",
					"r00tst0cker");
		} catch (StockerCoreException | SQLException e) {
			throw new StockerCoreException(e);
		}
	}

	/**
	 * Checks for the existance of driver class
	 * 
	 * @throws StockerCoreException
	 */
	private void instantiateDatabaseDriverClass() throws StockerCoreException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new StockerCoreException(e);
		}
	}

	/**
	 * Bundles the steps to close a Hibernate connection
	 * 
	 * @throws StockerCoreException
	 */
	public void close() throws StockerCoreException {
		try {
			closeSession();
			closeConnection();
			closeFactory();
		} catch (StockerCoreException sce) {
			throw sce;
		}
	}

	/**
	 * commits the transaction in progress.
	 * 
	 * @throws StockerCoreException
	 */
	public void commitTransaction() throws StockerCoreException {
		try {
			if (transaction != null)
				transaction.commit();
		} catch (HibernateException he) {
			throw new StockerCoreException(he.getMessage());
		}
	}

	/**
	 * rollbacks the current ongoing transaction if something fails
	 * 
	 * @throws StockerCoreException
	 */
	public void rollbackTransaction() throws StockerCoreException {
		try {
			if (transaction != null)
				transaction.rollback();
		} catch (HibernateException he) {
			throw new StockerCoreException(he.getMessage());
		}
	}

	/**
	 * closes the session
	 * 
	 * @throws StockerCoreException
	 */
	private void closeSession() throws StockerCoreException {
		if (session != null) {
			try {
				session.flush();
				session.close();
			} catch (HibernateException hbe) {
				throw new StockerCoreException(hbe);
			}
		}
	}

	/**
	 * Closes the connection
	 * 
	 * @throws StockerCoreException
	 */
	private void closeConnection() throws StockerCoreException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new StockerCoreException(e);
			}
		}
	}

	/**
	 * Closes the Factory
	 * 
	 * @throws StockerCoreException
	 */
	private void closeFactory() throws StockerCoreException {
		if (factory != null) {
			try {
				factory.close();
			} catch (HibernateException hbe) {
				throw new StockerCoreException(hbe);
			}
		}
	}

	/**
	 * Retruns the Hibernate session
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	public Session getHibernateSession() throws StockerCoreException {
		if (factory == null)
			init();
		return session;
	}

	/**
	 * Returns the plane JDBC connection object
	 * 
	 * @return
	 * @throws StockerCoreException
	 */
	public Connection getConnection() throws StockerCoreException {
		if (connection == null)
			init();
		return connection;
	}

	/**
	 * getter for transaction
	 * 
	 * @return
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * setter for transaction
	 * 
	 * @param transaction
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}

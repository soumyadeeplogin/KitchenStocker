/**
 * 
 */
package com.stocker.department.tasks;

import com.stocker.core.StockerBaseResult;
import com.stocker.core.StockerBaseTask;
import com.stocker.core.StockerSession;
import com.stocker.core.StockerStorageContext;
import com.stocker.department.DepartmentStorageManager;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class DeleteDepartmentByIdTask extends StockerBaseTask {
	private int id;

	/**
	 * @param id
	 */
	public DeleteDepartmentByIdTask(int id) {
		super();
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.stocker.core.StockerBaseTask#validateParameter(com.stocker.core.
	 * StockerSession, com.stocker.core.StockerStorageContext)
	 */
	@Override
	protected void validateParameter(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stocker.core.StockerBaseTask#execute(com.stocker.core.StockerSession,
	 * com.stocker.core.StockerStorageContext)
	 */
	@Override
	protected StockerBaseResult execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		StockerBaseResult result = new StockerBaseResult();
		DepartmentStorageManager instance = DepartmentStorageManager.getInstance();
		instance.deleteDepartment(id, context);
		return result;
	}

}

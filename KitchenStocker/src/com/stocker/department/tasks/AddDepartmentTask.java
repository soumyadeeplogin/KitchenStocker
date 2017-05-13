/**
 * 
 */
package com.stocker.department.tasks;

import com.stocker.core.StockerBaseResult;
import com.stocker.core.StockerBaseTask;
import com.stocker.core.StockerSession;
import com.stocker.core.StockerStorageContext;
import com.stocker.department.DepartmentEntity;
import com.stocker.department.DepartmentStorageManager;
import com.stocker.exception.StockerCoreException;

/**
 * @author amar
 *
 */
public class AddDepartmentTask extends StockerBaseTask<Integer> {
	private DepartmentEntity departmentEntity;

	public AddDepartmentTask(DepartmentEntity departmentEntity) {
		this.departmentEntity = departmentEntity;
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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.stocker.core.StockerBaseTask#execute(com.stocker.core.StockerSession,
	 * com.stocker.core.StockerStorageContext)
	 */
	@Override
	protected StockerBaseResult<Integer> execute(StockerSession session, StockerStorageContext context)
			throws StockerCoreException {
		// Integer result = null;
		DepartmentStorageManager departmentStorageManager = DepartmentStorageManager.getInstance();
		Integer id = departmentStorageManager.addNewDepartment(departmentEntity, context);

		StockerBaseResult<Integer> stockerBaseResult = new StockerBaseResult<Integer>(id);
		return stockerBaseResult;
	}

}

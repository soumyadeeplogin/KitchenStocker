/**
 * 
 */
package com.stocker.category;

/**
 * @author amar
 *
 */
public class SubCategoryEntity extends CategoryEntity {
	private int parentCategoryId;

	/**
	 * 
	 */
	public SubCategoryEntity() {
		super();
	}

	/**
	 * @return the parentCategoryId
	 */
	public int getParentCategoryId() {
		return parentCategoryId;
	}

	/**
	 * @param parentCategoryId
	 *            the parentCategoryId to set
	 */
	public void setParentCategoryId(int parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

}

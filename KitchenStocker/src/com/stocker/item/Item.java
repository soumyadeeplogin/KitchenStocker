/**
 * 
 */
package com.stocker.item;

import java.sql.Date;

/**
 * @author amar
 *
 */
public class Item {
	private int id;
	private int categoryId;
	private int serialNo;
	private int subCategoryId;
	private int quantity;
	private Unit unit;
	private Date purchaseDate;
	private Date updateDate;

	/**
	 * 
	 */
	public Item() {
		super();
	}

	/**
	 * @param id
	 * @param categoryId
	 * @param serialNo
	 * @param subCategoryId
	 * @param quantity
	 * @param unit
	 * @param purchaseDate
	 * @param updateDate
	 */
	public Item(int id, int categoryId, int serialNo, int subCategoryId, int quantity, Unit unit, Date purchaseDate,
			Date updateDate) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.serialNo = serialNo;
		this.subCategoryId = subCategoryId;
		this.quantity = quantity;
		this.unit = unit;
		this.purchaseDate = purchaseDate;
		this.updateDate = updateDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the serialNo
	 */
	public int getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo
	 *            the serialNo to set
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @return the subCategoryId
	 */
	public int getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId
	 *            the subCategoryId to set
	 */
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate
	 *            the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

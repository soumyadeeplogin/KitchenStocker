/**
 * 
 */
package com.stocker.category;

import javax.persistence.*;

/**
 * @author amar
 *
 */
@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "dept_id")
	private int deptId;

	/**
	 * Default constructor
	 */
	public CategoryEntity() {
		super();
	}

	/**
	 * Constructor with all the fields
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param deptId
	 */
	public CategoryEntity(int id, String name, String description, int deptId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.deptId = deptId;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the deptId
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 *            the deptId to set
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}

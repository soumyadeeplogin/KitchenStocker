/**
 * 
 */
package com.stocker.department;

import javax.persistence.*;

/**
 * Class denoting the department entity
 * 
 * @author amar
 *
 */
@Entity
@Table(name = "department")
public class DepartmentEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	/**
	 * 
	 */
	public DepartmentEntity() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public DepartmentEntity(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

}

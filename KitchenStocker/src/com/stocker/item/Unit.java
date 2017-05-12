/**
 * 
 */
package com.stocker.item;

/**
 * @author amar
 *
 */
public enum Unit {
	KG("kg"), LTR("ltr"), PIECES("pcs");
	private final String value;

	private Unit(String value) {
		this.value = value;
	}

	public boolean equals(String value) {
		return value.equals(this.value);
	}

	public String toString() {
		return this.value;
	}

}

package com.pauloneto.jmsintegration.models;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;

	/**
	 * @deprecated frameworks only
	 */
	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

}

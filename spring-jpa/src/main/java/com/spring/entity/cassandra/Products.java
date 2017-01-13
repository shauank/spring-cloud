package com.spring.entity.cassandra;

import java.math.BigInteger;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Products {

	@PrimaryKey
	private int id;

	@Column
	private String name;

	@Column
	private BigInteger price;

	public Products() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigInteger getPrice() {
		return price;
	}

}

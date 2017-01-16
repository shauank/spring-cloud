package com.spring.cassandra.repo;

import java.util.List;

import com.spring.entity.cassandra.Products;

public interface ProductsRepositoryCustom {
	public List<Products> selectAll();
}

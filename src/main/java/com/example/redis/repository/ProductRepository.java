package com.example.redis.repository;

import java.util.Map;

import com.example.redis.model.Product;

public interface ProductRepository {

	/**
	 * @param product : Product information.
	 */
	void save(Product product);
	

	/**
	 * @param id : Product identifier.
	 * @return Product information.
	 */
	Product findById(String id);
	

	/**
	 * @return List of products.
	 */
	Map<String, Product> findAll();

	/**
	 * @param product : Product information. 
	 */
	void update(Product product);
	

	/**
	 * @param id : Product identifier.
	 */
	void delete(String id);
	
	
	

}

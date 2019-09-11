package com.example.redis.repository;

import java.util.Map;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.redis.model.Product;

/**
 * Product Repository Implementation
 * @author kalani
 *
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	
	
	private RedisTemplate<String, Product> redisTemplate; // use redisTemplate

	private HashOperations<String, String, Product> hashOperations;

	/**
	 * @param redisTemplate : Redis Template
	 */
	ProductRepositoryImpl(RedisTemplate<String, Product> redisTemplate) {

		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash(); //use hashOperation to access redisTemplate

	}
	
	

    
	@Override
	public void save(Product product) {
		hashOperations.put("PRODUCT", product.getId(), product);

	}
	
	
	@Override
	public Product findById(String id) {

		return (Product) hashOperations.get("PRODUCT", id);
	}

	@Override
	public Map<String, Product> findAll() {

		return hashOperations.entries("PRODUCT");
	}

	@Override
	public void update(Product product) {

		save(product);
	}

	@Override
	public void delete(String id) {

		hashOperations.delete("PRODUCT", id);
		
	}
		
		
	
}

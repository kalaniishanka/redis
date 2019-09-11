package com.example.redis.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.model.Product;
import com.example.redis.repository.ProductRepository;


@RestController
@RequestMapping("/products")

public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	
	/**
	 * Create a Product.
	 * @param product: product information.
	
	 * @return Create statement.
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	    public String add(@Valid@RequestBody Product product) {
		productRepository.save(product);		
        return "Successfully Created";
	}
	
	
	/**
	 * Get the product by product identifier.
	 * @param id     : Product identifier.
	 * @return product information
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Product getProduct(@RequestParam String id) {
		return productRepository.findById(id);
	}
	
	
	/**
	 * Get all products.
	 * @return List of products.
	 */
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Product> all() {

		return productRepository.findAll();

	}

	
	/**
	 * Update a product.
	 * @param id     : Product identifier.
	 * @param product :Product information
	 * @return Update Statement.
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String update(@Valid@RequestParam String id, @RequestBody Product product) {
		Product p = productRepository.findById(id);
		p.setName(product.getName());
		p.setAge(product.getAge());
		productRepository.save(p);
		return "Succesfully Updated";
	}
	
	
	
	
	/**
	 * Delete a product.
	 * @param id    : Product identifier.
	 * @return Delete statement.
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public String delete(@RequestParam String id) {
		productRepository.delete(id);
         return "Deleted";
		

	}
	
	
}
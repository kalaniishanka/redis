package com.example.redis.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

/**
 * Product Model
 * @author kalani
 *
 */
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -319331402347667119L;

	@Id
	private String id;
	@NotEmpty(message = "Name may not be empt")
    @Size(min = 3, max = 20, message = "Name must be between 2 and 32 characters long") 
	private String name;
	@Min(18)
    @Max(40)
	private int age;

	public Product() {
		// Default constructor stub
	}

	public Product(String id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age= age;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

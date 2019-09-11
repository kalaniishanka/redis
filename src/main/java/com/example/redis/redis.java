package com.example.redis;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.redis.model.Product;


/**
 * @author kalani
 *
 */
@SpringBootApplication
public class redis{

	

	@Bean
	JedisConnectionFactory jedisConnectionFactory() { 
	    return new JedisConnectionFactory();
	}
	 
	
	@Bean
	public RedisTemplate<String, Product> redisTemplate() {
	    RedisTemplate<String, Product> redisTemplate = new RedisTemplate<String, Product>();
	    redisTemplate.setConnectionFactory(jedisConnectionFactory());
	    
	    return redisTemplate;
	} 
	
	

	
	
	public static void main(String[] args) {
		
	
		SpringApplication.run(redis.class, args);
		
		
	}

}
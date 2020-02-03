package com.app.microservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservice.cache.BooksCache;
import com.app.microservice.model.Books;

@RestController
public class BooksController {

	@Autowired
	private BooksCache bookCache;
	int i=1;
	@GetMapping("/greet")
	public String greeting() {
		System.out.println("This method is called!! "+ i +" times");
		i++;
		return "Hello from Books Controller -  greeting";
	}
	
	@GetMapping("/book/{name}")
	public Books getBookDetails(@PathVariable String name) {
		return bookCache.getBookDetails(name);
	}
	
}

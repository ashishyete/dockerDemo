/**
 * 
 */
package com.app.microservice.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.app.microservice.model.Books;
import com.app.microservice.repo.BookRepo;

/**
 * @author AC03582
 *
 */
@Component
public class BooksCache {

	@Autowired
	BookRepo repo;

	@Cacheable(value = "bookscache", key = "#p0")
	public Books getBookDetails(String name) {
		System.out.println("Fetching Details from Database for bookName " + name);
		return repo.findByBookName(name);
	}
}

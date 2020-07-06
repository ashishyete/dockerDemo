/**
 * 
 */
package com.app.microservice.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

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
	
	//@Cacheable(value = "bookscache", key = "#p1")
	public List<Books> getAllBooks(){
		System.out.println("Fetching List of Books from Database");
		return repo.findAll();
	}
	
	public String saveBook(Books book){
		System.out.println("Saving new Book :- Book Name : "+book.getBookName());
		repo.save(book);
		return "Book Saved Successfully";
	}
	
	public Books getBookById(int id){
		System.out.println("Fetching Book from Database for book Id: "+id);
		return repo.findById(id).get();
	}
}

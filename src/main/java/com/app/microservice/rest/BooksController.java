package com.app.microservice.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		return bookCache.getBookDetails(name.toUpperCase());
	}
	
	@GetMapping("/book/id/{id}")
	public Books getBookDetailsById(@PathVariable int id) {
		return bookCache.getBookById(id);
		}
	
	@GetMapping("/book")
	public List<Books> getAllBooks(){
		return bookCache.getAllBooks();
	}
	
	@PostMapping("/book")
	public ResponseEntity<Object> saveBook(@RequestBody Books book){
		bookCache.saveBook(book);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("id/"+book.getBookId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}

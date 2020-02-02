package com.app.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.microservice.model.Books;

public interface BookRepo extends JpaRepository<Books, Integer> {

	public Books findByBookName(String name);
}

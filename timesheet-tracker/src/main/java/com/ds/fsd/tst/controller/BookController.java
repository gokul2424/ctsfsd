package com.ds.fsd.tst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.fsd.tst.dto.Book;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {
	
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks() {
		ResponseEntity<List<Book>> result = null;
		
//		WorkOutUser user = userService.getUserByName(userName);
		
//		WorkOutUser user = new WorkOutUser(232l, "dummyname", "dummypwd", "dummypwd");
		
		Book book = new Book(101, "Let US C");
		Book book2 = new Book(102, "Let US C++");
		
		List<Book> books = new ArrayList<>();
		books.add(book2); books.add(book);
		
		if(books != null) {
			result = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		}else {
			result = new ResponseEntity<List<Book>>(books, HttpStatus.NOT_FOUND);
		}
		return result;
		
	}

}

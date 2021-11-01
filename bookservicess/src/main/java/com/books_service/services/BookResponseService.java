package com.books_service.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books_service.Entity.Book;
import com.books_service.Entity.BookResponse;
import com.books_service.Repository.BookRepository;


@Service
public class BookResponseService {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository bookRepository;
	private static final Logger log = LoggerFactory.getLogger(BookResponseService.class);

	public Book adding(BookResponse bookResponse)
	{
		Book book=bookService.getBook(bookResponse.getBookId());
		book.setPrice(book.getPrice());
		return bookRepository.save(book);
	}
}

package com.books_service.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books_service.Entity.Book;
import com.books_service.Entity.BookResponse;
import com.books_service.services.BookResponseService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/bookServicess/v1/counts")
@Api(value = "Exam Management", tags = { "Exam Management" })
@Validated
public class BookRequestController {
	@Autowired
	BookResponseService bookResponseService;
	@ApiOperation(value = "Adding Order book")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, response = BookResponse.class, message = "Center added Successfully"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, response = String.class, message = "Invalid parameters") })
	@PostMapping(value = "/adding", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookResponse> adding(@Valid @RequestBody BookResponse bookRequest) {
		
		Book book = bookResponseService.adding(bookRequest);
		ModelMapper modelMapper = new ModelMapper();
		BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
		bookResponse.setPrice(book.getPrice());
		return ResponseEntity.status(HttpStatus.OK).body(bookResponse);
	}
	}
	

	
	


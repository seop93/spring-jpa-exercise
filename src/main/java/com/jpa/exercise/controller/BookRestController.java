package com.jpa.exercise.controller;

import com.jpa.exercise.domain.dto.BookResponse;
import com.jpa.exercise.domain.entity.Book;
import com.jpa.exercise.repository.BookRepository;
import com.jpa.exercise.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {

    private static BookService bookService;

    public BookRestController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookResponse>> list(Pageable pageable){
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }
}

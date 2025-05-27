package com.camp.nbcamp6thgitprc.controller;

import com.camp.nbcamp6thgitprc.dto.SaveBookRequest;
import com.camp.nbcamp6thgitprc.entity.Book;
import com.camp.nbcamp6thgitprc.service.BookSaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookSaveService bookSaveService;

    public BookController(BookSaveService bookSaveService) {
        this.bookSaveService = bookSaveService;
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody SaveBookRequest saveBookRequest) {
        Book savedBook = bookSaveService.saveBook(saveBookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
}
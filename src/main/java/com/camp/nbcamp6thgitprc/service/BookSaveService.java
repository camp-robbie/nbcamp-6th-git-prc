package com.camp.nbcamp6thgitprc.service;

import com.camp.nbcamp6thgitprc.dto.SaveBookRequest;
import com.camp.nbcamp6thgitprc.entity.Book;
import com.camp.nbcamp6thgitprc.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookSaveService {
    private final BookRepository bookRepository;

    public BookSaveService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(SaveBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setContents(request.getContents());
        book.setAuthors(String.join(",", request.getAuthors()));
        book.setPublisher(request.getPublisher());
        book.setThumbnail(request.getThumbnail());
        return bookRepository.save(book);
    }
}

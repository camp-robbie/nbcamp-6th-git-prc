package com.camp.nbcamp6thgitprc.service;

import com.camp.nbcamp6thgitprc.dto.BookResponseDto;
import com.camp.nbcamp6thgitprc.dto.SaveBookRequestDto;
import com.camp.nbcamp6thgitprc.entity.Book;
import com.camp.nbcamp6thgitprc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponseDto saveBook(SaveBookRequestDto request) {
       // DB 저장 : DB와 매핑이 되는 클래스 = entity
        Book book = new Book(request); // 저장 시키자
        Book savedBook = bookRepository.save(book); // insert into books (title, contents, authors, publisher, thumbnail) values (?, ?, ?, ?, ?);

        BookResponseDto responseDto = new BookResponseDto(savedBook);
        return responseDto;
    }

}

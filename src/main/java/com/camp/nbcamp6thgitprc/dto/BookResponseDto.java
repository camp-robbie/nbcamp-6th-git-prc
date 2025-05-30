package com.camp.nbcamp6thgitprc.dto;

import com.camp.nbcamp6thgitprc.entity.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String authors;
    private String publisher;
    private String thumbnail;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.contents = book.getContents();
        this.authors = book.getAuthors();
        this.publisher = book.getPublisher();
        this.thumbnail = book.getThumbnail();
    }
}

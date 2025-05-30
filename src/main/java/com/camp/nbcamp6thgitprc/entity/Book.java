package com.camp.nbcamp6thgitprc.entity;

import com.camp.nbcamp6thgitprc.dto.SaveBookRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity // 테이블과 매핑이 되는 클래스
@Table(name = "books")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String authors;
    private String publisher;
    private String thumbnail;

    // 생성자는 객체를 만들때도 쓰이지만 사실, 데이터를 초기화하는데 사용된다.
    public Book(SaveBookRequestDto request) {
        this.title = request.getTitle();
        this.contents = request.getContents();
        this.authors = String.join(",", request.getAuthors());
        this.publisher = request.getPublisher();
        this.thumbnail = request.getThumbnail();
    }
}

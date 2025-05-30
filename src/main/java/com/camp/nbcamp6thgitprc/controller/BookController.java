package com.camp.nbcamp6thgitprc.controller;

import com.camp.nbcamp6thgitprc.dto.BookResponseDto;
import com.camp.nbcamp6thgitprc.dto.SaveBookRequestDto;
import com.camp.nbcamp6thgitprc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // '브라우저에서 보내는 요청을 처리하는 클래스는 바로 너'라고 스프링한테 알려줘야한다.
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    /**
     * API 스팩
     * 사용자가 선택한 도서 정보를 저장하는 API
     * POST : 저장을 하려면 데이터가 필요한데, POST는 HTTP의 body에 데이터를 넣을 수 있고 저장한다는 의미를 가지고 있다.
     * /api/books : endpoint라고 하며 이 URL은 결국 도서를 저장하는 기능을 표현할 수 있어야하고 이를 통해 브라우저(Font개발자가) 이 URL로 접근할 수 있다.(저장을 요청할 수 있다.)
     */
    // https://localhost:8080/api/books
    // "{"title":"제목", "authors":"작가", "publisher":"출판사", "thumbnail":"썸네일", "contents":"내용 }"
    @PostMapping("/api/books")
    public BookResponseDto saveBook(@RequestBody SaveBookRequestDto request) {
       BookResponseDto responseDto = bookService.saveBook(request);
       return responseDto;
    }


}

package com.camp.nbcamp6thgitprc.controller;


import com.camp.nbcamp6thgitprc.dto.KakaoBookResponse;
import com.camp.nbcamp6thgitprc.service.KakaoBookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookSearchController {
    private final KakaoBookSearchService kakaoBookSearchService;

    @GetMapping("/search")
    public KakaoBookResponse search(@RequestParam String query, @RequestParam(defaultValue = "10") int size) {
        return kakaoBookSearchService.searchBooks(query, size);
    }
}

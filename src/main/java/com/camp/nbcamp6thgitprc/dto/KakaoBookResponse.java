package com.camp.nbcamp6thgitprc.dto;

import java.util.List;

public record KakaoBookResponse(
        List<Document> documents
) {
    public record Document(
            String title,
            List<String> authors,
            String publisher,
            String thumbnail,
            String contents
    ) {}
}
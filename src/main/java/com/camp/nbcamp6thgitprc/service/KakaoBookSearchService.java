package com.camp.nbcamp6thgitprc.service;


import com.camp.nbcamp6thgitprc.dto.KakaoBookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class KakaoBookSearchService {
    private final RestClient kakaoBookRestClient;

    public KakaoBookResponse searchBooks(String query, int size) {
        return kakaoBookRestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", query)
                        .queryParam("size", size)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "클라이언트 오류 발생: " + response.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류 발생: " + response.getStatusCode());
                })
                .body(KakaoBookResponse.class);
    }
}
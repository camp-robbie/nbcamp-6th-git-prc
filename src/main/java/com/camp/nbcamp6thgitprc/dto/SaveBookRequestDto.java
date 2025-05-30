package com.camp.nbcamp6thgitprc.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class SaveBookRequestDto {
    private String title;
    private List<String> authors;
    private String publisher;
    private String thumbnail;
    private String contents;
}

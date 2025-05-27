package com.camp.nbcamp6thgitprc.dto;

import lombok.Getter;


import java.util.List;

@Getter
public class SaveBookRequest {

    private String title;
    private String contents;
    private List<String> authors;
    private String publisher;
    private String thumbnail;
}
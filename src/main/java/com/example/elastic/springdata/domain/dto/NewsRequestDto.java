package com.example.elastic.springdata.domain.dto;

public class NewsRequestDto {

    private String title;
    private String text;

    private NewsRequestDto() {
    }

    public NewsRequestDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

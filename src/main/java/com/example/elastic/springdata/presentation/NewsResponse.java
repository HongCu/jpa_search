package com.example.elastic.springdata.presentation;
import com.example.elastic.springdata.domain.dto.NewsResponseDto;

public class NewsResponse {
    private Long id;
    private String title;
    private String text;

    private NewsResponse() {
    }

    public NewsResponse(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public static NewsResponse from(NewsResponseDto newsResponseDto) {
        return new NewsResponse(
                newsResponseDto.getId(),
                newsResponseDto.getTitle(),
                newsResponseDto.getText()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}


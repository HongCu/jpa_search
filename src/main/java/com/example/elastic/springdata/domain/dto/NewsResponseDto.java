package com.example.elastic.springdata.domain.dto;

import com.example.elastic.springdata.domain.entity.News;

public class NewsResponseDto {
    private Long id;
    private String title;
    private String text;

    private NewsResponseDto() {
    }

    public NewsResponseDto(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public NewsResponseDto(String title, String text) {

        this.title = title;
        this.text = text;
    }


    public static NewsResponseDto from(News news) {
        return new NewsResponseDto(news.getId(), news.getTitle(), news.getText());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
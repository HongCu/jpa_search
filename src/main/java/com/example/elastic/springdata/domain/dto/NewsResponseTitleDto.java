package com.example.elastic.springdata.domain.dto;

import com.example.elastic.springdata.domain.entity.News;

public class NewsResponseTitleDto {
    private Long id;
    private String title;

    private NewsResponseTitleDto() {
    }

    public NewsResponseTitleDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

//    public NewsResponseTitleDto(String title) {
//        this.title = title;
//    }

    public static NewsResponseTitleDto fromTitle(News news) {
        return new NewsResponseTitleDto(news.getId(), news.getTitle());
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

}

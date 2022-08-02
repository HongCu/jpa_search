package com.example.elastic.springdata.presentation;
import com.example.elastic.springdata.domain.dto.NewsResponseTitleDto;

public class NewsResponseTitle {
    private Long id;
    private String title;

    private NewsResponseTitle() {
    }

    public NewsResponseTitle(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static NewsResponseTitle fromTitle(NewsResponseTitleDto newsResponseDto) {
        return new NewsResponseTitle(
                newsResponseDto.getId(),
                newsResponseDto.getTitle()
        );
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}

package com.example.elastic.springdata.domain.service;

import com.example.elastic.springdata.domain.dto.NewsRequestDto;
import com.example.elastic.springdata.domain.dto.NewsResponseDto;
import com.example.elastic.springdata.domain.dto.NewsResponseTitleDto;
import com.example.elastic.springdata.domain.entity.News;
import com.example.elastic.springdata.domain.repository.NewsRepository;
import com.example.elastic.springdata.domain.repository.NewsSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final NewsSearchRepository newsSearchRepository;

    @Transactional
    public Long save(NewsRequestDto newsRequestDto) {
        News news = new News(newsRequestDto.getTitle(), newsRequestDto.getText());
        News savedNews = newsRepository.save(news);
        return savedNews.getId();
    }

    public List<NewsResponseTitleDto> searchByTitle(String title, Pageable pageable) {
        return newsSearchRepository.searchByTitle(title, pageable)
                .stream()
                .map(NewsResponseTitleDto::fromTitle)
                .collect(Collectors.toList());
    }

    public List<NewsResponseDto> searchByText(String text, Pageable pageable) {
        return newsSearchRepository.searchByText(text, pageable)
                .stream()
                .map(NewsResponseDto::from)
                .collect(Collectors.toList());
    }
}
package com.example.elastic.springdata.domain.repository;

import com.example.elastic.springdata.domain.entity.News;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomNewsSearchRepository {

    List<News> searchByTitle(String title, Pageable pageable);

    List<News> searchByText(String text, Pageable pageable);
}

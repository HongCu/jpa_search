package com.example.elastic.springdata.domain.repository;

import com.example.elastic.springdata.domain.entity.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface NewsSearchRepository extends ElasticsearchRepository<News, Long>, CustomNewsSearchRepository {

    String findByTitleContains(String title);

    String findByTextContains(String text);
}
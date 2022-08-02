package com.example.elastic.springdata.domain.repository;

import com.example.elastic.springdata.domain.entity.News;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CustomNewsSearchRepositoryImpl implements CustomNewsSearchRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<News> searchByTitle(String title, Pageable pageable) {
        Criteria criteria = Criteria.where("title").contains(title); // where에 검색할 필드를 넣는 것이고 contain에는 뭘 넣는거지?
        Query query = new CriteriaQuery(criteria).setPageable(pageable);


        SearchHits<News> search = elasticsearchOperations.search(query, News.class);

        return search.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }

    @Override
    public List<News> searchByText(String text, Pageable pageable) {
        Criteria criteria = Criteria.where("text").contains(text); // 나중에 Querydsl로 바꿀 것
        Query query = new CriteriaQuery(criteria).setPageable(pageable);


        SearchHits<News> search = elasticsearchOperations.search(query, News.class);

        return search.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }
}
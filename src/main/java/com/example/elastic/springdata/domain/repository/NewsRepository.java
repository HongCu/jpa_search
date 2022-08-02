package com.example.elastic.springdata.domain.repository;

import com.example.elastic.springdata.domain.entity.News;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}

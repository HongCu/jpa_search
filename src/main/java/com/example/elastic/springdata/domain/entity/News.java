package com.example.elastic.springdata.domain.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(indexName = "esvsoracle2")
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;

    protected News() {
    }

    public News(String title, String text) {
        this(null, title, text);
    }
    @PersistenceConstructor
    public News(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
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
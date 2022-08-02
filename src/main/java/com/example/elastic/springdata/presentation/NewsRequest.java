package com.example.elastic.springdata.presentation;

public class NewsRequest {

    private String title;
    private String text;

    private NewsRequest() {
    }

    public NewsRequest(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

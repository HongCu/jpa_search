package com.example.elastic.springdata.presentation;

import com.example.elastic.springdata.domain.dto.NewsRequestDto;
import com.example.elastic.springdata.domain.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class NewsController {

    private final NewsService newsService;

    @PostMapping("/search")
    public ResponseEntity<Void> save(@RequestBody NewsRequest newsRequest) {
        NewsRequestDto newsRequestDto = new NewsRequestDto(
                newsRequest.getTitle(),
                newsRequest.getText()
        );
        Long id = newsService.save(newsRequestDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri)
                .build();
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<List<NewsResponseTitle>> searchTitle(@PathVariable String title, Pageable pageable) {
        List<NewsResponseTitle> newsResponseTitle = newsService.searchByTitle(title, pageable)
                .stream()
                .map(NewsResponseTitle::fromTitle) // title만 보여지도록
                .collect(Collectors.toList());
        return ResponseEntity.ok(newsResponseTitle);
    }

    @GetMapping("/search/text/{text}")
    public ResponseEntity<List<NewsResponse>> searchText(@PathVariable String text, Pageable pageable) {
        List<NewsResponse> newsResponses = newsService.searchByText(text, pageable)
                .stream()
                .map(NewsResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(newsResponses);
    }
}


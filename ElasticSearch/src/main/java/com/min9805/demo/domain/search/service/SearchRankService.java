package com.min9805.demo.domain.search.service;

import com.min9805.demo.domain.search.entity.SearchRank;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SearchRankService {
    private final ElasticsearchOperations elasticsearchOperations;

    public void saveSearchRank(String keyword) {
        SearchRank searchRank = SearchRank.builder()
                .keyword(keyword)
                .createdAt(LocalDateTime.now())
                .build();
        elasticsearchOperations.save(searchRank);
      }
}

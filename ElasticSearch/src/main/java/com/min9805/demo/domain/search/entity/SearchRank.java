package com.min9805.demo.domain.search.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@Document(indexName = "search")
public class SearchRank {
    @Id
    private String id;
    private String keyword;
    private LocalDateTime createdAt;
}

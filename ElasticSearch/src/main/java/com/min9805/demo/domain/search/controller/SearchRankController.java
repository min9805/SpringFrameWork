package com.min9805.demo.domain.search.controller;

import com.min9805.demo.domain.search.dto.SearchKeywordRequest;
import com.min9805.demo.domain.search.service.SearchRankService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/search-rank")
@RequiredArgsConstructor
public class SearchRankController {
    private final SearchRankService searchRankService;

    @PostMapping("/search")
    public void saveSearchRank(SearchKeywordRequest request) {
        searchRankService.saveSearchRank(request.getKeyword());
    }
}

package com.example.junit5.service;

import com.example.junit5.service.algorithms.impl.BubbleSortService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SortManagerService {
    private BubbleSortService bubbleSortService;

    public List<String> sortUsingBubbleASCAlgorithm(final List<String> values) {
        return bubbleSortService.applyASCSorting(values);
    }
}

package com.example.junit5.controller;

import com.example.junit5.service.SortManagerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sort")
@AllArgsConstructor
public class SortController {

    private SortManagerService sortManagerService;

    @PostMapping("bubble")
    public List<String> sortUsingBubbleASCSorting(@RequestBody List<String> values) {
        return sortManagerService.sortUsingBubbleASCAlgorithm(values);
    }
}

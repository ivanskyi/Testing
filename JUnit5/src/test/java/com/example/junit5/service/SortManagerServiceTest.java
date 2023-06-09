package com.example.junit5.service;

import com.example.junit5.controller.SortController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class SortManagerServiceTest {

    private final List<String> valuesWithWrongOrder = List.of("Value 3", "Value 2", "Value 1");
    private final List<String> valuesWithCorrectOrder = List.of("Value 1", "Value 2", "Value 3");

    @Autowired
    private SortController sortController;

    @Test
    public void testBubbleAscendingSort() {
        final List<String> sortResult = sortController.sortUsingBubbleASCSorting(valuesWithWrongOrder);
        Assertions.assertThat(sortResult).isEqualTo(valuesWithCorrectOrder);
    }
}

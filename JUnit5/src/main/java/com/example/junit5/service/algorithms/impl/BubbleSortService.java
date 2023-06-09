package com.example.junit5.service.algorithms.impl;

import com.example.junit5.service.algorithms.SortAlgorithm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BubbleSortService implements SortAlgorithm {

    public List<String> applyASCSorting(final List<String> values) {
        List<String> listOfValues = new ArrayList<>(values);
        int numberOfValues = listOfValues.size();
        for (int i = 0; i < numberOfValues - 1; i++) {
            for (int j = 0; j < numberOfValues - i - 1; j++) {
                if (listOfValues.get(j).compareTo(listOfValues.get(j + 1)) > 0) {
                    Collections.swap(listOfValues, j, j + 1);
                }
            }
        }
        return listOfValues;
    }
}

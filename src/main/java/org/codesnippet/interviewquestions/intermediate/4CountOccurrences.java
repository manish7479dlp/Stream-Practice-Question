package org.codesnippet.interviewquestions.intermediate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class CountOccurrences {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        //apple - 3
        //banana - 2
        //orange - 1

        Map<String, Long> map = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

    }
}

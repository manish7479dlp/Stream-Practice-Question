package org.codesnippet.interviewquestions.intermediate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MostFrequentChar {
    public static void main(String[] args) {
        String input = "banana";

      //  "banana" → ['b', 'a', 'n', 'a', 'n', 'a']

        Map.Entry<Character, Long> characterLongEntry = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        System.out.println(characterLongEntry);
    }
}

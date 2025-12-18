package org.codesnippet.interviewquestions.intermediate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class FirstNonRepeatingCharStream {
    public static void main(String[] args) {
        String str = "swiss";

        Optional<Map.Entry<Character, Long>> first = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new
                        , Collectors.counting()
                )).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();
        System.out.println(first);
    }
}

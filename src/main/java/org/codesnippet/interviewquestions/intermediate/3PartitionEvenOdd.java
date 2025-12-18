package org.codesnippet.interviewquestions.intermediate;

import java.util.*;
import java.util.stream.*;

public class PartitionEvenOdd {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> output = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Even Numbers : "+output.get(true));
        System.out.println("Odd Numbers : "+output.get(false));
    }
}

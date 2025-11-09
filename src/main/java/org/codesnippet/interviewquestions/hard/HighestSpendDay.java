package org.codesnippet.interviewquestions.hard;


import org.codesnippet.interviewquestions.hard.dto.Transaction;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class HighestSpendDay {
    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", LocalDate.of(2024, 1, 1), 300),
                new Transaction("T2", LocalDate.of(2024, 1, 1), 200),
                new Transaction("T3", LocalDate.of(2024, 1, 2), 500),
                new Transaction("T4", LocalDate.of(2024, 1, 2), 300),
                new Transaction("T5", LocalDate.of(2024, 1, 3), 100)
        );
/*        Day with the highest spending: 2024-01-02
        Total spending: 800.0*/

        Map<LocalDate, Double> collect = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getDate,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        Map.Entry<LocalDate, Double> localDateDoubleEntry = collect.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(localDateDoubleEntry);
    }
}

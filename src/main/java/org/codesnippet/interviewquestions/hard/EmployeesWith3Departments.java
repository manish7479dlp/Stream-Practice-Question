package org.codesnippet.interviewquestions.hard;

import org.codesnippet.interviewquestions.hard.dto.WorkRecord;

import java.util.*;
import java.util.stream.*;

public class EmployeesWith3Departments {
    public static void main(String[] args) {

        List<WorkRecord> records = List.of(
                new WorkRecord("John", "IT"),
                new WorkRecord("John", "Finance"),
                new WorkRecord("John", "HR"),
                new WorkRecord("Alice", "IT"),
                new WorkRecord("Alice", "HR"),
                new WorkRecord("Bob", "Finance"),
                new WorkRecord("David", "IT"),
                new WorkRecord("David", "Finance"),
                new WorkRecord("David", "HR"),
                new WorkRecord("David", "Admin")
        );

        Map<String, List<WorkRecord>> collect = records.stream()
                .collect(Collectors.groupingBy(
                        WorkRecord::getEmployeeName
                ));

        List<String> list = collect.entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 3)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(list);


    }
}

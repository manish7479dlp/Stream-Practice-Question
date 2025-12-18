package org.codesnippet.interviewquestions.hard;


import org.codesnippet.interviewquestions.hard.dto.Employee;
import org.codesnippet.interviewquestions.hard.dto.SalaryRange;

import java.util.*;
import java.util.stream.*;

public class SalaryRangeGrouping {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 45000),
                new Employee("Bob", 78000),
                new Employee("Charlie", 120000),
                new Employee("David", 99000),
                new Employee("Eva", 30000),
                new Employee("Frank", 105000)
        );
/*        MEDIUM → [Bob (78000.0), David (99000.0)]
        LOW → [Alice (45000.0), Eva (30000.0)]
        HIGH → [Charlie (120000.0), Frank (105000.0)]*/

        Map<SalaryRange, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> getSalaryRange(e.getSalary())
                ));
        System.out.println(collect);
    }

    private static SalaryRange getSalaryRange(Double salary) {
        if (salary < 50000) return SalaryRange.LOW;
        if (salary < 100000) return SalaryRange.MEDIUM;
        else return SalaryRange.HIGH;
    }


}

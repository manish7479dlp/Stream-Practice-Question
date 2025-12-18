package org.codesnippet.interviewquestions.intermediate;

import org.codesnippet.interviewquestions.intermediate.dto.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDepartmentAvg {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1,"John", "HR", 50000),
                new Employee(2,"Jane", "IT", 70000),
                new Employee(3,"Mike", "IT", 80000),
                new Employee(4,"Sara", "Finance", 60000),
                new Employee(5,"Paul", "HR", 55000)
        );
        /*Finance : 60000.0
        HR : 52500.0
        IT : 75000.0*/

        Map<String, Double> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(collect);

    }
}
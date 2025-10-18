package org.codesnippet.interviewquestions.intermediate;

import org.codesnippet.interviewquestions.intermediate.dto.Employee;

import java.util.*;
import java.util.stream.*;

public class DepartmentEmployeeCount {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1,"John", "IT", 60000),
                new Employee(2,"Alice", "HR", 55000),
                new Employee(3,"Bob", "IT", 75000),
                new Employee(4,"Carol", "HR", 70000),
                new Employee(5,"David", "Finance", 65000),
                new Employee(6,"Eve", "IT", 80000),
                new Employee(7,"Frank", "Finance", 64000),
                new Employee(8,"Ala", "Operations", 44000)
        );
       /*
          IT = 3,
          HR = 2,
          Finance = 2,
          Operations =1
        */

        List<String> list = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment
                        , Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();


        System.out.println(list);


    }
}

package spring.boot.mongo.demo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FindNthHighestSalaryEmployee {
    public static void main(String... str) {
        List<Employees> employees = employees();
        //**************************************************//
        //Find Nth highest salary
        //Map<Double, List<Employees>> collect = groupingBySalary(employees);
        //Map.Entry<Double, List<Employees>> sorted = getNthHighestSalaryEmployee(collect, 2);
        //System.out.println(sorted);
        //**************************************************//
        //Increase Salary by 5% to all the employees
        List<Employees> collect = increaseSalaryByPercentage(employees, 0.15);
        System.out.println(collect);
    }
    private static List<Employees> increaseSalaryByPercentage(List<Employees> employees, double percentage) {
        return employees.stream()
                .map(employee -> {
                    double salary = employee.getSalary() * (1+percentage);
                    employee.setSalary(salary);
                    return employee;
                })
                .collect(Collectors.toList());
    }
    private static Map<Double, List<Employees>> groupingBySalary(List<Employees> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employees::getSalary));
    }

    private static Map.Entry<Double, List<Employees>> getNthHighestSalaryEmployee(Map<Double, List<Employees>> collect, int i) {
        return collect.entrySet()
                .stream().sorted(Comparator.comparingDouble((Map.Entry<Double, List<Employees>> value) -> value.getKey())
                        .reversed()).collect(Collectors.toList()).get(i);

    }

    private static List<Employees> employees(){
        return Arrays.asList(new Employees(1, "Siva", 3400),
                new Employees(2, "Sam", 3500),
                new Employees(3, "Da0", 3600),
                new Employees(4, "Sid", 3800),
                new Employees(5, "Sar", 3800));
    }
}
//record Employees(int id, String name, double salary) implements Serializable {}


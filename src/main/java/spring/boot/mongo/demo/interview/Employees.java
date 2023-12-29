package spring.boot.mongo.demo.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class Employees
{
    private int id;
    private String name;
    private double salary;

    public Employees(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

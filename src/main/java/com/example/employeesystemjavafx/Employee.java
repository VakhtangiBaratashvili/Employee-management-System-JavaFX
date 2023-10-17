package com.example.employeesystemjavafx;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String profession;
    private Double salary;
}

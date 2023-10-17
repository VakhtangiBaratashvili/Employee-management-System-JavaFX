package com.example.employeesystemjavafx;

import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeUtils {
    public static EmployeeUtils employee;
    public static Statement statement = DB_Connection.getStatement();
    private EmployeeUtils(){}

    public static EmployeeUtils getInstance() {
        if (employee == null) {
            employee = new EmployeeUtils();
        }
        return employee;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        String sql = String.format("INSERT INTO EMPLOYEES (ID, FIRST_NAME, LAST_NAME, GENDER, PROFESSION, SALARY) VALUES('%d', '%s', '%s', '%s', '%s', '%f')",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getProfession(),
                employee.getSalary());
        statement.executeUpdate(sql);
    }

    public void updateEmployee(int id, Employee employee) throws SQLException{
        String sql = String.format("UPDATE BOOK SET FIRST_NAME = '%s' , LAST_NAME = '%s', GENDER = '%s', PROFESSION = '%s', SALARY = '%f'",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getProfession(),
                employee.getSalary());
        statement.executeUpdate(sql);
    }

    public void deleteEmployee(int id) throws SQLException{
        String sql = String.format("DELETE FROM EMPLOYEES WHERE ID = '%d'", id);
        statement.executeUpdate(sql);
    }

}

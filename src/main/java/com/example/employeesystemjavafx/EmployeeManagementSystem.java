package com.example.employeesystemjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.employeesystemjavafx.EmployeeUtils.statement;

public class EmployeeManagementSystem {

    EmployeeUtils employeeUtils = EmployeeUtils.getInstance();

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField idField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField professionField;

    @FXML
    private TextField salaryField;

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> firstNameColumn;

    @FXML
    private TableColumn<Employee, String> lastNameColumn;

    @FXML
    private TableColumn<Employee, String> genderColumn;

    @FXML
    private TableColumn<Employee, String> professionColumn;

    @FXML
    private TableColumn<Employee, Double> salaryColumn;

    @FXML
    void addEmployee(ActionEvent event) {
        Integer id = Integer.parseInt(idField.getText());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String gender = genderField.getText();
        String profession = professionField.getText();
        Double salary = Double.parseDouble(salaryField.getText());
        Employee employee = new Employee(id, firstName, lastName, gender, profession, salary);
        try {
            employeeUtils.insertEmployee(employee);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        updateTableView();

    }

    @FXML
    void deleteEmployee(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        try {
            employeeUtils.deleteEmployee(id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        updateTableView();
    }
    @FXML
    void updateTableView() {
        try {
            ObservableList<Employee> employeeList = FXCollections.observableArrayList();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String gender = resultSet.getString("GENDER");
                String profession = resultSet.getString("PROFESSION");
                double salary = resultSet.getDouble("SALARY");

                Employee employee = new Employee(id, firstName, lastName, gender, profession, salary);
                employeeList.add(employee);
            }
            table.setItems(employeeList);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        professionColumn.setCellValueFactory(new PropertyValueFactory<>("profession"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

}

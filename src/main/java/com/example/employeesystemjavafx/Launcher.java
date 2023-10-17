package com.example.employeesystemjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 813, 539);
        stage.setTitle("Employee Management System");
        stage.setScene(scene);
        stage.show();

        EmployeeManagementSystem controller = fxmlLoader.getController();
        controller.updateTableView();
    }

    public static void main(String[] args) {
        launch();
    }
}

module com.example.employeesystemjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;

    opens com.example.employeesystemjavafx to javafx.fxml;
    exports com.example.employeesystemjavafx;
}
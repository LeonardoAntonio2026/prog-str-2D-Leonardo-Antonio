module com.example.practicaexamenu3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.jdi;


    opens com.example.practicaexamenu3 to javafx.fxml;
    opens com.example.practicaexamenu3.controllers to javafx.fxml;
    opens com.example.practicaexamenu3.services to javafx.fxml;
    exports com.example.practicaexamenu3;
    exports com.example.practicaexamenu3.controllers;
    exports com.example.practicaexamenu3.services;
    exports com.example.practicaexamenu3.clases;
    opens com.example.practicaexamenu3.clases to javafx.fxml;
}
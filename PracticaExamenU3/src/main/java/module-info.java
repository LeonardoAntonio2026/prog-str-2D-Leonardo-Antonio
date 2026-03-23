module com.example.practicaexamenu3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.jdi;


    opens com.example.practicaexamenu3 to javafx.fxml;
    exports com.example.practicaexamenu3;
}
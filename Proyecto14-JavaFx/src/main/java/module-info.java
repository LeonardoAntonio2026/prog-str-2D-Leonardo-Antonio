module com.example.proyecto14javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto14javafx to javafx.fxml;
    exports com.example.proyecto14javafx;
}
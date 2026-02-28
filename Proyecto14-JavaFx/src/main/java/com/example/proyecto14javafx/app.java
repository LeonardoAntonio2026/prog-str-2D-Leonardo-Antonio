package com.example.proyecto14javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {

    private static Stage stagePrincipal;

    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage;
        stagePrincipal.setTitle("Login");

        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("/com/example/views/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stagePrincipal.setScene(scene);
        stagePrincipal.show();
    }

    public static void cambiarPantalla(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(app.class.getResource("/com/example/views/login.fxml" + fxml));
            Scene nuevaScene = new Scene(loader.load(), 500, 400);
            stagePrincipal.setScene(nuevaScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.proyecto14javafx.controllers;

import com.example.proyecto14javafx.app;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField txtCorreo;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblError;

    @FXML
    private void intentarLogin() {
        String correo = txtCorreo.getText().trim();
        String password = txtPassword.getText().trim();

        lblError.setText("");

        // Validaciones básicas (nivel principiante)
        if (correo.isEmpty() || correo.length() < 4) {
            lblError.setText("El correo debe tener al menos 4 caracteres");
            return;
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            lblError.setText("El correo no parece válido (falta @ o .)");
            return;
        }

        if (password.length() < 6) {
            lblError.setText("La contraseña debe tener mínimo 6 caracteres");
            return;
        }
        DashboardController.nombreUsuario = correo.split("@")[0];
        app.cambiarPantalla("dashboard.fxml");
    }
}
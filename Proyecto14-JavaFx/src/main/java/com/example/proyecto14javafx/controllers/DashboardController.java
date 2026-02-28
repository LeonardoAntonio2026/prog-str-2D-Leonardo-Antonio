package com.example.proyecto14javafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    public static String nombreUsuario = "Usuario";

    @FXML private Label lblBienvenida;

    @FXML
    private void initialize() {
        lblBienvenida.setText("Bienvenido, " + nombreUsuario + "!");
    }
}
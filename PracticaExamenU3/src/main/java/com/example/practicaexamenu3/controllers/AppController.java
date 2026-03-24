package com.example.practicaexamenu3.controllers;

import com.example.practicaexamenu3.services.ContactoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbParentesco;

    private final ObservableList<String> data = FXCollections.observableArrayList();
    private final ContactoService service = new ContactoService();
    private String nombreOriginal = null;

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(service.getParentescos());
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, old, newValue) -> {
            if (newValue != null) {
                loadDataToForm(newValue);
            }
        });
    }

    @FXML
    public void onAgregar() {
        String nombre = txtName.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String parentesco = cmbParentesco.getValue();
        try {
            service.addContacto(nombre, telefono, parentesco == null ? "" : parentesco);
            refreshList();
            limpiarCampos();
            showMsg("Contacto agregado exitosamente", true);
        } catch (IllegalArgumentException e) {
            showMsg(e.getMessage(), false);
        }
    }

    @FXML
    public void onBuscar() {
        String nombre = txtName.getText().trim();
        try {
            com.example.practicaexamenu3.clases.Contacto c = service.buscarContacto(nombre);
            txtName.setText(c.getNombre());
            txtTelefono.setText(c.getTelefono());
            cmbParentesco.setValue(c.getParentesco());
            nombreOriginal = c.getNombre();
            showMsg("Contacto encontrado", true);
        } catch (IllegalArgumentException e) {
            showMsg(e.getMessage(), false);
        }
    }

    @FXML
    public void onActualizar() {
        if (nombreOriginal == null) {
            showMsg("Primero busca o selecciona un contacto para actualizar", false);
            return;
        }
        String nuevoNombre = txtName.getText().trim();
        String nuevoTelefono = txtTelefono.getText().trim();
        String nuevoParentesco = cmbParentesco.getValue();
        try {
            service.updateContacto(nombreOriginal, nuevoNombre, nuevoTelefono, nuevoParentesco == null ? "" : nuevoParentesco);
            refreshList();
            limpiarCampos();
            showMsg("Contacto actualizado exitosamente", true);
        } catch (IllegalArgumentException e) {
            showMsg(e.getMessage(), false);
        }
    }

    @FXML
    public void onEliminar() {
        String nombre = txtName.getText().trim();
        try {
            service.deleteContacto(nombre);
            refreshList();
            limpiarCampos();
            showMsg("Contacto eliminado exitosamente", true);
        } catch (IllegalArgumentException e) {
            showMsg(e.getMessage(), false);
        }
    }

    @FXML
    public void onLimpiar() {
        limpiarCampos();
        showMsg("Campos limpiados", true);
    }

    private void refreshList() {
        data.setAll(service.loadDataForList());
    }

    private void limpiarCampos() {
        txtName.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
        nombreOriginal = null;
    }

    private void showMsg(String msg, boolean success) {
        lblMsg.setText(msg);
        lblMsg.setStyle(success ? "-fx-text-fill: green" : "-fx-text-fill: red");
    }

    private void loadDataToForm(String item) {
        String[] parts = item.split(" \\| ");
        txtName.setText(parts[0]);
        txtTelefono.setText(parts[1]);
        cmbParentesco.setValue(parts[2]);
        nombreOriginal = parts[0];
    }
}

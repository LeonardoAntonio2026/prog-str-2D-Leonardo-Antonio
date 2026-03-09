package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;


    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize(){ //Se ejecuta al inicio en cuanto se cargue el controller
        //Inicializar ListView
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onAddPerson() throws IOException {
        String name = txtName.getText();
        String email = txtEmail.getText();

        try {
            service.addPerson(name,email);
            lblMsg.setText("Datos cargados Exitosamente ");
            lblMsg.setStyle("-fx-text-alignment: green");
            txtName.clear();
            txtEmail.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-alignment: red");

        }catch (IllegalArgumentException ex){
            lblMsg.setText("Hubo un error con los datos:");
            lblMsg.setStyle("-fx-text-alignment: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForList();
            data.setAll(items);
            lblMsg.setText("Datos cargados Exitosamente ");
            lblMsg.setStyle("-fx-text-alignment: green");
        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-alignment: red");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosemestreprograi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author arody
 */
public class FXAdminUsuariosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox comb;
    
    @FXML
    private ComboBox comb1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> lista = FXCollections.observableArrayList("Activo", "Inactivo");
        comb.setItems(lista);
        ObservableList<String> listausuarios = FXCollections.observableArrayList("Administrador", "Bibliotecario");
        comb1.setItems(listausuarios);
        
        UsuarioDB controlador = new UsuarioDB();
        
        
    }    
    
    public void llenarTabla(){
        
    }
}

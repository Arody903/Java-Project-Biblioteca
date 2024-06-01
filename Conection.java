/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosemestreprograi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author arody
 */
public class Conection {
    
     Connection conectar = null;

    String usuario = "immnvins";
    String contraseña = "VJjK7CQr7Xmjb4guVbR3RMV4wJozCrw6";
    String bd = "immnvins";
    String ip = "kala.db.elephantsql.com";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            showAlert("Mensaje", "Se conectó a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            showAlert("Mensaje", "No se pudo conectar a la base de datos, error: " + e.toString());
        }
        return conectar;
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
            }
        } catch (SQLException e) {
       }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosemestreprograi;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
/**
 *
 * @author arody
 */
public class ConexionBD {
    
    private String url = "jdbc:postgresql://kala.db.elephantsql.com:5432/immnvins";
    private Properties properties = new Properties();
    private static Connection conn = null;
    
    public void ConexionBD () {
        properties.setProperty("user", "immnvins");
        properties.setProperty("password", "VJjK7CQr7Xmjb4guVbR3RMV4wJozCrw6");
            
        try {
            conn = DriverManager.getConnection(url, properties);
            showAlert("Mensaje", "Se conecto a la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            showAlert("Mensaje", "NO se conecto a la base de datos, error: " + ex.toString());
        }
    }
    
    public static Connection getConnection() {
        if (conn == null) {
               ConexionBD c = new ConexionBD();
               return c.conn;
        }
        else {
            return conn ;
        }
    }
    
    private void showAlert(String title, String content){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

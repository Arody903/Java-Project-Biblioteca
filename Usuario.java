package com.mycompany.proyectosemestreprograi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author arody
 */
public class Usuario {
    private String nombre_usuario;
    private String nombre_persona;
    private String rol;
    private String telefono;
    private String dpi;
    private String estado_cuenta;

    public Usuario() {
    }
    
    public Usuario(String nombre_usuario, String nombre_persona, String rol, String telefono, String dpi, String estado_cuenta) {
        this.nombre_usuario = nombre_usuario;
        this.nombre_persona = nombre_persona;
        this.rol = rol;
        this.telefono = telefono;
        this.dpi = dpi;
        this.estado_cuenta = estado_cuenta;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosemestreprograi;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arody
 */
public class UsuarioDB {
    
    Connection conn;
    
    public UsuarioDB() {
        conn = ConexionBD.getConnection();
    }
    
    public void agregarLibro(Libro e) {
        
    PreparedStatement st = null;
    
        try {
            String sql = "INSERT INTO libros (isbn, titulo, autor, editorial, categoria, disponibilidad, anio_publicacion, fecha_entrada)" +
                                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, e.getIsbn());
            st.setString(2, e.getTitulo());
            st.setString(3, e.getAutor());
            st.setString(4, e.getEditorial());
            st.setString(5, e.getCategoria());
            st.setInt(6, e.getDisponibilidad());
            st.setInt(7, e.getAnio_publicacion());
            st.setDate(8, new java.sql.Date(e.getFecha_entrada().getTime()));
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void actualizarLibro(Libro e) {
            PreparedStatement st = null;
    
        try {
            String sql = "UPDATE libros"
                    + " SET titulo = ?, autor = ?, editorial = ?, categoria = ?, disponibilidad = ?, anio_publicacion = ?" + 
                                            "WHERE isbn = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, e.getTitulo());
            st.setString(2, e.getAutor());
            st.setString(3, e.getEditorial());
            st.setString(4, e.getCategoria());
            st.setInt(5, e.getDisponibilidad());
            st.setInt(6,e.getAnio_publicacion());
            st.setString(7, e.getIsbn());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminarLibro(String isbn) {
            PreparedStatement st = null;
    
        try {
            String sql = "DELETE FROM libros WHERE isbn = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, isbn);
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Libro obtenerLibro(String isbn) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Libro e = new Libro();
        
        try {
            String sql = "SELECT * " +
                         "FROM libros WHERE isbn = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, isbn);
            rs = st.executeQuery();
            
            while (rs.next()) {
                e.setIsbn(rs.getString(1));
                e.setTitulo(rs.getString(2));
                e.setAutor(rs.getString(3));
                e.setEditorial(rs.getString(4));
                e.setCategoria(rs.getString(5));
                e.setDisponibilidad(rs.getInt(6));
                e.setAnio_publicacion(rs.getInt(7));
                
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    public ArrayList<Libro>  obtenerTodosLibros() {
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Libro> a = new ArrayList();
        
        try {
            String sql = "SELECT *" + 
                         "FROM libros";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Libro e = new Libro();
                
                e.setIsbn(rs.getString(1));
                e.setTitulo(rs.getString(2));
                e.setAutor(rs.getString(3));
                e.setEditorial(rs.getString(4));
                e.setCategoria(rs.getString(5));
                e.setDisponibilidad(rs.getInt(6));
                e.setAnio_publicacion(rs.getInt(7));
                
                a.add(e);
            }
            
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void agregarUsuario(Usuario e) {
        
    PreparedStatement st = null;
    
        try {
            String sql = "INSERT INTO usuarios (nombre_usuario, nombre_persona, rol, telefono, dpi, estado_cuenta)" +
                                            "VALUES (?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, e.getNombre_usuario());
            st.setString(2, e.getNombre_persona());
            st.setString(3, e.getRol());
            st.setString(4, e.getTelefono());
            st.setString(5, e.getDpi());
            st.setString(6, e.getEstado_cuenta());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void actualizarUsuario(Usuario e) {
            PreparedStatement st = null;
    
        try {
            String sql = "UPDATE usuarios"
                    + " SET nombre_persona = ?, rol = ?, telefono = ?, dpi = ?, estado_cuenta = ?" + 
                                            "WHERE nombre_usuario = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, e.getNombre_persona());
            st.setString(2, e.getRol());
            st.setString(3, e.getTelefono());
            st.setString(4, e.getDpi());
            st.setString(5, e.getEstado_cuenta());
            st.setString(6, e.getNombre_usuario());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminarUsuario(String nombre_usuario) {
            PreparedStatement st = null;
    
        try {
            String sql = "DELETE FROM usuarios WHERE nombre_usuario = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, nombre_usuario);
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Usuario obtenerUsuario(String nombre_usuario) {
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario e = new Usuario();
        
        try {
            String sql = "SELECT * " +
                         "FROM usuarios WHERE nombre_usuario = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, nombre_usuario);
            rs = st.executeQuery();
            
            while (rs.next()) {
                e.setNombre_usuario(rs.getString(1));
                e.setNombre_persona(rs.getString(2));
                e.setRol(rs.getString(3));
                e.setTelefono(rs.getString(4));
                e.setDpi(rs.getString(5));
                e.setEstado_cuenta(rs.getString(6));
                
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
    public ArrayList<Usuario>  obtenerTodosUsuarios() {
        
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Usuario> a = new ArrayList();
        
        try {
            String sql = "SELECT *" + 
                         "FROM usuarios";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                
                Usuario e = new Usuario();
                
                e.setNombre_usuario(rs.getString(1));
                e.setNombre_persona(rs.getString(2));
                e.setRol(rs.getString(3));
                e.setTelefono(rs.getString(4));
                e.setDpi(rs.getString(5));
                e.setEstado_cuenta(rs.getString(6));
                
                a.add(e);
            }
            
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
    
}

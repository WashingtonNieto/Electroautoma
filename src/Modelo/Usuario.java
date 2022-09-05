/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Usuario extends DbData{
    public int id;
    public String nombre;
    public String apellido;
    public String correo;
    public String user;
    public String password;
    public String tipoUsuario;

    @Override
    public String toString() {
        //return ""+ id + "-" + nombre + "-" + apellido + "-" + correo + "-" + user + "-" + password + "-" + tipoUsuario +'}';
        return ""+ id + "-" + nombre + " " + apellido ;
    }

   
    public boolean insert(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO usuario VALUES (null,?,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,apellido);
            sentencia.setString(3,correo);
            sentencia.setString(4,user);
            sentencia.setString(5,password);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0){
                return true;
            }else{
                return false;
            }
        } catch(Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
        
    }
    
    public static boolean Autenticacion(String user, String password){
        Connection connection = null;
        String query = "SELECT usuario,password FROM usuario WHERE usuario=? and password=?";
        try{
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,user);
            sentencia.setString(2,password);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0){
                return true;
            }else{
                return false;
            }
            
        } catch(Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }
    
    
    public ArrayList<Usuario> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM usuario";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.id = rs.getInt(1);
                usuario.nombre = rs.getString(2);
                usuario.apellido = rs.getString(3);
                usuario.correo = rs.getString(4);
                usuario.user = rs.getString(5);
                usuario.tipoUsuario = rs.getString(6);
                listaUsuarios.add(usuario);
            }
            connection.close();
            return listaUsuarios;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }   
    public Usuario find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM usuario WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Usuario usuario = new Usuario();
            if(rs.next()){
                usuario.id = rs.getInt(1);
                usuario.nombre = rs.getString(2);
                usuario.apellido = rs.getString(3);
                usuario.correo = rs.getString(4);
                usuario.user = rs.getString(5);
                usuario.tipoUsuario = rs.getString(6);
            }else{
                usuario = null;
            }
            connection.close();
            return usuario;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
        public boolean update() {
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE usuario SET nombre =?,apellido=?,correo=? WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, correo);
            sentencia.setInt(4, id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0 ){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }
    
    
    public boolean delete(int id) {
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM usuario WHERE id=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            int filasAfectadas = sentencia.executeUpdate();
            connection.close();
            if (filasAfectadas > 0 ){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return false;
        }
    }    
    
}

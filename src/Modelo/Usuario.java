/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Usuario extends DbData{
    public int id;
    public String nombre;
    public String apellido;
    public String correo;
    public String user;
    public String password;

    @Override
    public String toString() {
        return ""+ id + "-" + nombre + "-" + apellido + "-" + correo + "-" + user + "-" + password + '}';
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
}

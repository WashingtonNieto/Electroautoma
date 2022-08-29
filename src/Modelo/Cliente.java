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

/**
 *
 * @author washi
 */
public class Cliente extends DbData{


    public int id;
    public String nombre;
    public String nit;
    public String contacto;
    public String telefono;
    public String direccion;
    public String email;

    @Override
    public String toString() {
        return  id + "-" + nombre + "-" + nit + "-" + contacto + "-" + telefono + "-" + direccion + "-" + email ;
    }
    
    
    public boolean insert(){
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO cliente VALUES (null,?,?,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1,nombre);
            sentencia.setString(2,nit);
            sentencia.setString(3,contacto);
            sentencia.setString(4,telefono);
            sentencia.setString(5,direccion);
            sentencia.setString(6,email);
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
    
    public ArrayList<Cliente> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM cliente";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Cliente> listaClientes = new ArrayList<>();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.id = rs.getInt(1);
                cliente.nombre = rs.getString(2);
                cliente.nit = rs.getString(3);
                cliente.contacto = rs.getString(4);
                cliente.telefono = rs.getString(5);
                cliente.direccion = rs.getString(6);
                cliente.email = rs.getString(7);
                listaClientes.add(cliente);
            }
            connection.close();
            return listaClientes;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public Cliente find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM  cliente WHERE id_cliente=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Cliente cliente = new Cliente();
            if(rs.next()){
                cliente.id = rs.getInt(1);
                cliente.nombre = rs.getString(2);
                cliente.nit = rs.getString(3);
                cliente.contacto = rs.getString(4);
                cliente.telefono = rs.getString(5);
                cliente.direccion = rs.getString(6);
                cliente.email = rs.getString(7);
            }else{
                cliente = null;
            }
            connection.close();
            return cliente;
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
            String query = "UPDATE cliente SET nombre =?,nit=?,contacto=?,telefono=?,direccion=?,email=? WHERE id_cliente=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, nombre);
            sentencia.setString(2, nit);
            sentencia.setString(3, contacto);
            sentencia.setString(4, telefono);
            sentencia.setString(5, direccion);
            sentencia.setString(6, email);
            sentencia.setInt(7, id);
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
            String query = "DELETE FROM cliente WHERE id_cliente=?";
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

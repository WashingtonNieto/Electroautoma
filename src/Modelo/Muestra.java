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
public class Muestra extends DbData{


    public int id_muestra;
    public int id_informe;
    public String referencia;
    public int id_usuario;
    public String fecha_ingreso;
    public String fecha_max_emision;
    public String descripcion;

    
    
    
    @Override
    public String toString(){
        return id_muestra + "-" + id_informe + "-" + referencia + "-" + id_usuario + "-" + fecha_ingreso + "-" + fecha_max_emision + "-" + descripcion ;
    }

    public boolean insert() {
        Connection connection;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO muestra VALUES (null,?,?,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1,id_informe);
            sentencia.setString(2,referencia);
            sentencia.setInt(3,id_usuario);
            sentencia.setString(4,fecha_ingreso);
            sentencia.setString(5,fecha_max_emision);
            sentencia.setString(6,descripcion);
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
    
    public ArrayList<Muestra> select(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            
            String query = "SELECT * FROM muestra";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet rs = sentencia.executeQuery();
            ArrayList<Muestra> listaClientes = new ArrayList<>();
            while(rs.next()){
                Muestra muestra = new Muestra();
                muestra.id_muestra = rs.getInt(1);
                muestra.id_informe = rs.getInt(2);
                muestra.referencia = rs.getString(3);
                muestra.id_usuario = rs.getInt(4);
                muestra.fecha_ingreso = rs.getString(5);
                muestra.fecha_max_emision = rs.getString(6);
                muestra.descripcion = rs.getString(7);
                listaClientes.add(muestra);
            }
            connection.close();
            return listaClientes;
        }catch (Exception e){
            System.out.println("Error " + e.toString());
            return null;
        }
    }
    
    public Muestra find(int id){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM  muestra WHERE id_muestra=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            Muestra muestra = new Muestra();
            if(rs.next()){
                muestra.id_muestra = rs.getInt(1);
                muestra.id_informe = rs.getInt(2);
                muestra.referencia = rs.getString(3);
                muestra.id_usuario = rs.getInt(4);
                muestra.fecha_ingreso = rs.getString(5);
                muestra.fecha_max_emision = rs.getString(6);
                muestra.descripcion = rs.getString(7);
            }else{
                muestra = null;
            }
            connection.close();
            return muestra;
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
            String query = "UPDATE muestra SET id_informe =?,referencia=?,id_usuario=?,fecha_ingreso=?,fecha_max_emision=?,descripcion=? WHERE id_muestra=?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, id_informe);
            sentencia.setString(2, referencia);
            sentencia.setInt(3, id_usuario);
            sentencia.setString(4, fecha_ingreso);
            sentencia.setString(5, fecha_max_emision);
            sentencia.setString(6, descripcion);
            sentencia.setInt(7, id_muestra);
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
            String query = "DELETE FROM muestra WHERE id_muestra=?";
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

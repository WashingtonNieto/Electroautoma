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
public class Seguimiento extends DbData{
    
    public int id;
    public int id_cliente;
    public int id_muestra;
    public int num_dias_entrega;
    public String fecha_ingreso_muestras;
    public int num_nota_pedido;
    public String fecha_objetivo_informe;
    public int num_informe;

    public String hilo_incandescente;
    public String hi_nom_doc_normativo;
    
    public String choque_electrico;
    public String ce_nom_doc_normativo;
    
    public String corrocion_oxidacion;
    public String co_nom_doc_normativo;
    
    public String adherencia;
    public String a_nom_doc_normativo;
    
    public String seccion_trasversal;
    public String st_nom_doc_normativo;

    @Override
    public String toString() {
        return "" + id + "-" + id_cliente + "-" + id_muestra + "-" + num_dias_entrega + "-" + fecha_ingreso_muestras + "-" + num_nota_pedido + "-" + fecha_objetivo_informe + "-" + num_informe + "-" + hilo_incandescente + "-" + hi_nom_doc_normativo + "-" + choque_electrico + "-" + ce_nom_doc_normativo + "-" + corrocion_oxidacion + "-" + co_nom_doc_normativo + "-" + adherencia + "-" + a_nom_doc_normativo + "-" + seccion_trasversal + "-" + st_nom_doc_normativo + '}';
    }

    public boolean insert(){
        Connection connection;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO seguimiento VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1,id_cliente);
            sentencia.setInt(2,id_muestra);
            sentencia.setInt(3,num_dias_entrega);
            sentencia.setString(4,fecha_ingreso_muestras);
            sentencia.setInt(5,num_nota_pedido);
            sentencia.setString(5,fecha_objetivo_informe);
            sentencia.setInt(5,num_informe);
            sentencia.setString(5,hilo_incandescente);
            sentencia.setString(5,hi_nom_doc_normativo);
            sentencia.setString(5,choque_electrico);
            sentencia.setString(5,ce_nom_doc_normativo);
            sentencia.setString(5,corrocion_oxidacion);
            sentencia.setString(5,co_nom_doc_normativo);
            sentencia.setString(5,adherencia);
            sentencia.setString(5,a_nom_doc_normativo);
            sentencia.setString(5,seccion_trasversal);
            sentencia.setString(5,st_nom_doc_normativo);
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

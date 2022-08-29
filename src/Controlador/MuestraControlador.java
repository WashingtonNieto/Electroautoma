/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Muestra;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author washi
 */
public class MuestraControlador {

    public boolean insertMuestra(int id_informe, String referencia, int id_usuario, String fecha_ingreso, String fecha_max_emision, String descripcion){
        Muestra muestra = new Muestra();
        muestra.id_informe = id_informe;
        muestra.referencia = referencia;
        muestra.id_usuario = id_usuario;
        muestra.fecha_ingreso = fecha_ingreso;
        muestra.fecha_max_emision = fecha_max_emision;
        muestra.descripcion = descripcion;
        return muestra.insert();
    }
    
    public boolean updateMuestra(int id_muestra, int id_informe, String referencia, int id_usuario, String fecha_ingreso, String fecha_max_emision, String descripcion){
        Muestra muestra = new Muestra();
        muestra.id_muestra = id_muestra;
        muestra.id_informe = id_informe;
        muestra.referencia = referencia;
        muestra.id_usuario = id_usuario;
        muestra.fecha_ingreso = fecha_ingreso;
        muestra.fecha_max_emision = fecha_max_emision;
        muestra.descripcion = descripcion;
        return muestra.update();
    }
    
    public boolean deleteMuestra(int id_muestra){
        Muestra muestra = new Muestra();
        return muestra.delete(id_muestra);
    }      
    
    public Muestra findMuestra(int id_muestra){
        Muestra muestra = new Muestra();
        return muestra.find(id_muestra);
    } 

    
    public ArrayList<Muestra> SelectMuestra(){
        Muestra muestra = new Muestra();
        return muestra.select();
    }
    
    
    
    
}

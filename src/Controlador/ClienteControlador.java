/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author washi
 */
public class ClienteControlador {

    public boolean insertCliente(String nombre,String nit, String contacto,String telefono,String direccion,String email){
        Cliente cliente = new Cliente();
        cliente.nombre = nombre;
        cliente.nit = nit;
        cliente.contacto = contacto;
        cliente.telefono = telefono;
        cliente.direccion = direccion;
        cliente.email = email;
        return cliente.insert();
    }
    
    public boolean updateCliente(int id, String nombre, String nit, String contacto,String telefono,String direccion,String email){
        Cliente cliente = new Cliente();
        cliente.id = id;
        cliente.nombre = nombre;
        cliente.nit = nit;
        cliente.contacto = contacto;
        cliente.telefono = telefono;
        cliente.direccion = direccion;
        cliente.email = nit;
        return cliente.update();
    }
    
    public boolean deleteCliente(int id){
        Cliente cliente = new Cliente();
        return cliente.delete(id);
    }      
    
    public Cliente findCliente(int id){
        Cliente cliente = new Cliente();
        return cliente.find(id);
    } 

    
    public ArrayList<Cliente> SelectCliente(){
        Cliente cliente = new Cliente();
        return cliente.select();
    }
    
    
    
    
}

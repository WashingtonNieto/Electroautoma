/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Wnieto
 */
public class UsuarioControlador {


    public ArrayList<Usuario> SelectUsuarios(){
        Usuario usuario = new Usuario();
        return usuario.select();
    }

    public boolean updateUsuario(int id, String nombre, String apellido, String correo){
        Usuario usuario = new Usuario();
        usuario.id = id;
        usuario.nombre = nombre;
        usuario.apellido = apellido;
        usuario.correo = correo;
        return usuario.update();
    }

    public boolean deleteUsuario(int id){
        Usuario usuario = new Usuario();
        return usuario.delete(id);
    }      
    
    public Usuario findUsuario(int id){
        Usuario usuario = new Usuario();
        return usuario.find(id);
    } 

    
    public ArrayList<Usuario> SelectUsuario(){
        Usuario usuario = new Usuario();
        return usuario.select();
    }

}   

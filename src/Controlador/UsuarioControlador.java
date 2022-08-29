/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Wnieto
 */
public class conexionMysql {
    Connection cn;

    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/electroautoma","root","");
            System.out.println("CONECTADO!");
        }catch(Exception e){
            System.out.println("ERROR EN LA CONEXION " + e);
        }
        return cn;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promax;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class Conexion {
    Connection con = null;
    
    //METODO PARA LA CONEXION A LA BASE DE DATOS
    public Connection conexion(){
        try{
            //URL DE LA CONEXION BASE DE DATOS
            String connectionURL = "jdbc:sqlserver://;database=promax;integratedSecurity=true;";
            con = DriverManager.getConnection(connectionURL);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR CON LA CONEXION A LA BASE DE DATOS" + ex);
        }
        return con;
    }
    
}

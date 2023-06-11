/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Progra
 */
public class Conexion {

    Database db = new Database();

    Connection cnn = null;
    Statement st = null;
    protected ResultSet rs;//Guardar los resultados de las sentencias SQL
    
    public Conexion() {
        connectar();
    }

    public void connectar() {
        try {
            Class.forName(db.getDriver());
            cnn = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            st = cnn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CONEXIÓN ERRONEA" + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return cnn;
    }
    
     public synchronized ResultSet seleccionar(String sql) {
        try {
            st = cnn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("clsConexion" + ex.toString());
        }
        return rs;
     }
     
    public void desconexion() {
        try {
            cnn.close();
            System.exit(0);
        } catch (SQLException e) {
        }
    }

}

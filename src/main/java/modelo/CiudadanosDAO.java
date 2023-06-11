/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Ciudadanos;
import dao.BaseDAO;
import helpers.Conexion;
import helpers.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kimberly
 */
public class CiudadanosDAO implements BaseDAO {

    Conexion conectar = new Conexion();
    Database db = new Database();

    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    Ciudadanos ciudadanos = new Ciudadanos();

    @Override
    public Boolean insertar(Object obj) {
        ciudadanos = (Ciudadanos) obj;
        Connection con;
        PreparedStatement ps;

        String sql = "INSERT INTO ciudadanos (cedula, contrasena, correo, nombre, apellido1, apellido2, direccion, habilitado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ciudadanos.getCedula());
            ps.setString(2, ciudadanos.getContrasena());
            ps.setString(3, ciudadanos.getCorreo());
            ps.setString(4, ciudadanos.getNombre());
            ps.setString(5, ciudadanos.getApellido1());
            ps.setString(6, ciudadanos.getApellido2());
            ps.setString(7, ciudadanos.getDireccion());
            ps.setBoolean(8, ciudadanos.getHabilitado());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean actualizar(Object obj) {

        ciudadanos = (Ciudadanos) obj;
        Connection con;
        PreparedStatement pst;

        String sql = "UPDATE ciudadanos SET contrasena = ?, correo = ?, nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, habilitado = ?  WHERE cedula = ?";
        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            ps = con.prepareStatement(sql);

            ps.setString(1, ciudadanos.getContrasena());
            ps.setString(2, ciudadanos.getCorreo());
            ps.setString(3, ciudadanos.getNombre());
            ps.setString(4, ciudadanos.getApellido1());
            ps.setString(5, ciudadanos.getApellido2());
            ps.setString(6, ciudadanos.getDireccion());
            ps.setBoolean(7, ciudadanos.getHabilitado());
            ps.setString(8, ciudadanos.getCedula());

            
            int registros = ps.executeUpdate();
            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage());
            return false;

        }
    }

    @Override
    public Boolean eliminar(Object obj) {

        ciudadanos = (Ciudadanos) obj;
        Connection con;
        PreparedStatement pst;

        String sql = "DELETE FROM ciudadanos WHERE cedula = ?";
        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            ps = con.prepareStatement(sql);

            ps.setString(1, ciudadanos.getCedula());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage());
            return false;

        }
    }


    /*
    @Override
    public void listar(JTable table) {
        
        String[] titulos = {"Cedula", "Contrasena", "Correo", "Nombre", "Apellido1", "Apellido2", "Direccion", "Habilitado"};
        String[] registros = new String[8]; //???????????????
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        
        String sql = "select * from cuidadanos";
        
        try {
            
            con = conectar.getConnection();
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()){
            
                registros[0] = rs.getString("cedula"); // Como se llama el campo en la BD
                registros[1] = rs.getString("contrasena");
                registros[2] = rs.getString("correo");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("apellido1");
                registros[5] = rs.getString("apellido2");
                registros[6] = rs.getString("direccion");
                registros[7] = rs.getString("habilitado");
                model.addRow(registros);
    
            }
            table.setModel(model);
            
            con.close();
            
        }
        
        catch (Exception ex){
        
        }
        
    }
    
     */
    @Override
    public void listarTablaPorTitulo(JTable table, Object obj) {

        ciudadanos = (Ciudadanos) obj;

        //Declarar los headers del table
        String[] titulos = {"cedula", "contrasena", "correo", "nombre", "apellido1", "apellido2", "direccion", "habilitado"};
        String[] registros = new String[8];
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM ciudadanos WHERE cedula LIKE '%" + ciudadanos.getCedula() + "%'";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("cedula"); // Como se llama el campo en la BD
                registros[1] = rs.getString("contrasena");
                registros[2] = rs.getString("correo");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("apellido1");
                registros[5] = rs.getString("apellido2");
                registros[6] = rs.getString("direccion");
                registros[7] = rs.getString("habilitado");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Object[]> listar() {

        ArrayList<Object[]> registros = new ArrayList<>();

        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        String sql = "select * from ciudadanos";

        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                Object[] record = new Object[6];
                for (int i = 0; i < 6; i++) {
                    record[i] = rs.getObject(i + 1);
                }
                registros.add(record);

            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage());

        } finally {

            return registros;

        }

    }
}

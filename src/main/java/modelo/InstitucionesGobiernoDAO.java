/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.InstitucionesGobierno;
import dao.BaseDAO;
import helpers.Conexion;
import helpers.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kimberly
 */
public class InstitucionesGobiernoDAO implements BaseDAO {

    InstitucionesGobierno instituciones = new InstitucionesGobierno();
    Database db = new Database();

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    @Override
    public Boolean insertar(Object obj) {

        instituciones = (InstitucionesGobierno) obj;

        String sql = "INSERT INTO institucionesgobierno (idInstitucion, nombreInstitucion, correoInstitucion, razonSocial, contrasena, reporteador, habilitado VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, instituciones.getIdInstitucion());
            ps.setString(2, instituciones.getNombreInstitucion());
            ps.setString(3, instituciones.getCorreoInstitucion());
            ps.setString(4, instituciones.getRazonSocial());
            ps.setString(5, instituciones.getContrasena());
            ps.setBoolean(6, instituciones.isReporteador());
            ps.setBoolean(7, instituciones.getHabilitado());

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
        int r = 0;

        instituciones = (InstitucionesGobierno) obj;

        String sql = "UPDATE institucionesgobierno SET nombreInstitucion=?, correoInstitucion=?, razonSocial=?, contrasena=?, reporteador=?, habilitado=? WHERE idInstitucion=?";
        try {

         conectar.connectar();
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, instituciones.getNombreInstitucion());
            ps.setString(2, instituciones.getCorreoInstitucion());
            ps.setString(3, instituciones.getRazonSocial());
            ps.setString(4, instituciones.getContrasena());
            ps.setBoolean(5, instituciones.isReporteador());
            ps.setBoolean(6, instituciones.getHabilitado());
            ps.setInt(7, instituciones.getIdInstitucion());

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
    public Boolean eliminar(Object obj) {
        
          int r = 0;
        
        instituciones = (InstitucionesGobierno) obj;

        String sql = "DELETE FROM institucionesgobierno WHERE idInstitucion = ?";
        try {

            conectar.connectar();
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);          
            ps.setInt(1, instituciones.getIdInstitucion());

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

    /*
    @Override
    public void listar(JTable table) {

        String[] titulos = {"idInstitucion", "nombreInstitucion", "correoInstitucion", "razonSocial", "contrasena", "reporteador", "habilitado"};
        String[] registros = new String[7]; 
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String sql = "select * from institucionesgobierno";

        try {

            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("idInstitucion"); // Como se llama el campo en la BD
                registros[1] = rs.getString("nombreInstitucion");
                registros[2] = rs.getString("correoInstitucion");
                registros[3] = rs.getString("razonSocial");
                registros[4] = rs.getString("contrasena");
                registros[5] = rs.getString("reporteador");
                registros[6] = rs.getString("habilitado");
                model.addRow(registros);

            }
            table.setModel(model);

            con.close();

        } catch (Exception ex) {

        }

    }
     */
    @Override
    public void listarTablaPorTitulo(JTable table, Object obj) {

        instituciones = (InstitucionesGobierno) obj;

        //Declarar los headers del table
        String[] titulos = {"idInstitucion", "nombreInstitucion", "correoInstitucion", "razonSocial", "contrasena", "reporteador", "habilitado"};
        String[] registros = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM institucionesgobierno WHERE idInstitucion LIKE '%" + instituciones.getIdInstitucion() + "%'";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idInstitucion"); // Como se llama el campo en la BD
                registros[1] = rs.getString("nombreInstitucion");
                registros[2] = rs.getString("correoInstitucion");
                registros[3] = rs.getString("razonSocial");
                registros[4] = rs.getString("contrasena");
                registros[5] = rs.getString("reporteador");
                registros[6] = rs.getString("habilitado");
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

        String sql = "select * from institucionesgobierno";

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

                Object[] record = new Object[7];
                for (int i = 0; i < 7; i++) {
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

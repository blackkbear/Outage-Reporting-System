/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.ReporteAverias;
import dao.BaseDAO;
import helpers.Conexion;
import helpers.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteyListadoAveriasDAO implements BaseDAO {

    Conexion conectar = new Conexion();
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
  
    ReporteAverias repAve = new ReporteAverias();
    Database db = new Database();

    @Override
    public Boolean insertar(Object obj) {

        repAve = (ReporteAverias) obj;
        // como poner imagen aqui??

        String sql = "INSERT INTO reporteaverias (numeroAveria, usuario, nivelIncidencia, fechaAveria, provincia, canton, distrito, direccionExacta, DescripcionAveria, institucionReportar, estadoAveria)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, repAve.getNumeroAveria());
            ps.setString(2, repAve.getUsuario());
            ps.setString(3, repAve.getNivelIncidencia());
            ps.setDate(4, (Date) repAve.getFechaAveria());
            ps.setString(5, repAve.getProvincia());
            ps.setString(6, repAve.getCanton());
            ps.setString(7, repAve.getDistrito());
            ps.setString(8, repAve.getDireccionExacta());
            ps.setString(9, repAve.getDescripcionAveria());
            ps.setByte(10, repAve.getImagen());
            ps.setString(11, repAve.getInstitucionReportar());
            ps.setString(12, repAve.getEstadoAveria());

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

        repAve = (ReporteAverias) obj;

        String sql = "UPDATE reporteaverias set usuario=?, nivelIncidencia=?, fechaAveria=?, provincia=?, canton=?, distrito=?, direccionExacta=?, DescripcionAveria=?, institucionReportar=?, estadoAveria=? WHERE numeroAveria=?";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, repAve.getUsuario());
            ps.setString(2, repAve.getNivelIncidencia());
            ps.setDate(3, (Date) repAve.getFechaAveria());
            ps.setString(4, repAve.getProvincia());
            ps.setString(5, repAve.getCanton());
            ps.setString(6, repAve.getDistrito());
            ps.setString(7, repAve.getDireccionExacta());
            ps.setString(8, repAve.getDescripcionAveria());
            ps.setByte(9, repAve.getImagen());
            ps.setString(10, repAve.getInstitucionReportar());
            ps.setString(11, repAve.getEstadoAveria());
            ps.setInt(12, repAve.getNumeroAveria());
            
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

        repAve = (ReporteAverias) obj;

        String sql = "DELETE FROM reporteaverias WHERE numeroAveria = ?";
        try {

            conectar.connectar();
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, repAve.getNumeroAveria());

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

        String[] titulos = {"numeroAveria", "usuario", "nivelIncidencia", "fechaAveria", "provincia", "canton", "distrito", "direccionExacta", "descripcionAveria", "institucionReportar", "estadoAveria"};
        String[] registros = new String[11];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String sql = "select * from reporteaverias";

        try {

            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("numeroAveria"); // Como se llama el campo en la BD
                registros[1] = rs.getString("usuario");
                registros[2] = rs.getString("nivelIncidencia");
                registros[3] = rs.getString("fechaAveria");
                registros[4] = rs.getString("provincia");
                registros[5] = rs.getString("canton");
                registros[6] = rs.getString("distrito");
                registros[7] = rs.getString("direccionExacta");
                registros[8] = rs.getString("descripcionAveria");
                registros[9] = rs.getString("institucionReportar");
                registros[10] = rs.getString("estadoAveria");
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

        repAve = (ReporteAverias) obj;

        //Declarar los headers del table
        String[] titulos = {"numeroAveria", "usuario", "nivelIncidencia", "fechaAveria", "provincia", "canton", "distrito", "direccionExacta", "descripcionAveria", "imagen", "institucionReportar", "estadoAveria"};
        String[] registros = new String[12];
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM reporteaverias WHERE numeroAveria LIKE '%" + repAve.getNumeroAveria() + "%'";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("numeroAveria"); // Como se llama el campo en la BD
                registros[1] = rs.getString("usuario");
                registros[2] = rs.getString("nivelIncidencia");
                registros[3] = rs.getString("fechaAveria");
                registros[4] = rs.getString("provincia");
                registros[5] = rs.getString("canton");
                registros[6] = rs.getString("distrito");
                registros[7] = rs.getString("direccionExacta");
                registros[8] = rs.getString("descripcionAveria");
                registros[9] = rs.getString("imagen");
                registros[10] = rs.getString("institucionReportar");
                registros[11] = rs.getString("estadoAveria");
                model.addRow(registros);
            }
            table.setModel(model);
            con.close();
            
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

        String sql = "select * from reporteaverias";

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

                Object[] record = new Object[12];
                for (int i = 0; i < 12; i++) {
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

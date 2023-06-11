/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.SeguimientoAverias;
import dao.BaseDAO;
import helpers.Conexion;
import helpers.Database;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kimberly
 */
public class SeguimientoAveriasDAO implements BaseDAO {

    Conexion conectar = new Conexion();

    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    SeguimientoAverias seguiAver = new SeguimientoAverias();
     Database db = new Database();

    @Override
    public Boolean insertar(Object obj) {

        seguiAver = (SeguimientoAverias) obj;
        // como poner imagen aqui??

        String sql = "INSERT INTO seguimientoaverias (numeroAveria, numeroSeguimiento, descripcionSolucionAveria, horasInvertidas, "
                + "cantidadEmpleadosInvolucrados, costoAproximado, nombrePersonaValidaArreglo, imagenFinalizacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, seguiAver.getNumeroAveria());
            ps.setString(2, seguiAver.getNumeroSeguimiento());
            ps.setString(3, seguiAver.getDescripcionSolucionAveria());
            ps.setDouble(4, seguiAver.getHorasInvertidas());
            ps.setInt(5, seguiAver.getCantidadEmpleadosInvolucrados());
            ps.setDouble(6, seguiAver.getCostoAproximado());
            ps.setString(7, seguiAver.getNombrePersonaValidaArreglo());
            ps.setByte(8, seguiAver.getImagenFinalizacion());
            
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

        seguiAver = (SeguimientoAverias) obj;

        String sql = "UPDATE seguimientoaverias SET numeroAveria=?, descripcionSolucionAveria=?, horasInvertidas=?, "
                + "cantidadEmpleadosInvolucrados=?, costoAproximado=?, nombrePersonaValidaArreglo=?, imagenFinalizacion=? WHERE numeroSeguimiento=?";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, seguiAver.getNumeroAveria());
            ps.setString(2, seguiAver.getDescripcionSolucionAveria());
            ps.setDouble(3, seguiAver.getHorasInvertidas());
            ps.setInt(4, seguiAver.getCantidadEmpleadosInvolucrados());
            ps.setDouble(5, seguiAver.getCostoAproximado());
            ps.setString(6, seguiAver.getNombrePersonaValidaArreglo());
            ps.setByte(7, seguiAver.getImagenFinalizacion());
            ps.setString(8, seguiAver.getNumeroSeguimiento());
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
    public void listarTablaPorTitulo(JTable table, Object obj) {

        seguiAver = (SeguimientoAverias) obj;

        //Declarar los headers del table
        String[] titulos = {"numeroAveria", "numeroSeguimiento", "descripcionSolucionAveria", "horasInvertidas", "cantidadEmpleadosInvolucrados", "costoAproximado", "nombrePersonaValidaArreglo", "imagenFinalizacion"};
        String[] registros = new String[8];
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM seguimientoaverias WHERE numeroAveria LIKE '%" + seguiAver.getNumeroAveria() + "%'";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("numeroAveria"); // Como se llama el campo en la BD
                registros[1] = rs.getString("numeroSeguimiento");
                registros[2] = rs.getString("descripcionSolucionAveria");
                registros[3] = rs.getString("horasInvertidas");
                registros[4] = rs.getString("cantidadEmpleadosInvolucrados");
                registros[5] = rs.getString("costoAproximado");
                registros[6] = rs.getString("nombrePersonaValidaArreglo");
                registros[7] = rs.getString("imagenFinalizacion");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos: " + e.getMessage());
        }
    }

    @Override
    public Boolean eliminar(Object obj) {

        int r = 0;

        seguiAver = (SeguimientoAverias) obj;

        String sql = "DELETE FROM seguimientoaverias WHERE numeroSeguimiento = ?";
        try {

            conectar.connectar();
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, seguiAver.getNumeroSeguimiento());

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

        String[] titulos = {"numeroAveria", "numeroSeguimiento", "descripcionSolucionAveria", "horasInvertidas", "cantidadEmpleadosInvolucrados", "costoAproximado", "nombrePersonaValidaArreglo", "imagenFinalizacion"};
        String[] registros = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String sql = "select * from seguimientoaverias";

        try {

            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("numeroAveria"); // Como se llama el campo en la BD
                registros[1] = rs.getString("numeroSeguimiento");
                registros[2] = rs.getString("descripcionSolucionAveria");
                registros[3] = rs.getString("horasInvertidas");
                registros[4] = rs.getString("cantidadEmpleadosInvolucrados");
                registros[5] = rs.getString("costoAproximado");
                registros[6] = rs.getString("nombrePersonaValidaArreglo");
                registros[7] = rs.getString("imagenFinalizacion");
                model.addRow(registros);

            }
            table.setModel(model);

            con.close();

        } catch (Exception ex) {

        }

    }
*/

    @Override
    public ArrayList<Object[]> listar() {
      ArrayList<Object[]> registros = new ArrayList<>();

        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        String sql = "select * from seguimientoaverias";

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

                Object[] record = new Object[8];
                for (int i = 0; i < 8; i++) {
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

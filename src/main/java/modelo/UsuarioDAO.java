/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Usuario;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO implements BaseDAO {

    Usuario user = new Usuario();
    Database db = new Database();

    Conexion conectar = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Connection con;

    public boolean login(Usuario user) {

        String sql = "SELECT usuario, contrasena, tipoRol FROM usuarios WHERE usuario = ?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (user.getContrasena().equals(rs.getString(3)) && user.getTipoRol().equals(rs.getInt(5))) {
                    user.setUsuario(rs.getString(1));
                    user.setContrasena(rs.getString(3));
                    user.setTipoRol(rs.getString(5));
                    return true;
                } else {
                    return false;
                }
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public int cargarIdUsuario(String usuario) {

        int idUsuario = 0;
        String sql = "SELECT usuario FROM usuarios WHERE usuario = '" + usuario + "'";
        try {

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            idUsuario = rs.getInt("usuario");

        } catch (SQLException e) {
        }

        return idUsuario;

    }

    public void cargarComboIdUsuario(JComboBox combo) {

        combo.removeAllItems();
        combo.addItem("SELECCIONAR Usuario");
        String sql = "SELECT usuario FROM ReporteAverias";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                combo.addItem(rs.getInt(sql));

            }

        } catch (SQLException e) {
        }

    }

    @Override
    public Boolean insertar(Object obj) {

        user = (Usuario) obj;
        Connection con;
        PreparedStatement ps;

        String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?,?)";

        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsuario());
            ps.setInt(2, user.getCedula());
            ps.setString(3, user.getContrasena());
            ps.setString(4, user.getNombreCompleto());
            ps.setString(5, user.getTipoRol());
            ps.setBoolean(6, user.getHabilitado());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (ClassNotFoundException | SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage());
            return false;

        }
    }

    @Override
    public Boolean actualizar(Object obj) {

        user = (Usuario) obj;
        Connection con;
        PreparedStatement ps;

        String sql = "UPDATE usuarios SET cedula = ?, contrasena = ?, nombreCompleto = ?, tipoRol = ?, habilitado = ? WHERE usuario = ? ";
        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );
            ps = con.prepareStatement(sql);

            
            ps.setInt(1, user.getCedula());
            ps.setString(2, user.getContrasena());
            ps.setString(3, user.getNombreCompleto());
            ps.setString(4, user.getTipoRol());
            ps.setBoolean(5, user.getHabilitado());
            ps.setString(6, user.getUsuario());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (Exception ex){
        
            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage() );
            return false;
        
        }
    }

    @Override
    public Boolean eliminar(Object obj) {

       user = (Usuario) obj;
       Connection con ;
       PreparedStatement ps;

        String sql = "DELETE FROM usuarios WHERE usuario = ?";
        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, user.getUsuario());

            int registros = ps.executeUpdate();

            if (registros > 0) {
                con.close();
                return true;
            } else {
                con.close();
                return false;
            }

        } catch (Exception ex){
        
            JOptionPane.showMessageDialog(null, "Ocurrio el siguiente error  : " + ex.getMessage() );
            return false;
        
        }

    }

     /*
    @Override
    public void listar(JTable table) {

        String[] titulos = {"usuario", "cedula", "contrasena", "nombreCompleto", "tipoRol", "habilitado"};
        String[] registros = new String[6];
        DefaultTableModel model = new DefaultTableModel(null, titulos);

        String sql = "select * from usuarios";

        try {

            con = conectar.getConnection();

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = rs.getString("usuario"); // Como se llama el campo en la BD
                registros[1] = rs.getString("cedula");
                registros[2] = rs.getString("contrasena");
                registros[3] = rs.getString("nombreCompleto");
                registros[4] = rs.getString("tipoRol");
                registros[5] = rs.getString("habilitado");
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
 /*
        user = (Usuario) obj;

        //Declarar los headers del table
        String[] titulos = {"usuario", "cedula", "contrasena", "nombreCompleto", "tipoRol", "habilitado"};
        String[] registros = new String[6];
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        String sql = "SELECT * FROM usuarios WHERE usuario LIKE '%" + user.getUsuario() + "%'";
        try {

            conectar.connectar();

            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("usuario"); // Como se llama el campo en la BD
                registros[1] = rs.getString("cedula");
                registros[2] = rs.getString("contrasena");
                registros[3] = rs.getString("nombreCompleto");
                registros[4] = rs.getString("tipoRol");
                registros[5] = rs.getString("habilitado");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al buscar los datos: " + e.getMessage());
        }
*/
    }

    @Override
    public ArrayList<Object[]> listar() {
        
        ArrayList<Object[]> registros = new ArrayList<>();

        Connection con;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "select * from usuarios";

        try {

            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPass()
            );

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

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

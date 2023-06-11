/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BaseDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.frmUsuario;

public class ControllerUsuario implements ActionListener {

    BaseDAO dao = new UsuarioDAO();
    Usuario user = new Usuario();
    frmUsuario vistaUsuario = new frmUsuario();
    //DefaultTableModel modelo = new DefaultTableModel();

    public ControllerUsuario(frmUsuario frm) {

        this.vistaUsuario = frm;
        this.vistaUsuario.btnGuardarUser.addActionListener(this);
        this.vistaUsuario.btnEditarUser.addActionListener(this);
        this.vistaUsuario.btnCancelarUser.addActionListener(this);
        this.vistaUsuario.btnRefrescarUser.addActionListener(this);
        this.vistaUsuario.btnEliminarUser.addActionListener(this);
        this.vistaUsuario.btnBuscarUser.addActionListener(this);
        this.vistaUsuario.cboxTipoUserFrm.addActionListener(this);
        this.vistaUsuario.chkbxHabilitado.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaUsuario.btnGuardarUser) {

            if (vistaUsuario.txtIdUserFrm.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el Id del Usuario", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaUsuario.txtCedula.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la cedula del usuario", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaUsuario.txtContrasenaUser.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la contraseña", "Agregar contraseña", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaUsuario.txtNombreCompleto.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el nombre completo", "Agregar nombre completo", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaUsuario.cboxTipoUserFrm.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe de seleccionar un tipo de usuario", "Seleccionar", JOptionPane.INFORMATION_MESSAGE);

            } else {

                agregarUsuario();

            }

        }
        if (e.getSource() == vistaUsuario.btnEditarUser) {

            if (vistaUsuario.txtIdUserFrm.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el Id del Usuario", "Agregar Usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaUsuario.txtCedula.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la cedula del usuario", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaUsuario.txtContrasenaUser.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar la contraseña", "Agregar contraseña", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaUsuario.txtNombreCompleto.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe ingresar el nombre completo", "Agregar nombre completo", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaUsuario.cboxTipoUserFrm.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaUsuario, "Debe de seleccionar un tipo de usuario", "Seleccionar", JOptionPane.INFORMATION_MESSAGE);
            } else {

                actualizarUsuario();

            }

        }
        if (e.getSource() == vistaUsuario.btnCancelarUser) {

            limpiarCampos();

        }
        if (e.getSource() == vistaUsuario.btnRefrescarUser) {

            filtrarTablaPorTitulo(vistaUsuario.tableUser, "");
            
        }
        if (e.getSource() == vistaUsuario.btnEliminarUser) {

            eliminarUsuario();

        }

        if (e.getSource() == vistaUsuario.btnBuscarUser) {

            listarTablaPorTitulo(vistaUsuario.tableUser, vistaUsuario.txtBuscarNombreUser.getText());

        }

    }

    public void agregarUsuario() {
        String usuario = vistaUsuario.txtIdUserFrm.getText();
        Integer cedula = Integer.parseInt(vistaUsuario.txtCedula.getText());
        String contrasena = vistaUsuario.txtContrasenaUser.getText();
        String nombreCompleto = vistaUsuario.txtNombreCompleto.getText();
        String tipoRol = vistaUsuario.cboxTipoUserFrm.getSelectedItem().toString();
        Boolean habilitado = vistaUsuario.chkbxHabilitado.isEnabled();

        user = new Usuario(usuario, cedula, contrasena, nombreCompleto, tipoRol, habilitado);

        boolean r = dao.insertar(user);

        if (r) {
            filtrarTablaPorTitulo(vistaUsuario.tableUser, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaUsuario, "El Usuario fue agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaUsuario, "El Usuario NO fue agregado");
        }

    }

    public void filtrarTablaPorTitulo(JTable tabla, String filtro) {
        user = new Usuario(filtro);
        dao.listarTablaPorTitulo(tabla, user);
       
    }

    public void actualizarUsuario() {

        if (vistaUsuario.txtIdUserFrm.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaUsuario, "No se Identifica el ID, debe seleccionar un registro en la tabla");
        } else {

            String usuario = vistaUsuario.txtIdUserFrm.getText();
            Integer cedula = Integer.parseInt(vistaUsuario.txtCedula.getText());
            String contrasena = vistaUsuario.txtContrasenaUser.getText();
            String nombreCompleto = vistaUsuario.txtNombreCompleto.getText();
            String tipoRol = vistaUsuario.cboxTipoUserFrm.getSelectedItem().toString();
            Boolean habilitado = vistaUsuario.chkbxHabilitado.isEnabled();

            user = new Usuario(usuario, cedula, contrasena, nombreCompleto, tipoRol, habilitado);

            Boolean r = dao.actualizar(user);

            if (r) {
                filtrarTablaPorTitulo(vistaUsuario.tableUser, "");
                limpiarCampos();
                JOptionPane.showMessageDialog(vistaUsuario, "Usuario Actualizado con exito.");
            } else {
                JOptionPane.showMessageDialog(vistaUsuario, "Usuario NO fue Actualizado con exito.");
            }
        }
    }

    public void iniciar() {

        filtrarTablaPorTitulo(vistaUsuario.tableUser, "");
        limpiarCampos();
    }

    public void limpiarTabla(JTable table, DefaultTableModel model) {

        for (int i = 0; i < table.getRowCount(); i++) {

            model.removeRow(i);
            i = i - 1;

        }

    }

    public void limpiarCampos() {

        vistaUsuario.txtIdUserFrm.setText("");
        vistaUsuario.txtCedula.setText("");
        vistaUsuario.txtContrasenaUser.setText("");
        vistaUsuario.txtNombreCompleto.setText("");
        vistaUsuario.cboxTipoUserFrm.setSelectedItem(0);
        vistaUsuario.chkbxHabilitado.setEnabled(false);

    }

    public void eliminarUsuario() {

        boolean r = false;
        int fila = vistaUsuario.tableUser.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaUsuario, "Para eliminar un registro debe de seleccionar un usuario en la tabla");
        } else {
            String id = (String) vistaUsuario.tableUser.getValueAt(fila, 0);
            user = new Usuario(id);
       //     int id = Integer.parseInt(vistaUsuario.tableUser.getValueAt(fila, 0).toString());
       //     user = new Usuario(id);
            
            r = dao.eliminar(user);
            if (r) {
                filtrarTablaPorTitulo(vistaUsuario.tableUser, "");
                limpiarCampos();
                JOptionPane.showMessageDialog(vistaUsuario, "El Usuario fue eliminado con exito");
            } else {
                JOptionPane.showMessageDialog(vistaUsuario, "El Usuario NO fue eliminado");
            }
        }
    }

    public void listarTablaPorTitulo(JTable table, String filtro) {

        dao.listarTablaPorTitulo(table, filtro);

    }

}

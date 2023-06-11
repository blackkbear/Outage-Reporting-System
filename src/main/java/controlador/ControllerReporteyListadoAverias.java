/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BaseDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ReporteAverias;
import modelo.ReporteyListadoAveriasDAO;
import vista.frmReporteyListadoAverias;

public class ControllerReporteyListadoAverias implements ActionListener {

    BaseDAO dao = new ReporteyListadoAveriasDAO();
    ReporteAverias repAve = new ReporteAverias();
    frmReporteyListadoAverias vistaAverias = new frmReporteyListadoAverias();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControllerReporteyListadoAverias(frmReporteyListadoAverias frm) {

        this.vistaAverias = frm;
        this.vistaAverias.btnGuardarAverias.addActionListener(this);
        this.vistaAverias.btnEditarAverias.addActionListener(this);
        this.vistaAverias.btnCancelarAverias.addActionListener(this);
        this.vistaAverias.btnBuscarAveria.addActionListener(this);
        this.vistaAverias.btnRefrescarAveria.addActionListener(this);
        this.vistaAverias.btnEliminarAverias.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAverias.btnGuardarAverias) {

            if (vistaAverias.txtNumeroAveria.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar el numero de averia", "Agregar averia", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.txtUsuario.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar el nombre del usuario", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.cboxNivelIncidencia.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una opcion", "Seleccionar severidad", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.cboxProvincia.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una provincia", "Seleccionar provincia", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.txtCanton.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar un canton", "Agregar canton", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDistrito.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar un distrito", "Agregar distrito", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDireccion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar su direccion", "Agregar direccion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDescripcion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar la descripcion de la averia", "Agregar descripcion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtInstitucion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una institucion", "Agregar institucion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.cboxEstadoAveria.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar el estado de la averia", "Seleccionar estado", JOptionPane.INFORMATION_MESSAGE);

            } else {

                agregarAveria();

            }

        }
        if (e.getSource() == vistaAverias.btnEditarAverias) {
            if (vistaAverias.txtNumeroAveria.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar el numero de averia", "Agregar averia", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.txtUsuario.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar el nombre del usuario", "Agregar usuario", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.cboxNivelIncidencia.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una opcion", "Seleccionar severidad", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.txtFecha.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar la fecha de la averia", "Agregar fecha", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.cboxProvincia.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar una provincia", "Seleccionar provincia", JOptionPane.INFORMATION_MESSAGE);
            } else if (vistaAverias.txtCanton.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar un canton", "Agregar canton", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDistrito.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar un distrito", "Agregar distrito", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDireccion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar su direccion", "Agregar direccion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtDescripcion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar la descripcion de la averia", "Agregar descripcion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.txtInstitucion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe ingresar una institucion", "Agregar institucion", JOptionPane.INFORMATION_MESSAGE);

            } else if (vistaAverias.cboxEstadoAveria.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(vistaAverias, "Debe seleccionar el estado de la averia", "Seleccionar estado", JOptionPane.INFORMATION_MESSAGE);

            } else {

                actualizarAveria();

            }

        }

        if (e.getSource() == vistaAverias.btnCancelarAverias) {

            limpiarCampos();

        }
        if (e.getSource() == vistaAverias.btnRefrescarAveria) {

            FiltrarTablaPorNombre(vistaAverias.tableAverias,"");
            limpiarCampos();

        }
        if (e.getSource() == vistaAverias.btnEliminarAverias) {

            eliminarAveria();

        }

        if (e.getSource() == vistaAverias.btnBuscarAveria) {

            FiltrarTablaPorNombre(vistaAverias.tableAverias,"");

        }

    }

    public void agregarAveria() {

        String numeroAveria = vistaAverias.txtNumeroAveria.getText();
        String usuario = vistaAverias.txtUsuario.getText();
        String nivelIncidencia = vistaAverias.cboxNivelIncidencia.getSelectedItem().toString();

// convertir esto en date, no se como hacerlo. String fechaAveria = vistaAverias.txtFecha.getText();
        String provincia = vistaAverias.cboxProvincia.getSelectedItem().toString();
        String canton = vistaAverias.txtCanton.getText();
        String distrito = vistaAverias.txtDistrito.getText();
        String direccionExacta = vistaAverias.txtDireccion.getText();
        String DescripcionAveria = vistaAverias.txtDescripcion.getText();

        String institucionReportar = vistaAverias.txtInstitucion.getText();
        String estadoAveria = vistaAverias.cboxEstadoAveria.getSelectedItem().toString();

        repAve = new ReporteAverias();

        boolean r = dao.insertar(repAve);

        if (r) {
            FiltrarTablaPorNombre(vistaAverias.tableAverias,"");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaAverias, "La Averia fue agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaAverias, "La Averia NO fue agregado");
        }

    }

    public void actualizarAveria() {

        if (vistaAverias.txtNumeroAveria.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaAverias, "No se Identifica el numero de averia, debe seleccionar un registro en la tabla");
        } else {

            String usuario = vistaAverias.txtUsuario.getText();
            String nivelIncidencia = vistaAverias.cboxNivelIncidencia.getSelectedItem().toString();
            // convertir esto en date, no se como hacerlo. String fechaAveria = vistaAverias.txtFecha.getText();
            String provincia = vistaAverias.cboxProvincia.getSelectedItem().toString();
            String canton = vistaAverias.txtCanton.getText();
            String distrito = vistaAverias.txtDistrito.getText();
            String direccionExacta = vistaAverias.txtDireccion.getText();
            String DescripcionAveria = vistaAverias.txtDescripcion.getText();

            String institucionReportar = vistaAverias.txtInstitucion.getText();
            String estadoAveria = vistaAverias.cboxEstadoAveria.getSelectedItem().toString();

            repAve = new ReporteAverias();

            Boolean r = dao.actualizar(repAve);

            if (r) {
                FiltrarTablaPorNombre(vistaAverias.tableAverias,"");
                limpiarCampos();
                JOptionPane.showMessageDialog(vistaAverias, "Averia Actualizada con exito.");
            } else {
                JOptionPane.showMessageDialog(vistaAverias, "Averia NO fue Actualizada con exito.");
            }
        }
    }

    public void iniciar() {

        FiltrarTablaPorNombre(vistaAverias.tableAverias,"");
        limpiarCampos();
    }

    public void limpiarTabla(JTable table, DefaultTableModel model) {

        for (int i = 0; i < table.getRowCount(); i++) {

            model.removeRow(i);
            i = i - 1;

        }

    }

    public void limpiarCampos() {

        vistaAverias.txtNumeroAveria.setText("");
        vistaAverias.txtUsuario.setText("");
        vistaAverias.txtFecha.setText("");
        vistaAverias.txtCanton.setText("");
        vistaAverias.txtDistrito.setText("");
        vistaAverias.txtDireccion.setText("");
        vistaAverias.txtDescripcion.setText("");

    }

    public void eliminarAveria() {
        boolean r = false;
        int fila = vistaAverias.tableAverias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaAverias, "Para eliminar un registro debe de seleccionar una averia en la tabla");
        } else {
            int id = Integer.parseInt(vistaAverias.tableAverias.getValueAt(fila, 0).toString());
            repAve = new ReporteAverias(id);
            r = dao.eliminar(repAve);
            if (r) {
                FiltrarTablaPorNombre(vistaAverias.tableAverias,"");
                limpiarCampos();
                JOptionPane.showMessageDialog(vistaAverias, "La Averia fue eliminada con exito");
            } else {
                JOptionPane.showMessageDialog(vistaAverias, "La Averia NO fue eliminado");
            }
        }
    }

    public void FiltrarTablaPorNombre(JTable table, String filtro) {
        repAve = new ReporteAverias(filtro);
        dao.listarTablaPorTitulo(table, dao);

    }
    /*public void cargarComboUsuario(){
   es necesario?
 }*/

}

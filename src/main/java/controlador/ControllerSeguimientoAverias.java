/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BaseDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ReporteAverias;
import modelo.ReporteyListadoAveriasDAO;
import modelo.SeguimientoAverias;
import modelo.SeguimientoAveriasDAO;
import vista.frmReporteyListadoAverias;
import vista.frmSeguimientoAverias;

public class ControllerSeguimientoAverias implements ActionListener {
    
    SeguimientoAverias segAve = new SeguimientoAverias();
    SeguimientoAveriasDAO dao = new SeguimientoAveriasDAO();
    frmSeguimientoAverias vistaSegAve = new frmSeguimientoAverias();
    
    //DefaultTableModel modelo = new DefaultTableModel();

    public ControllerSeguimientoAverias(frmSeguimientoAverias frm) {

        this.vistaSegAve = frm;
        this.vistaSegAve.btnGuardarAveria.addActionListener(this);
        this.vistaSegAve.btnEditarAveria.addActionListener(this);
        this.vistaSegAve.btnCancelarAveria.addActionListener(this);
        this.vistaSegAve.btnBuscar.addActionListener(this);
        this.vistaSegAve.btnRefrescar.addActionListener(this);
        this.vistaSegAve.btnSalir.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaSegAve.btnGuardarAveria) {

            if (vistaSegAve.txtnumeroAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el numero de averia", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            }else if (vistaSegAve.txtnumeroSegAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el numero de seguimiento de averia", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtHorasInvertidas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar las horas invertidas", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtCantEmpleados.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar la cantidad de empleados", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtCostoAprox.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el costo aproximado", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtValidado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el nombre de la persona que valido el arreglo", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                

            } else if (vistaSegAve.txtDescripcionAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar la descripcion", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);

            } else {

                agregarSegAveria();

            }

        }
        if (e.getSource() == vistaSegAve.btnEditarAveria) {
             if (vistaSegAve.txtnumeroAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el numero de averia", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
             
             }else if (vistaSegAve.txtnumeroSegAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el numero de seguimiento de averia", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
            
            } else if (vistaSegAve.txtHorasInvertidas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar las horas invertidas", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtCantEmpleados.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar la cantidad de empleados", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtCostoAprox.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el costo aproximado", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (vistaSegAve.txtValidado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar el nombre de la persona que valido el arreglo", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);
                

            } else if (vistaSegAve.txtDescripcionAveria.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaSegAve, "Debe ingresar la descripcion", "Mantenimiento averia", JOptionPane.INFORMATION_MESSAGE);

            } else {

                actualizarAveria();

            }

        }

        if (e.getSource() == vistaSegAve.btnCancelarAveria) {

            limpiarCampos();

        }
        if (e.getSource() == vistaSegAve.btnRefrescar) {

            FiltrarTablaPorNombre(vistaSegAve.tblSeguimientoAverias,"");
        

        }
        
        if (e.getSource() == vistaSegAve.btnBuscar) {

            FiltrarTablaPorNombre(vistaSegAve.tblSeguimientoAverias,vistaSegAve.txtBuscar.getText());

        }
        

    }

    public void agregarSegAveria() {

        Integer numeroAveria = parseInt(vistaSegAve.txtnumeroAveria.getText());
        String numeroSeguimiento = vistaSegAve.txtnumeroSegAveria.getText();
        String descripcionSolucionAveria = vistaSegAve.txtDescripcionAveria.getText();
        Double horasInvertidas = parseDouble(vistaSegAve.txtHorasInvertidas.getText());
        Integer cantidadEmpleadosInvolucrados = parseInt(vistaSegAve.txtCantEmpleados.getText());
        Double costoAproximado = parseDouble(vistaSegAve.txtCostoAprox.getText());
        String nombrePersonaValidaArreglo = vistaSegAve.txtValidado.getText();
        //Byte imagenFinalizacion = vistaSegAve.

        segAve = new SeguimientoAverias(numeroAveria, numeroSeguimiento, descripcionSolucionAveria, horasInvertidas, cantidadEmpleadosInvolucrados, costoAproximado, nombrePersonaValidaArreglo);

        boolean r = dao.insertar(segAve);

        if (r) {
            FiltrarTablaPorNombre(vistaSegAve.tblSeguimientoAverias,"");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaSegAve, "El seguimiento de averia fue agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaSegAve, "El seguimiento de averia NO fue agregado");
        }

    }

    public void actualizarAveria() {

        if (vistaSegAve.txtnumeroSegAveria.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaSegAve, "No se Identifica el numero de seguimiento de averia, debe seleccionar un registro en la tabla");
        } else {

            Integer numeroAveria = parseInt(vistaSegAve.txtnumeroAveria.getText());
        String numeroSeguimiento = vistaSegAve.txtnumeroSegAveria.getText();
        String descripcionSolucionAveria = vistaSegAve.txtDescripcionAveria.getText();
        Double horasInvertidas = parseDouble(vistaSegAve.txtHorasInvertidas.getText());
        Integer cantidadEmpleadosInvolucrados = parseInt(vistaSegAve.txtCantEmpleados.getText());
        Double costoAproximado = parseDouble(vistaSegAve.txtCostoAprox.getText());
        String nombrePersonaValidaArreglo = vistaSegAve.txtValidado.getText();
        //Byte imagenFinalizacion = vistaSegAve.

        segAve = new SeguimientoAverias(numeroAveria, numeroSeguimiento, descripcionSolucionAveria, horasInvertidas, cantidadEmpleadosInvolucrados, costoAproximado, nombrePersonaValidaArreglo);

            Boolean r = dao.actualizar(segAve);

            if (r) {
                FiltrarTablaPorNombre(vistaSegAve.tblSeguimientoAverias,"");
                limpiarCampos();
                JOptionPane.showMessageDialog(vistaSegAve, "Averia Actualizada con exito.");
            } else {
                JOptionPane.showMessageDialog(vistaSegAve, "Averia NO fue Actualizada con exito.");
            }
        }
    }

    public void iniciar() {

        FiltrarTablaPorNombre(vistaSegAve.tblSeguimientoAverias,"");
        limpiarCampos();
    }

    public void limpiarTabla(JTable table, DefaultTableModel model) {

        for (int i = 0; i < table.getRowCount(); i++) {

            model.removeRow(i);
            i = i - 1;

        }

    }

    public void limpiarCampos() {

        vistaSegAve.txtnumeroAveria.setText("");
        vistaSegAve.txtnumeroSegAveria.setText("");
        vistaSegAve.txtHorasInvertidas.setText("");
        vistaSegAve.txtCantEmpleados.setText("");
        vistaSegAve.txtCostoAprox.setText("");
        vistaSegAve.txtValidado.setText("");
        vistaSegAve.txtDescripcionAveria.setText("");

    }



    public void FiltrarTablaPorNombre(JTable table, String filtro) {
        segAve = new SeguimientoAverias(filtro);
        dao.listarTablaPorTitulo(table, dao);

    }
    /*public void cargarComboUsuario(){
   es necesario?
 }*/


}

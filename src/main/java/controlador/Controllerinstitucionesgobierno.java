/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.BaseDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.InstitucionesGobierno;
import modelo.InstitucionesGobiernoDAO;
import vista.frmRegistroInstituciones;

/**
 *
 * @author Susana Burch
 */
public class Controllerinstitucionesgobierno implements ActionListener{

    InstitucionesGobierno instgob = new InstitucionesGobierno();
    InstitucionesGobiernoDAO dao = new InstitucionesGobiernoDAO();
    frmRegistroInstituciones vistaInstitucion = new frmRegistroInstituciones();


    public Controllerinstitucionesgobierno (frmRegistroInstituciones frm) {
        this.vistaInstitucion = frm;
        this.vistaInstitucion.btnguardar.addActionListener(this);
        this.vistaInstitucion.btncancelar.addActionListener(this);
        this.vistaInstitucion.btneliminar.addActionListener(this);
        this.vistaInstitucion.btneditar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInstitucion.btnguardar) {
            if (vistaInstitucion.txtidInstitucion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el ID de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtidInstitucion.requestFocus();
                
            } else if (vistaInstitucion.txtnombreInstitucion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el nombre de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtnombreInstitucion.requestFocus();
                
            } else if (vistaInstitucion.txtcorreoInstitucional.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el correo de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtcorreoInstitucional.requestFocus();
                
            } else if (vistaInstitucion.txtrazonSocial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese la razon social de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtrazonSocial.requestFocus();
                
            } else if (vistaInstitucion.txtcontrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese la contraseña de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtcontrasena.requestFocus();
            } else {
                agregarInstitucion();
            }
        }
        
        if (e.getSource() == vistaInstitucion.btneditar) {
            if (vistaInstitucion.txtidInstitucion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el ID de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtidInstitucion.requestFocus();
                
            } else if (vistaInstitucion.txtnombreInstitucion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el nombre de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtnombreInstitucion.requestFocus();
                
            } else if (vistaInstitucion.txtcorreoInstitucional.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese el correo de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtcorreoInstitucional.requestFocus();
                
            } else if (vistaInstitucion.txtrazonSocial.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese la razon social de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtrazonSocial.requestFocus();
                
            } else if (vistaInstitucion.txtcontrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaInstitucion, "Ingrese la contraseña de la Institucion", "Agregar Institucion", JOptionPane.INFORMATION_MESSAGE);
                vistaInstitucion.txtcontrasena.requestFocus();
            } else {
                agregarInstitucion();
            }
        }


        if (e.getSource()
                == vistaInstitucion.btncancelar) {
            limpiarCampos();
        }

        if (e.getSource()
                == vistaInstitucion.btneliminar) {
            eliminarInstitucion();
        }
    }

    public void agregarInstitucion() {
         
        Integer idInstitucion = Integer.parseInt(vistaInstitucion.txtidInstitucion.getText());
        String nombreInstitucion = vistaInstitucion.txtnombreInstitucion.getText();
        String correoInstitucion = vistaInstitucion.txtcorreoInstitucional.getText();
        String razonSocial = vistaInstitucion.txtrazonSocial.getText();
        String contrasena = vistaInstitucion.txtcontrasena.getText();
        Boolean reporteador = vistaInstitucion.chkboxreporteador.isEnabled();
        Boolean habilitado = vistaInstitucion.chkbxHabilitado.isEnabled();

        instgob = new InstitucionesGobierno(idInstitucion, nombreInstitucion, correoInstitucion, razonSocial, contrasena, reporteador, habilitado);
//differences
        boolean r = dao.insertar(instgob);
        
        if (r) {
            filtrarTablaPorID(vistaInstitucion.tblInstituciones, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaInstitucion, "La Institucion fue agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaInstitucion, "La institucion NO fue agregado");
        }
    }
    
      public void actualizarInstitucion() {

        Integer idInstitucion = Integer.parseInt(vistaInstitucion.txtidInstitucion.getText());
        String nombreInstitucion = vistaInstitucion.txtnombreInstitucion.getText();
        String correoInstitucion = vistaInstitucion.txtcorreoInstitucional.getText();
        String razonSocial = vistaInstitucion.txtrazonSocial.getText();
        String contrasena = vistaInstitucion.txtcontrasena.getText();
        Boolean reporteador = vistaInstitucion.chkboxreporteador.isEnabled();
        Boolean habilitado = vistaInstitucion.chkbxHabilitado.isEnabled();
        
        instgob = new InstitucionesGobierno(idInstitucion, nombreInstitucion, correoInstitucion, razonSocial, contrasena, reporteador, habilitado);
        
        Boolean r = dao.actualizar(instgob);
        if (r) {
            filtrarTablaPorID(vistaInstitucion.tblInstituciones, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaInstitucion, "La Institucion fue actualizado con exito");
        } else {
            JOptionPane.showMessageDialog(vistaInstitucion, "La Institucion NO fue actualizada");
        }
    }
    

    public void filtrarTablaPorID(JTable tabla, String filtro) {
       instgob = new InstitucionesGobierno(filtro);
       dao.listarTablaPorTitulo(tabla, instgob);
        }
    
 //       String[] titulos = {"ID Institucion", "Nombre Institucion", "Correo Institucion", "Razon Social", "Contraseña", "Reporteador"};
 //       String[] registros = new String[7];
 //       DefaultTableModel model = new DefaultTableModel(null, titulos);
//        try {
//
//            for (Object rs : listInstituciones) {
//                InstitucionesGobierno auxProductos = (InstitucionesGobierno) rs;
//                registros[0] = auxProductos.getIdInstitucion().toString();
//                registros[1] = auxProductos.getNombreInstitucion();
//                registros[2] = auxProductos.getCorreoInstitucion();
//                registros[3] = auxProductos.getRazonSocial();
//                registros[4] = auxProductos.getContrasena();
     //         registros[5] = auxProductos.isReporteador();?
//                model.addRow(registros);
//            }
//            tabla.setModel(model);
 //       } catch (Exception e) {
//            System.out.println("Error al buscar los datos: " + e.getMessage());
//        }

    

    public void eliminarInstitucion() {
        boolean r = false;
        int fila = vistaInstitucion.tblInstituciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaInstitucion, "Seleccione una Institucion a eliminar");
        } else {
            String id = (String) vistaInstitucion.tblInstituciones.getValueAt(fila, 0);
            instgob = new InstitucionesGobierno(id);
            r = dao.eliminar(instgob);
            if (r) {
            filtrarTablaPorID(vistaInstitucion.tblInstituciones, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaInstitucion, "La institucion fue eliminada con exito");
            } else {
                JOptionPane.showMessageDialog(vistaInstitucion, "La institucion NO fue eliminada");
            }
        }

    }

    public void limpiarCampos() {
        vistaInstitucion.txtidInstitucion.setText("");
        vistaInstitucion.txtcontrasena.setText("");
        vistaInstitucion.txtcorreoInstitucional.setText("");
        vistaInstitucion.txtnombreInstitucion.setText("");
        vistaInstitucion.txtrazonSocial.setText("");
        vistaInstitucion.txtcontrasena.setText("");
        vistaInstitucion.chkboxreporteador.setEnabled(false);
    }

    public void iniciar() {
        filtrarTablaPorID(vistaInstitucion.tblInstituciones, "");
        limpiarCampos();
    }
}

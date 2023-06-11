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
import modelo.Ciudadanos;
import vista.frmRegistroCiudadanos;
import modelo.CiudadanosDAO;
//import vista.MainPage;
/**
 *
 * @author minin
 */
public class Controllerciudadanos implements ActionListener{

    Ciudadanos ciuda = new Ciudadanos();
    CiudadanosDAO dao = new CiudadanosDAO();
    frmRegistroCiudadanos vistaCiudadano = new frmRegistroCiudadanos();

    public Controllerciudadanos (frmRegistroCiudadanos frm) {
        this.vistaCiudadano = frm;
        this.vistaCiudadano.btnguardar.addActionListener(this);
        this.vistaCiudadano.btncancelar.addActionListener(this);
        this.vistaCiudadano.btneliminar.addActionListener(this);
        this.vistaCiudadano.btneditar.addActionListener(this);
        this.vistaCiudadano.btnbuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCiudadano.btnguardar) {
            if (vistaCiudadano.txtcedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su numero de cedula", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcedula.requestFocus();
                
            } else if (vistaCiudadano.txtcontrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su contraseña", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcontrasena.requestFocus();
                
            } else if (vistaCiudadano.txtcorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su correo", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcorreo.requestFocus();
                
            } else if (vistaCiudadano.txtnombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su nombre", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtnombre.requestFocus();
                
            } else if (vistaCiudadano.txtprimerapellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su primer apellido", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtprimerapellido.requestFocus();
                
            } else if (vistaCiudadano.txtsegundoapellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su segundo apellido", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtsegundoapellido.requestFocus();
                
            } else if (vistaCiudadano.txtdireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe su dirección", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtdireccion.requestFocus();
            } else {
                agregarCiudadano();
            }
        }
        
        
                if (e.getSource() == vistaCiudadano.btneditar) {
            if (vistaCiudadano.txtcedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su numero de cedula", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcedula.requestFocus();
                
            } else if (vistaCiudadano.txtcontrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su contraseña", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcontrasena.requestFocus();
                
            } else if (vistaCiudadano.txtcorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su correo", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtcorreo.requestFocus();
                
            } else if (vistaCiudadano.txtnombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su nombre", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtnombre.requestFocus();
                
            } else if (vistaCiudadano.txtprimerapellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su primer apellido", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtprimerapellido.requestFocus();
                
            } else if (vistaCiudadano.txtsegundoapellido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe ingresar su segundo apellido", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtsegundoapellido.requestFocus();
                
            } else if (vistaCiudadano.txtdireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano debe su dirección", "Agregar Ciudadano", JOptionPane.INFORMATION_MESSAGE);
                vistaCiudadano.txtdireccion.requestFocus();
                
            } else {
                agregarCiudadano();
            }
        }
                
        if (e.getSource()
                == vistaCiudadano.btnbuscar) {
            filtrarTablaPorCedula(vistaCiudadano.Tableciudadano, vistaCiudadano.txtBuscar.getText());
        }
        
        if (e.getSource()
                == vistaCiudadano.btncancelar) {
            limpiarCampos();
        }

        if (e.getSource()
                == vistaCiudadano.btneliminar) {
            eliminarCiudadano();
        }
    }

    public void agregarCiudadano() {
        
        String cedula = vistaCiudadano.txtcedula.getText();
        String contrasena = vistaCiudadano.txtcontrasena.getText();
        String correo = vistaCiudadano.txtcorreo.getText();
        String nombre = vistaCiudadano.txtnombre.getText();
        String apellido1 = vistaCiudadano.txtprimerapellido.getText();
        String apellido2 = vistaCiudadano.txtsegundoapellido.getText();
        String direccion = vistaCiudadano.txtdireccion.getText();
        Boolean habilitado = vistaCiudadano.chkbxHabilitado.isEnabled();

        ciuda = new Ciudadanos(cedula, contrasena, correo, nombre, apellido1, apellido2, direccion, habilitado);

        boolean r = dao.insertar(ciuda);

        if (r) {
         filtrarTablaPorCedula(vistaCiudadano.Tableciudadano, "");
        limpiarCampos();
        JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano fue agregado correctamente");
        }else{
        JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano NO fue agregado");
        }
    }
    
    public void actualizarCiudadano() {
        
         String cedula = vistaCiudadano.txtcedula.getText();
         String contrasena = vistaCiudadano.txtcontrasena.getText();
         String correo = vistaCiudadano.txtcorreo.getText();
         String nombre = vistaCiudadano.txtnombre.getText();
         String apellido1 = vistaCiudadano.txtprimerapellido.getText();
         String apellido2 = vistaCiudadano.txtsegundoapellido.getText();
         String direccion = vistaCiudadano.txtdireccion.getText();
         Boolean habilitado = vistaCiudadano.chkbxHabilitado.isEnabled();

        ciuda = new Ciudadanos(cedula, contrasena, correo, nombre, apellido1, apellido2, direccion, habilitado);

        Boolean r = dao.actualizar(ciuda);
        if (r) {
            filtrarTablaPorCedula(vistaCiudadano.Tableciudadano, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano fue actualizado con exito");
        } else {
            JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano NO fue actualizado");
        }
        
    }

    public void filtrarTablaPorCedula(JTable tabla, String filtro) {
        ciuda = new Ciudadanos(filtro);
        dao.listarTablaPorTitulo(tabla, ciuda);

    }

    public void eliminarCiudadano() {
        boolean r = false;
        int fila = vistaCiudadano.Tableciudadano.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaCiudadano, "Para eliminar un registro debe de seleccionar un ciudadano en la tabla");
        } else {
            String id = (String) vistaCiudadano.Tableciudadano.getValueAt(fila, 0);
            ciuda = new Ciudadanos(id);
            r = dao.eliminar(ciuda);
            if (r) {
            filtrarTablaPorCedula(vistaCiudadano.Tableciudadano, "");
            limpiarCampos();
            JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano fue eliminado con exito");
            }else {
                JOptionPane.showMessageDialog(vistaCiudadano, "El ciudadano NO fue eliminado");
            }
        }

    }

    public void limpiarCampos() {
        vistaCiudadano.txtcedula.setText("");
        vistaCiudadano.txtcontrasena.setText("");
        vistaCiudadano.txtcorreo.setText("");
        vistaCiudadano.txtnombre.setText("");
        vistaCiudadano.txtprimerapellido.setText("");
        vistaCiudadano.txtsegundoapellido.setText("");
        vistaCiudadano.txtdireccion.setText("");
        vistaCiudadano.chkbxHabilitado.setEnabled(false);
    }

    public void iniciar() {
        filtrarTablaPorCedula(vistaCiudadano.Tableciudadano, "");
        limpiarCampos();
    }
}

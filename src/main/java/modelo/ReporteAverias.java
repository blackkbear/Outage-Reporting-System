/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.Date;

/**
 *
 * @author Kimberly
 */
public class ReporteAverias {

    private Integer numeroAveria;
    private String usuario;
    private String nivelIncidencia;
    private Date fechaAveria;
    private String provincia;
    private String canton;
    private String distrito;
    private String direccionExacta;
    private String DescripcionAveria;
    private byte imagen; //atributo imagen //DB BLOB
    private String institucionReportar;
    private String estadoAveria;

    public ReporteAverias() {
    }

    public ReporteAverias(Integer numeroAveria, String usuario, String nivelIncidencia, Date fechaAveria, String provincia, String canton, String distrito, String direccionExacta, String DescripcionAveria, byte imagen, String institucionReportar, String estadoAveria) {
        this.numeroAveria = numeroAveria;
        this.usuario = usuario;
        this.nivelIncidencia = nivelIncidencia;
        this.fechaAveria = fechaAveria;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.direccionExacta = direccionExacta;
        this.DescripcionAveria = DescripcionAveria;
        this.imagen = imagen;
        this.institucionReportar = institucionReportar;
        this.estadoAveria = estadoAveria;
    }

    public ReporteAverias(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ReporteAverias(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getNumeroAveria() {
        return numeroAveria;
    }

    public void setNumeroAveria(Integer numeroAveria) {
        this.numeroAveria = numeroAveria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNivelIncidencia() {
        return nivelIncidencia;
    }

    public void setNivelIncidencia(String nivelIncidencia) {
        this.nivelIncidencia = nivelIncidencia;
    }

    public Date getFechaAveria() {
        return fechaAveria;
    }

    public void setFechaAveria(Date fechaAveria) {
        this.fechaAveria = fechaAveria;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public String getDescripcionAveria() {
        return DescripcionAveria;
    }

    public void setDescripcionAveria(String DescripcionAveria) {
        this.DescripcionAveria = DescripcionAveria;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }

    public String getInstitucionReportar() {
        return institucionReportar;
    }

    public void setInstitucionReportar(String institucionReportar) {
        this.institucionReportar = institucionReportar;
    }

    public String getEstadoAveria() {
        return estadoAveria;
    }

    public void setEstadoAveria(String estadoAveria) {
        this.estadoAveria = estadoAveria;
    }

}

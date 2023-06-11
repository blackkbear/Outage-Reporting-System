/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kimberly
 */
public class InstitucionesGobierno {

    private Integer idInstitucion;
    private String nombreInstitucion;
    private String correoInstitucion;
    private String razonSocial;
    private String contrasena;
    private Boolean reporteador;
    private Boolean habilitado;

    public InstitucionesGobierno() {
    }

    public InstitucionesGobierno(Integer idInstitucion, String nombreInstitucion, String correoInstitucion, String razonSocial, String contrasena, Boolean reporteador, Boolean habilitado) {
        this.idInstitucion = idInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.correoInstitucion = correoInstitucion;
        this.razonSocial = razonSocial;
        this.contrasena = contrasena;
        this.reporteador = reporteador;
        this.habilitado = habilitado;
    }

    

    public InstitucionesGobierno(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InstitucionesGobierno(InstitucionesGobierno instgob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Integer idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String NombreInstitucion) {
        this.nombreInstitucion = NombreInstitucion;
    }

    public String getCorreoInstitucion() {
        return correoInstitucion;
    }

    public void setCorreoInstitucion(String CorreoInstitucion) {
        this.correoInstitucion = CorreoInstitucion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean isReporteador() {
        return reporteador;
    }

    public void setReporteador(Boolean reporteador) {
        this.reporteador = reporteador;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    
    
}

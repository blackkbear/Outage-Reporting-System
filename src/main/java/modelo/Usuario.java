package modelo;

/**
 *
 * @author two_r
 */
public class Usuario {

    private String usuario;
    private Integer cedula;
    private String contrasena;
    private String nombreCompleto;
    private String tipoRol;
    private Boolean habilitado;
   

    public Usuario() {   
    }
    

    public Usuario(String usuario, Integer cedula, String contrasena, String nombreCompleto, String tipoRol, Boolean habilitado) {
        this.usuario = usuario;
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.tipoRol = tipoRol;
        this.habilitado = habilitado;
    }

    public Usuario(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }   
}

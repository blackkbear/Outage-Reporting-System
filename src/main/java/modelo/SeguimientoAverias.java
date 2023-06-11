/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;

/**
 *
 * @author Kimberly
 */
public class SeguimientoAverias {

    private Integer numeroAveria;
    private String numeroSeguimiento;
    private String descripcionSolucionAveria;
    private Double horasInvertidas;
    private Integer cantidadEmpleadosInvolucrados;
    private Double costoAproximado;
    private String nombrePersonaValidaArreglo;
    private byte imagenFinalizacion; //byte?

    public SeguimientoAverias() {
    }

    public SeguimientoAverias(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }
    
    
    
    public SeguimientoAverias(Integer numeroAveria, String numeroSeguimiento, String descripcionSolucionAveria, Double horasInvertidas, Integer cantidadEmpleadosInvolucrados, Double costoAproximado, String nombrePersonaValidaArreglo) {
        this.numeroAveria = numeroAveria;
        this.numeroSeguimiento = numeroSeguimiento;
        this.descripcionSolucionAveria = descripcionSolucionAveria;
        this.horasInvertidas = horasInvertidas;
        this.cantidadEmpleadosInvolucrados = cantidadEmpleadosInvolucrados;
        this.costoAproximado = costoAproximado;
        this.nombrePersonaValidaArreglo = nombrePersonaValidaArreglo;
    }
    public SeguimientoAverias(Integer numeroAveria, String numeroSeguimiento, String descripcionSolucionAveria, Double horasInvertidas, Integer cantidadEmpleadosInvolucrados, Double costoAproximado, String nombrePersonaValidaArreglo, byte imagenFinalizacion) {
        this.numeroAveria = numeroAveria;
        this.numeroSeguimiento = numeroSeguimiento;
        this.descripcionSolucionAveria = descripcionSolucionAveria;
        this.horasInvertidas = horasInvertidas;
        this.cantidadEmpleadosInvolucrados = cantidadEmpleadosInvolucrados;
        this.costoAproximado = costoAproximado;
        this.nombrePersonaValidaArreglo = nombrePersonaValidaArreglo;
        this.imagenFinalizacion = imagenFinalizacion;
    }

    public Integer getNumeroAveria() {
        return numeroAveria;
    }

    public void setNumeroAveria(Integer numeroAveria) {
        this.numeroAveria = numeroAveria;
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public String getDescripcionSolucionAveria() {
        return descripcionSolucionAveria;
    }

    public void setDescripcionSolucionAveria(String descripcionSolucionAveria) {
        this.descripcionSolucionAveria = descripcionSolucionAveria;
    }

    public Double getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(Double horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public Integer getCantidadEmpleadosInvolucrados() {
        return cantidadEmpleadosInvolucrados;
    }

    public void setCantidadEmpleadosInvolucrados(Integer cantidadEmpleadosInvolucrados) {
        this.cantidadEmpleadosInvolucrados = cantidadEmpleadosInvolucrados;
    }

    public Double getCostoAproximado() {
        return costoAproximado;
    }

    public void setCostoAproximado(Double costoAproximado) {
        this.costoAproximado = costoAproximado;
    }

    public String getNombrePersonaValidaArreglo() {
        return nombrePersonaValidaArreglo;
    }

    public void setNombrePersonaValidaArreglo(String nombrePersonaValidaArreglo) {
        this.nombrePersonaValidaArreglo = nombrePersonaValidaArreglo;
    }

    public byte getImagenFinalizacion() {
        return imagenFinalizacion;
    }

    public void setImagenFinalizacion(byte imagenFinalizacion) {
        this.imagenFinalizacion = imagenFinalizacion;
    }

}

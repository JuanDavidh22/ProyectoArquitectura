/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.dto;

import java.io.Serializable;

/**
 *
 * @author juanc
 */
public class Proyecto {

    private long idproyecto;
    
    private String responsable;

    private String nombre;
    
    private String fechaInicio;

    private String fechaLimite;

    private Integer cantidadRecaudar;
    
    private Integer cantidadRecaudada;

    private String descripcion;
    
    private String estado;
    
    private String tipoProyecto;
    
    public Proyecto() {
    }

    public Proyecto(long idproyecto, String responsable, String nombre, String fechaInicio, String fechaLimite, Integer cantidadRecaudar, Integer cantidadRecaudada, String descripcion, String estado, String tipoProyecto) {
        this.idproyecto = idproyecto;
        this.responsable = responsable;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.cantidadRecaudar = cantidadRecaudar;
        this.cantidadRecaudada = cantidadRecaudada;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoProyecto = tipoProyecto;
    }

    public long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(long idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getCantidadRecaudada() {
        return cantidadRecaudada;
    }

    public void setCantidadRecaudada(Integer cantidadRecaudada) {
        this.cantidadRecaudada = cantidadRecaudada;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Integer getCantidadRecaudar() {
        return cantidadRecaudar;
    }

    public void setCantidadRecaudar(Integer cantidadRecaudar) {
        this.cantidadRecaudar = cantidadRecaudar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

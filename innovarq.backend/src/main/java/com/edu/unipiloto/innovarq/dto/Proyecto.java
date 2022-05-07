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
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idproyecto;

    private String nombre;

    private String fechaLimite;

    private Integer cantidadRecaudar;

    private String descripcion;

    public Proyecto(long idproyecto, String nombre, String fechaLimite, Integer cantidadRecaudar, String descripcion) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
        this.fechaLimite = fechaLimite;
        this.cantidadRecaudar = cantidadRecaudar;
        this.descripcion = descripcion;
    }

    public Proyecto() {
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

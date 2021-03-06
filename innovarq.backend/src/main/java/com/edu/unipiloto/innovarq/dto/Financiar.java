/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.dto;

/**
 *
 * @author juanc
 */
public class Financiar {
//    Id proyecto, id donante, fecha, valor. (Verificar estado proyecto)
    private long idProyecto;
    private String login;
    private String fecha;
    private int valorDonar;
    
    public Financiar(){      
    }

    public Financiar(long idProyecto, String login, String fecha, int valorDonar) {
        this.idProyecto = idProyecto;
        this.login = login;
        this.fecha = fecha;
        this.valorDonar = valorDonar;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getValorDonar() {
        return valorDonar;
    }

    public void setValorDonar(int valorDonar) {
        this.valorDonar = valorDonar;
    }
    
}

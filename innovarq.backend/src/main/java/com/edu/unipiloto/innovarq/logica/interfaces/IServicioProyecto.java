/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.unipiloto.innovarq.logica.interfaces;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juanc
 */
@Local
public interface IServicioProyecto {

    public Proyecto agregarProyecto(Proyecto oferta);

    public List<Proyecto> getProyectos();
    
    public Proyecto financiarProyecto(Proyecto proyecto);
    
    public String cambiarEstadoProyecto(Proyecto proyecto);
}

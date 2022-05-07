/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.ejb;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioPersistenciaMock;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioProyecto;
import com.edu.unipiloto.innovarq.persistencia.ServicioPersistenciaMock;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author juanc
 */
@Stateless
public class ServicioProyectos implements IServicioProyecto {
    
    private IServicioPersistenciaMock persistencia;

    public ServicioProyectos() {
        persistencia = new ServicioPersistenciaMock();
    }

    @Override
    public Proyecto agregarProyecto(Proyecto proyecto) {
        persistencia.create(proyecto);
        return proyecto;
    }

    @Override
    public List<Proyecto> getProyectos() {
    return persistencia.findAll(Proyecto.class);
    }

    @Override
    public Proyecto financiarProyecto(Proyecto proyecto) {
        
        return null;
        
    }
    
}

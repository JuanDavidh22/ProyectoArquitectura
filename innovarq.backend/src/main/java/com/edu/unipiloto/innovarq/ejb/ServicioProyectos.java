/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.ejb;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import com.edu.unipiloto.innovarq.dto.Usuario;
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
        
        Usuario user = (Usuario) persistencia.findById(Usuario.class, proyecto.getResponsable());
        
        if(user.getTipoUsuario().equals("Emprendedor")){
            persistencia.create(proyecto);
        return proyecto;
        }else{
            return null;
        }
    }

    @Override
    public List<Proyecto> getProyectos() {
        return persistencia.findAll(Proyecto.class);
    }

    @Override
    public Proyecto financiarProyecto(Proyecto proyecto) {
        int cantidaddinero = 0;

        //falra mirar si el usuario es emprendedor o financiador
        
        Proyecto pro = (Proyecto) persistencia.findById(Proyecto.class, proyecto.getIdproyecto());
        
        if ("publicado".equals(pro.getEstado()) || "monitoreo".equals(pro.getEstado())) {
            cantidaddinero = proyecto.getCantidadRecaudada() + pro.getCantidadRecaudada();

            if (cantidaddinero < pro.getCantidadRecaudar()) {
                pro.setCantidadRecaudada(proyecto.getCantidadRecaudada());

            } else if (pro.getCantidadRecaudar() == pro.getCantidadRecaudada()) {
                System.out.println("La cantidad de dinero solicitada ya se ha recolectado");

            } else if (cantidaddinero > pro.getCantidadRecaudar()) {
                cantidaddinero = cantidaddinero - pro.getCantidadRecaudar();
                pro.setCantidadRecaudada(pro.getCantidadRecaudar());
                System.out.println("El proyecto completó la inversión necesaria de " + pro.getCantidadRecaudar() + ", le sobran " + cantidaddinero);
                pro.setEstado("cierre");
            }
        } else {
            System.out.println("el proyecto está cerrado");
        }
        persistencia.update(pro);
        return pro;
    }

    @Override
    public String cambiarEstadoProyecto(Proyecto proyecto) {
        persistencia.update(proyecto);
        return proyecto.getTipoProyecto();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.ejb;

import com.edu.unipiloto.innovarq.dto.Financiar;
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

        if (user.getTipoUsuario().equals("Emprendedor")) {
            persistencia.create(proyecto);
            return proyecto;
        } else {
            return null;
        }
    }

    @Override
    public List<Proyecto> getProyectos() {
        return persistencia.findAll(Proyecto.class);
    }

    @Override
    public Proyecto financiarProyecto(Financiar financiar) {
        int cantidaddinero = 0;

        Usuario user = (Usuario) persistencia.findById(Usuario.class, financiar.getLogin());

        Proyecto pro = (Proyecto) persistencia.findById(Proyecto.class, financiar.getIdProyecto());

        if (user.getTipoUsuario().equals("Financiador")) {

            if ("publicado".equals(pro.getEstado()) || "monitoreo".equals(pro.getEstado())) {
                cantidaddinero = financiar.getValorDonar() + pro.getCantidadRecaudada();

                if (cantidaddinero < pro.getCantidadRecaudar()) {
                    pro.setCantidadRecaudada(cantidaddinero);
                    persistencia.update(pro);

                } else if (pro.getCantidadRecaudar() == pro.getCantidadRecaudada()) {
                    System.out.println("La cantidad de dinero solicitada ya se ha recolectado");

                } else if (cantidaddinero > pro.getCantidadRecaudar()) {
                    cantidaddinero = cantidaddinero - pro.getCantidadRecaudar();
                    pro.setCantidadRecaudada(pro.getCantidadRecaudar());
                    System.out.println("El proyecto completó la inversión necesaria de " + pro.getCantidadRecaudar() + ", le sobran " + cantidaddinero);
                    pro.setEstado("cierre");
                    persistencia.update(pro);
                }
            } else {
                System.out.println("el proyecto está cerrado");
            }
            
        } else {
            System.out.println("Usted es un emprendedor y no puede realizar donaciones a proyectos");
        }
        return pro;
    }

    @Override
    public String cambiarEstadoProyecto(Proyecto proyecto) {
        persistencia.update(proyecto);
        return proyecto.getTipoProyecto();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.servicios;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import com.edu.unipiloto.innovarq.dto.Usuario;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioProyecto;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioRegistroMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author juanc
 */

@Path("/Proyecto")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class proyectoService {
    
    @EJB
    private IServicioProyecto proyectoEJB;
    
    @POST
    @Path("registraProyecto/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Proyecto registrarUsuarios(Proyecto proyecto) {
        proyectoEJB.agregarProyecto(proyecto);
        return proyecto;
    }
    
    @GET
    @Path("obtenerProyectos/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proyecto> getTodasLosProyectos() {
        return proyectoEJB.getProyectos();
    }
    
    @POST
    @Path("financiarProyecto/")
    @Produces(MediaType.APPLICATION_JSON)
    public Proyecto financiarProyectos(Proyecto proyecto) {
        proyectoEJB.financiarProyecto(proyecto);
        return proyecto;
    }
    
}

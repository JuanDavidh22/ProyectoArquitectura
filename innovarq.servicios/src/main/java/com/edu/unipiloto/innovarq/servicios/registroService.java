/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.servicios;


import com.edu.unipiloto.innovarq.dto.Usuario;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioRegistroMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author juanc
 */
@Path("/Usuario")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class registroService {

    @EJB
    private IServicioRegistroMockLocal ofertaEJB;

    @POST
    @Path("registrarUsuarios/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario registrarUsuarios(Usuario ofertas) {
        ofertaEJB.registrar(ofertas);
        return ofertas;
    }
    
//    @PUT
//    @Path("ActualizarUsuario/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Usuario ActualizarUsuario(Usuario ofertas) {
//        ofertaEJB.registrar(ofertas);
//        return ofertas;
//    }

    @GET
    @Path("obtenerUsuarios/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getTodasLasOfertas() {
        return ofertaEJB.darUsuarios();
    }
}

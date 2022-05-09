/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.ejb;

import com.edu.unipiloto.innovarq.dto.Usuario;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioPersistenciaMock;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioRegistroMockLocal;
import com.edu.unipiloto.innovarq.persistencia.ServicioPersistenciaMock;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author juanc
 */
@Stateless
public class ServicioRegistroMock implements IServicioRegistroMockLocal{
    
    private IServicioPersistenciaMock persistencia;

    public ServicioRegistroMock() {
        persistencia = new ServicioPersistenciaMock();
    }

    @Override
    public void registrar(Usuario u) {
        persistencia.create(u);
        }

    @Override
    public List<Usuario> darUsuarios() {
        return persistencia.findAll(Usuario.class);
    }
    
}

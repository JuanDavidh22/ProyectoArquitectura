/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.logica.interfaces;

import com.edu.unipiloto.innovarq.dto.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author juanc
 */
@Local
public interface IServicioRegistroMockLocal {
    
    public void registrar(Usuario u);
    
    public List<Usuario> darUsuarios();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.persistencia;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import com.edu.unipiloto.innovarq.dto.TipoUsuario;
import com.edu.unipiloto.innovarq.dto.Usuario;
import java.util.ArrayList;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioPersistenciaMock;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanc
 */
public class ServicioPersistenciaMock implements IServicioPersistenciaMock {

    private static ArrayList<Usuario> usuarios;

    private static ArrayList<Proyecto> proyectos;

    public ServicioPersistenciaMock() {

        usuarios = new ArrayList<Usuario>();    
        usuarios.add(new Usuario("juancho", "juancho123", TipoUsuario.Emprendedor, 1000000, "Juan David", "Herrera Hernandez", "juancho@mail.com", "3000000"));

        proyectos = new ArrayList<Proyecto>();
        proyectos.add(new Proyecto(1, "recoleccion de aguas", "2022/02/22", 20000, "Proyecto basado en la recoleccion de aguas en bogota"));
    }

    @Override
    public void create(Object obj) {
        if (obj instanceof Proyecto) {
            Proyecto m = (Proyecto) obj;
            m.setIdproyecto(proyectos.size() + 1);
            proyectos.add(m);
        } else if (obj instanceof Usuario) {
            Usuario m = (Usuario) obj;
            for (Usuario us : usuarios) {
                if (us.getLogin().equals(m.getLogin())) {
                    System.out.println("El usuario '" + m.getLogin() + "' ya ha sido registrado en el sistema");
                }
                if (us.getDocumento() == m.getDocumento()) {
                    System.out.println("El usuario con documento '" + m.getDocumento() + "' ya ha sido registrado en el sistema");
                }
            }
            usuarios.add(m);
        }
    }

    @Override
    public void update(Object obj) {
        if (obj instanceof Proyecto) {
            Proyecto editar = (Proyecto) obj;
            Proyecto proyecto;
            for (int i = 0; i < proyectos.size(); i++) {
                proyecto = proyectos.get(i);
                if (proyecto.getIdproyecto()==editar.getIdproyecto()) {
                    proyectos.set(i, editar);
                    break;
                }
            }
        } else if (obj instanceof Usuario) {

            Usuario editar = (Usuario) obj;
            Usuario usuario;
            for (int i = 0; i < usuarios.size(); i++) {
                usuario = usuarios.get(i);
                if (usuario.getLogin().equals(editar.getLogin())) {
                    usuarios.set(i, editar);
                    break;
                }
            }
        }
    }

    @Override
    public void delete(Object obj) {
    }

    @Override
    public List findAll(Class c) {
        if (c.equals(Usuario.class)) {
            return usuarios;
        } else if (c.equals(Proyecto.class)) {
            return proyectos;
        } else {
            return null;
        }
    }

    @Override
    public Object findById(Class c, Object id) {
        if (c.equals(Proyecto.class)) {
            for (Object v : findAll(c)) {
                Proyecto pro = (Proyecto) v;
                if (pro.getIdproyecto() == Long.parseLong(id.toString())) {
                    return pro;
                }
            }
        } else if (c.equals(Usuario.class)) {
            for (Object v : findAll(c)) {
                Usuario mue = (Usuario) v;
                if (mue.getLogin().equals(id)) {
                    return mue;
                }
            }
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.persistencia;

import com.edu.unipiloto.innovarq.dto.Proyecto;
import com.edu.unipiloto.innovarq.dto.Usuario;
import java.util.ArrayList;
import com.edu.unipiloto.innovarq.logica.interfaces.IServicioPersistenciaMock;
import java.util.List;

/**
 *
 * @author juanc
 */
public class ServicioPersistenciaMock implements IServicioPersistenciaMock {

    private static ArrayList<Usuario> usuarios;

    private static ArrayList<Proyecto> proyectos;

    public ServicioPersistenciaMock() {

//(String login, String contraseña, String tipoUsuario, long documento, String nombres, String apellidos, String email, String numeroTelefonico) {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("juancho", "juancho123", "Emprendedor", 1000000, "Juan David", "Herrera Hernandez", "juancho@mail.com", "30000032"));
        usuarios.add(new Usuario("julian", "julian123", "Emprendedor", 1000001, "Julian ", "Lopez", "julian@mail.com", "30000678"));
        usuarios.add(new Usuario("andres", "andres123", "Financiador", 1000002, "Andres David", "Guevara Hernandez", "andres@mail.com", "3000033"));
        usuarios.add(new Usuario("kevin", "kevin123", "Financiador", 1000003, "Kevin ", "Rico", "kevin@mail.com", "30000768"));
        proyectos = new ArrayList<Proyecto>();
//        long idproyecto, String responsable, String nombre, String fechaInicio, String fechaLimite, Integer cantidadRecaudar, Integer cantidadRecaudada, String descripcion, String estado, String tipoProyecto) {
        proyectos.add(new Proyecto(0, "juancho", "recoleccion de aguas", "2022/02/22", "2023/02/22", 20000, 100, "Proyecto basado en la recoleccion de aguas en bogota", "publicado", "Gobierno"));
    }

    @Override
    public void create(Object obj) {
        if (obj instanceof Proyecto) {
            boolean igual = true;
            Proyecto m = (Proyecto) obj;
            for (Proyecto pro : proyectos) {
                if (pro.getIdproyecto() == m.getIdproyecto() && pro.getResponsable().equals(m.getResponsable())) {
                    igual = true;
                    break;
                } else {
                    igual = false;
                }
            }
            if (igual == true) {
            } else {
                m.setIdproyecto(proyectos.size());
                proyectos.add(m);
            }

        } else if (obj instanceof Usuario) {
            Usuario m = (Usuario) obj;
            System.out.println(m.getLogin());
            for (Usuario us : usuarios) {
                if (us.getLogin().equals(m.getLogin())) {
                    System.out.println("El usuario '" + m.getLogin() + "' ya ha sido registrado en el sistema");
                } else {
                    usuarios.add(m);
                    break;
                }
            }
        }
    }

    @Override
    public void update(Object obj) {
        if (obj instanceof Proyecto) {
            Proyecto editar = (Proyecto) obj;
            Proyecto proyecto;
            for (int i = 0; i < proyectos.size(); i++) {
                proyecto = proyectos.get(i);
                if (proyecto.getIdproyecto() == editar.getIdproyecto()) {
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

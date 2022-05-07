/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.unipiloto.innovarq.logica.interfaces;

/**
 *
 * @author juanc
 */
public interface IServicioPersistenciaMock {
        /**
     * Crea un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere crear.
     */
    public void create(java.lang.Object obj);

    /**
     * Modifica un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere modificar.
     */
    public void update(java.lang.Object obj);

    /**
     * Elimina un objeto dentro de la persistencia del sistema.
     * @param obj Objeto que representa la instancia de la entidad que se quiere borrar.
     */
    public void delete(java.lang.Object obj);

    /**
     * Devuelve una lista con de todos los elementos de una clase dada que se encuentran en el sistema.
     * @param c Clase cuyos objetos quieren encontrarse en el sistema.
     * @return list Listado de todos los objetos de una clase.
     */
    public java.util.List findAll(java.lang.Class c);

    /**
     * Retorna la instancia de una entidad dado un identificador y la clase de la entidad.
     * @param c Clase de la instancia que se quiere buscar.
     * @param id Identificador unico del objeto.
     * @return obj Resultado de la consulta.
     */
    public java.lang.Object findById(java.lang.Class c, Object id);
}

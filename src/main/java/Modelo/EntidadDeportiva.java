/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class EntidadDeportiva {
    protected String nombre;
 
    public EntidadDeportiva(String nombre) {
        this.nombre = nombre;
    }
 
    public String getNombre()              { return nombre; }
    public void   setNombre(String nombre) { this.nombre = nombre; }
 
    /**
     * Retorna un String con la información de la entidad.
     * POLIMORFISMO: implementado de forma diferente en Equipo y Liga.
     */
    public abstract String obtenerInfo();
 
    @Override
    public String toString() { return obtenerInfo(); }
}

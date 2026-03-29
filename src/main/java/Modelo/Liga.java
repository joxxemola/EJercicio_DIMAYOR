/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Liga extends EntidadDeportiva {
 
    private Equipo[] equipos;
    private int total;
    private int capacidad;
 
    // ── Constructor ───────────────────────────────────────────────────────────
 
    public Liga(String nombre, int capacidad) {
        super(nombre);
        this.capacidad = capacidad;
        this.equipos   = new Equipo[capacidad];
        this.total     = 0;
    }
 
    // ── Gestión de equipos ────────────────────────────────────────────────────
 
    /**
     * Agrega un equipo a la liga.
     *
     * @return true si se agregó, false si la liga está llena
     */
    public boolean agregarEquipo(Equipo e) {
        if (total >= capacidad) return false;
        equipos[total++] = e;
        return true;
    }
 
    public int getTotal()     { return total; }
    public int getCapacidad() { return capacidad; }
 
    /**
     * Retorna una copia defensiva del arreglo de equipos inscritos.
     * El Controller y la Vista trabajan sobre esta copia, nunca
     * sobre el arreglo interno.
     */
    public Equipo[] getEquipos() {
        Equipo[] copia = new Equipo[total];
        System.arraycopy(equipos, 0, copia, 0, total);
        return copia;
    }
 
    // ── Búsquedas (SOBRECARGA) ────────────────────────────────────────────────
 
    /**
     * Busca un equipo por su nombre (insensible a mayúsculas).
     * SOBRECARGA: versión con String.
     *
     * @return el Equipo encontrado o null
     */
    public Equipo buscar(String nombre) {
        for (int i = 0; i < total; i++) {
            if (equipos[i].getNombre().equalsIgnoreCase(nombre))
                return equipos[i];
        }
        return null;
    }
 
    /**
     * Busca un equipo por su posición en el arreglo (base 0).
     * SOBRECARGA del método buscar().
     *
     * @return el Equipo en esa posición o null si el índice es inválido
     */
    public Equipo buscar(int posicion) {
        if (posicion < 0 || posicion >= total) return null;
        return equipos[posicion];
    }
 
    // ── Lógica de liga ────────────────────────────────────────────────────────
 
    /**
     * Calcula el mayor puntaje entre todos los equipos.
     *
     * @return el puntaje máximo, o 0 si no hay equipos
     */
    public int mayorPuntaje() {
        if (total == 0) return 0;
        int max = equipos[0].getPuntos();
        for (int i = 1; i < total; i++) {
            if (equipos[i].getPuntos() > max)
                max = equipos[i].getPuntos();
        }
        return max;
    }
 
    /**
     * Retorna un arreglo con los equipos que tienen el mayor puntaje.
     * El Controller lo pasa a la Vista para mostrar.
     */
    public Equipo[] obtenerLideres() {
        int max    = mayorPuntaje();
        int conteo = 0;
        for (int i = 0; i < total; i++)
            if (equipos[i].getPuntos() == max) conteo++;
 
        Equipo[] lideres = new Equipo[conteo];
        int idx = 0;
        for (int i = 0; i < total; i++)
            if (equipos[i].getPuntos() == max)
                lideres[idx++] = equipos[i];
        return lideres;
    }
 
    // ── POLIMORFISMO ──────────────────────────────────────────────────────────
 
    /**
     * Retorna un resumen textual de la liga.
     * POLIMORFISMO: versión específica de Liga.
     */
    @Override
    public String obtenerInfo() {
        return String.format(
            "Liga: %-40s | Equipos: %2d / %2d",
            nombre, total, capacidad
        );
    }
}

package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Usuario
 */
import Modelo.Equipo;
import Modelo.Liga;
import Vista.Vista;

public class ControladorLiga {
 
    private final Liga  liga;
    private final Vista vista;
 
    public ControladorLiga(Liga liga, Vista vista) {
        this.liga  = liga;
        this.vista = vista;
    }
 
    // ── Requisito 1: listar todos los equipos ─────────────────────────────────
 
    /**
     * Obtiene todos los equipos del modelo y se los pasa a la vista.
     */
    public void listarEquipos() {
        Equipo[] equipos = liga.getEquipos();
        if (equipos.length == 0) {
            vista.mostrarAdvertencia("No hay equipos inscritos en la liga.");
            return;
        }
        vista.mostrarListado(equipos, liga.getNombre());
    }
 
    // ── Requisito 2: mayor puntaje ────────────────────────────────────────────
 
    /**
     * Consulta al modelo el mayor puntaje y lo envía a la vista.
     */
    public void mostrarMayorPuntaje() {
        if (liga.getTotal() == 0) {
            vista.mostrarAdvertencia("No hay equipos para calcular el puntaje.");
            return;
        }
        int max = liga.mayorPuntaje();         // MODEL calcula
        vista.mostrarMayorPuntaje(max);        // VIEW presenta
    }
 
    // ── Requisito 3: buscar equipo por nombre ─────────────────────────────────
 
    /**
     * Busca un equipo por nombre en el modelo y pasa el resultado a la vista.
     * Usa la SOBRECARGA buscar(String) de Liga.
     *
     * @param nombre nombre del equipo a buscar
     */
    public void buscarPorNombre(String nombre) {
        Equipo encontrado = liga.buscar(nombre);   // MODEL busca (sobrecarga String)
        vista.mostrarDetalleEquipo(encontrado, nombre);  // VIEW muestra
    }
 
    /**
     * Busca un equipo por posición en el arreglo (base 0).
     * Usa la SOBRECARGA buscar(int) de Liga.
     *
     * @param posicion índice del equipo en el arreglo
     */
    public void buscarPorPosicion(int posicion) {
        Equipo encontrado = liga.buscar(posicion);         // MODEL busca (sobrecarga int)
        String etiqueta   = "posición " + posicion;
        vista.mostrarDetalleEquipo(encontrado, etiqueta);  // VIEW muestra
    }
 
    // ── Requisito 4: equipos con mayor puntaje ────────────────────────────────
 
    /**
     * Obtiene del modelo los equipos líderes y se los pasa a la vista.
     */
    public void mostrarLideres() {
        if (liga.getTotal() == 0) {
            vista.mostrarAdvertencia("No hay equipos inscritos.");
            return;
        }
        int      maxPts = liga.mayorPuntaje();       // MODEL calcula el máximo
        Equipo[] lideres = liga.obtenerLideres();    // MODEL filtra los líderes
        vista.mostrarLideres(lideres, maxPts);       // VIEW presenta
    }
 
    // ── Gestión de equipos ────────────────────────────────────────────────────
 
    /**
     * Registra un nuevo equipo en la liga.
     *
     * @param equipo instancia de Equipo ya construida
     */
    public void registrarEquipo(Equipo equipo) {
        boolean ok = liga.agregarEquipo(equipo);
        if (!ok) {
            vista.mostrarError("Liga llena. No se pudo inscribir: "
                               + equipo.getNombre());
        }
    }
 
    /**
     * Muestra la información general de la liga (POLIMORFISMO: llama a
     * obtenerInfo() de Liga, que sobreescribe la de EntidadDeportiva).
     */
    public void mostrarInfoLiga() {
        vista.mostrarInfoLiga(liga);
    }
}
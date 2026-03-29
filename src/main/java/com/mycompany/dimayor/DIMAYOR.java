/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dimayor;

/**
 *
 * @author Usuario
 */
import Controlador.ControladorLiga;
import Modelo.Equipo;
import Modelo.Liga;
import Vista.Vista;

/**
 * ══════════════════════════════════════════════════════════════
 *  PUNTO DE ENTRADA
 *
 *  Única responsabilidad: instanciar las tres capas y conectarlas.
 *
 *  MODELO      → Liga  (datos + lógica de negocio)
 *  VISTA       → Vista (todo System.out)
 *  CONTROLADOR → ControladorLiga (orquesta Model ↔ View)
 *
 *  Conceptos del enunciado:
 *  ─ HERENCIA     : EntidadDeportiva ← Equipo
 *                   EntidadDeportiva ← Liga
 *  ─ POLIMORFISMO : obtenerInfo() se comporta distinto en
 *                   Equipo y en Liga.
 *  ─ SOBRECARGA   : Equipo → 2 constructores,
 *                             2 versiones de registrarPartido()
 *                   Liga   → 2 versiones de buscar()
 * ══════════════════════════════════════════════════════════════
 */
public class DIMAYOR {
 
    public static void main(String[] args) {
 
        // ── 1. Construir el MODEL ──────────────────────────────────────────────
        Liga liga = new Liga("Liga BetPlay Dimayor 2025-I", 20);
 
        // ── 2. Construir la VIEW ──────────────────────────────────────────────
        Vista vista = new Vista();
 
        // ── 3. Construir el CONTROLLER y conectarlos ──────────────────────────
        ControladorLiga ctrl = new ControladorLiga(liga, vista);
 
        // ── 4. Cargar equipos vía Controller ─────────────────────────────────
        ctrl.registrarEquipo(new Equipo("Atlético Nacional",        10, 4, 3));
        ctrl.registrarEquipo(new Equipo("Millonarios FC",           10, 3, 4));
        ctrl.registrarEquipo(new Equipo("Deportivo Cali",            8, 5, 4));
        ctrl.registrarEquipo(new Equipo("Junior FC",                 9, 2, 6));
        ctrl.registrarEquipo(new Equipo("América de Cali",           7, 6, 4));
        ctrl.registrarEquipo(new Equipo("Santa Fe",                  7, 5, 5));
        ctrl.registrarEquipo(new Equipo("Deportes Tolima",           8, 3, 6));
        ctrl.registrarEquipo(new Equipo("Once Caldas",               6, 6, 5));
        ctrl.registrarEquipo(new Equipo("Independiente Medellín",    6, 4, 7));
        ctrl.registrarEquipo(new Equipo("Envigado FC",               5, 7, 5));
        ctrl.registrarEquipo(new Equipo("Águilas Doradas",           5, 5, 7));
        ctrl.registrarEquipo(new Equipo("Alianza FC",                4, 6, 7));
        ctrl.registrarEquipo(new Equipo("Boyacá Chicó",              4, 5, 8));
        ctrl.registrarEquipo(new Equipo("Patriotas Boyacá",          3, 7, 7));
        ctrl.registrarEquipo(new Equipo("Cortuluá",                  3, 5, 9));
        ctrl.registrarEquipo(new Equipo("Jaguares de Córdoba",       2, 6, 9));
 
        // SOBRECARGA constructor Equipo(String) + registrarPartido(String)
        Equipo pereira = new Equipo("Deportivo Pereira");
        pereira.registrarPartido("G");
        pereira.registrarPartido("G");
        pereira.registrarPartido("E");
        pereira.registrarPartido("P");
        ctrl.registrarEquipo(pereira);
 
        // SOBRECARGA registrarPartido(int, int)
        Equipo buca = new Equipo("Atlético Bucaramanga");
        buca.registrarPartido(2, 0);
        buca.registrarPartido(1, 1);
        buca.registrarPartido(0, 3);
        buca.registrarPartido(2, 1);
        ctrl.registrarEquipo(buca);
 
        // ── REQUISITO 1 ───────────────────────────────────────────────────────
        ctrl.listarEquipos();
 
        // ── REQUISITO 2 ───────────────────────────────────────────────────────
        ctrl.mostrarMayorPuntaje();
 
        // ── REQUISITO 3: buscar por nombre (SOBRECARGA buscar(String)) ────────
        ctrl.buscarPorNombre("América de Cali");
        ctrl.buscarPorNombre("Real Madrid");          // equipo inexistente
 
        // SOBRECARGA buscar(int): buscar por posición
        ctrl.buscarPorPosicion(0);
 
        // ── REQUISITO 4 ───────────────────────────────────────────────────────
        ctrl.mostrarLideres();
 
        // ── Info general (POLIMORFISMO: obtenerInfo() de Liga) ────────────────
        ctrl.mostrarInfoLiga();
    }
}
 
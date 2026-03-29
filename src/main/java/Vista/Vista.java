/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author Usuario
 */

import Modelo.Equipo;
import Modelo.Liga;

/**
 * CAPA: VIEW
 * Toda la interaccion con el usuario (System.out / System.in)
 * reside aqui. No contiene logica de negocio.
 * El Controller le pasa los datos ya calculados.
 */
public class Vista {

    // Separadores de seccion

    public void mostrarTitulo(String titulo) {
        String linea = "=".repeat(74);
        System.out.println("\n" + linea);
        System.out.println("  " + titulo);
        System.out.println(linea);
    }

    public void mostrarSeparador() {
        System.out.println("-".repeat(74));
    }

    // Requisito 1: listado completo

    public void mostrarListado(Equipo[] equipos, String nombreLiga) {
        mostrarTitulo("DIMAYOR - " + nombreLiga + " - Tabla de posiciones");

        System.out.printf("  %-4s %-28s %4s %4s %4s %4s %7s%n",
                          "#", "Equipo", "PG", "PE", "PP", "PJ", "Puntos");
        mostrarSeparador();

        for (int i = 0; i < equipos.length; i++) {
            Equipo e = equipos[i];
            System.out.printf("  %-4d %-28s %4d %4d %4d %4d %7d%n",
                i + 1,
                e.getNombre(),
                e.getPg(),
                e.getPe(),
                e.getPp(),
                e.getPj(),
                e.getPuntos());
        }
        mostrarSeparador();
        System.out.printf("  Total de equipos: %d%n", equipos.length);
    }

    // Requisito 2: mayor puntaje

    public void mostrarMayorPuntaje(int puntaje) {
        mostrarTitulo("Mayor puntaje alcanzado");
        System.out.printf("  [*] %d puntos%n", puntaje);
    }

    // Requisito 3: detalle de un equipo

    public void mostrarDetalleEquipo(Equipo equipo, String busqueda) {
        mostrarTitulo("Busqueda: \"" + busqueda + "\"");

        if (equipo == null) {
            System.out.println("  [!] Equipo no encontrado.");
            return;
        }

        String sep = "  +" + "-".repeat(46) + "+";
        System.out.println(sep);
        System.out.printf("  | %-18s : %-26s|%n", "Equipo",       equipo.getNombre());
        System.out.printf("  | %-18s : %-26d|%n", "P. Ganados",   equipo.getPg());
        System.out.printf("  | %-18s : %-26d|%n", "P. Empatados", equipo.getPe());
        System.out.printf("  | %-18s : %-26d|%n", "P. Perdidos",  equipo.getPp());
        System.out.printf("  | %-18s : %-26d|%n", "P. Jugados",   equipo.getPj());
        System.out.printf("  | %-18s : %-26d|%n", "Puntos",       equipo.getPuntos());
        System.out.println(sep);
    }

    // Requisito 4: equipos lideres

    public void mostrarLideres(Equipo[] lideres, int maxPuntos) {
        mostrarTitulo("Equipos con el mayor puntaje (" + maxPuntos + " pts)");

        for (Equipo e : lideres) {
            System.out.printf("  -> %-30s %3d pts  (PG:%2d  PE:%2d  PP:%2d)%n",
                e.getNombre(), e.getPuntos(),
                e.getPg(), e.getPe(), e.getPp());
        }

        mostrarSeparador();
        System.out.printf("  Total de equipos lideres: %d%n", lideres.length);
    }

    // Mensajes de error / advertencia

    public void mostrarError(String mensaje) {
        System.out.println("  [ERROR] " + mensaje);
    }

    public void mostrarAdvertencia(String mensaje) {
        System.out.println("  [AVISO] " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("  " + mensaje);
    }

    // Info general de la liga

    public void mostrarInfoLiga(Liga liga) {
        System.out.println("\n  " + liga.obtenerInfo());
    }
}
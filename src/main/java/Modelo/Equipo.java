/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */

    
public class Equipo extends EntidadDeportiva {
 
    private int pg;   // Partidos ganados
    private int pe;   // Partidos empatados
    private int pp;   // Partidos perdidos
 
    // ── Constructores (SOBRECARGA) ────────────────────────────────────────────
 
    /** Constructor completo: nombre + estadísticas de temporada. */
    public Equipo(String nombre, int pg, int pe, int pp) {
        super(nombre);
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
    }
 
    /**
     * Constructor reducido: solo nombre, estadísticas en cero.
     * SOBRECARGA del constructor.
     */
    public Equipo(String nombre) {
        this(nombre, 0, 0, 0);
    }
 
    // ── Getters / Setters ─────────────────────────────────────────────────────
 
    public int getPg() { return pg; }
    public int getPe() { return pe; }
    public int getPp() { return pp; }
 
    public void setPg(int pg) { this.pg = pg; }
    public void setPe(int pe) { this.pe = pe; }
    public void setPp(int pp) { this.pp = pp; }
 
    /** Partidos jugados = pg + pe + pp (calculado). */
    public int getPj() { return pg + pe + pp; }
 
    /** Puntos acumulados: 3 por victoria, 1 por empate. */
    public int getPuntos() { return pg * 3 + pe; }
 
    // ── Métodos registrarPartido (SOBRECARGA) ─────────────────────────────────
 
    /**
     * Registra un partido por marcador.
     * SOBRECARGA: versión con goles.
     *
     * @param golesPropios goles anotados por este equipo
     * @param golesRival   goles anotados por el rival
     */
    public void registrarPartido(int golesPropios, int golesRival) {
        if      (golesPropios > golesRival)  pg++;
        else if (golesPropios == golesRival) pe++;
        else                                  pp++;
    }
 
    /**
     * Registra un partido por resultado textual: "G", "E" o "P".
     * SOBRECARGA del método registrarPartido.
     *
     * @param resultado "G" (ganado) | "E" (empatado) | "P" (perdido)
     * @throws IllegalArgumentException si el resultado no es válido
     */
    public void registrarPartido(String resultado) {
        switch (resultado.toUpperCase()) {
            case "G" -> pg++;
            case "E" -> pe++;
            case "P" -> pp++;
            default  -> throw new IllegalArgumentException(
                            "Resultado inválido: '" + resultado +
                            "'. Use G, E o P.");
        }
    }
 
    // ── POLIMORFISMO ──────────────────────────────────────────────────────────
 
    /**
     * Retorna una línea de tabla formateada con todas las estadísticas.
     * POLIMORFISMO: versión específica de Equipo.
     */
    @Override
    public String obtenerInfo() {
        return String.format(
            "%-28s | PG: %2d | PE: %2d | PP: %2d | PJ: %2d | Puntos: %3d",
            nombre, pg, pe, pp, getPj(), getPuntos()
        );
    }
    
}

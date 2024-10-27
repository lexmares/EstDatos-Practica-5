package principal;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;
import adicional.*;
public class Compromisos implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Coordenadas ubicacionProgramada;
    private String actividadesaDesarrollar;
    private String encargadoDeAtencion;
    private long telefono;

    public Compromisos(LocalDate fechaInicio, LocalDate fechaFin, Coordenadas ubicacionProgramada, String actividadesaDesarrollar, String encargadoDeAtencion, long telefono) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacionProgramada = ubicacionProgramada;
        this.actividadesaDesarrollar = actividadesaDesarrollar;
        this.encargadoDeAtencion = encargadoDeAtencion;
        this.telefono = telefono;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Coordenadas getUbicacionProgramada() {
        return ubicacionProgramada;
    }

    public void setUbicacionProgramada(Coordenadas ubicacionProgramada) {
        this.ubicacionProgramada = ubicacionProgramada;
    }

    public String getActividadesaDesarrollar() {
        return actividadesaDesarrollar;
    }

    public void setActividadesaDesarrollar(String actividadesaDesarrollar) {
        this.actividadesaDesarrollar = actividadesaDesarrollar;
    }

    public String getEncargadoDeAtencion() {
        return encargadoDeAtencion;
    }

    public void setEncargadoDeAtencion(String encargadoDeAtencion) {
        this.encargadoDeAtencion = encargadoDeAtencion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}

package principal;

import java.io.Serializable;

import adicional.Coordenadas;
import ed.ito.*;
public class Expertos implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String especialidad;
    private String areasDeInteres;
    private Coordenadas ubicacionFija;
    private long telefono;
    private String contacto;

    ListaDinamica<Compromisos> agendaEventos = new ListaDinamica< >();
    public Expertos(String nombre, String especialidad, String areasDeInteres, Coordenadas ubicacionFija, long telefono, String contacto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.areasDeInteres = areasDeInteres;
        this.ubicacionFija = ubicacionFija;
        this.telefono = telefono;
        this.contacto = contacto;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAreasDeInteres() {
        return areasDeInteres;
    }

    public void setAreasDeInteres(String areasDeInteres) {
        this.areasDeInteres = areasDeInteres;
    }

    public Coordenadas getUbicacionFija() {
        return ubicacionFija;
    }

    public void setUbicacionFija(Coordenadas ubicacionFija) {
        this.ubicacionFija = ubicacionFija;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


}

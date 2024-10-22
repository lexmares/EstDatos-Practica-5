import java.util.ArrayList;

public class Expertos{
    private String nombre;
    private String especialidad;
    private String areasDeInteres;
    private String ubicacionFija;
    private int telefono;
    private String contacto;

    ArrayList<Agenda> agendaEventos = new ArrayList<>();
    public Expertos(String nombre, String especialidad, String areasDeInteres, String ubicacionFija, int telefono, String contacto) {
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

    public String getUbicacionFija() {
        return ubicacionFija;
    }

    public void setUbicacionFija(String ubicacionFija) {
        this.ubicacionFija = ubicacionFija;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


}

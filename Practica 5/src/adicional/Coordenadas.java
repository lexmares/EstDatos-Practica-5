package adicional;

import java.io.Serializable;

public class Coordenadas implements Serializable{
    double latitud;
    double longitud;
    //Son coordenadas en grados decimales
    public Coordenadas(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String ubicacionToString(){
        return latitud + (latitud > 0? " N" : " S") + ", " + longitud + (longitud > 0? " E" : " O");
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}

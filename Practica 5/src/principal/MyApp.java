package principal;

import adicional.SistemaGuardadoCargado;
import ed.ito.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyApp implements Serializable {

    ListaDinamica<Expertos> expertosAmbientales = new ListaDinamica<>();
    public void registrarExperto(Expertos nuevo){
        try{
            expertosAmbientales.add(nuevo);
            System.out.println("Experto registrado. Total de expertos: " + expertosAmbientales.size());
        }catch(ExcepcionDeListaLlena e){
            System.out.println("Error: no se pueden agregar mas elementos porque ha sobrepasado el limite");
        }

    }

    public ListaDinamica<Expertos> getExpertosAmbientales() {
        return expertosAmbientales;
    }

    public void setExpertosAmbientales(ListaDinamica<Expertos> expertosAmbientales) {
        this.expertosAmbientales = expertosAmbientales;
    }

    public void modificarRegistro(Expertos remplazo, int expertoBuscado){
        try{
            expertosAmbientales.getItem(expertoBuscado).setNombre(!remplazo.getNombre().equals("/") ? remplazo.getNombre() : expertosAmbientales.getItem(expertoBuscado).getNombre());
            expertosAmbientales.getItem(expertoBuscado).setEspecialidad(!remplazo.getEspecialidad().equals("/") ? remplazo.getEspecialidad() : expertosAmbientales.getItem(expertoBuscado).getEspecialidad());
            expertosAmbientales.getItem(expertoBuscado).setAreasDeInteres(!remplazo.getAreasDeInteres().equals("/") ? remplazo.getAreasDeInteres() : expertosAmbientales.getItem(expertoBuscado).getAreasDeInteres());
            expertosAmbientales.getItem(expertoBuscado).setUbicacionFija(remplazo.getUbicacionFija().getLatitud() != -1000 && remplazo.getUbicacionFija().getLongitud() != -1000 ? remplazo.getUbicacionFija() : expertosAmbientales.getItem(expertoBuscado).getUbicacionFija());
            expertosAmbientales.getItem(expertoBuscado).setTelefono(remplazo.getTelefono() != -1 ? remplazo.getTelefono() : expertosAmbientales.getItem(expertoBuscado).getTelefono());
            expertosAmbientales.getItem(expertoBuscado).setContacto(!remplazo.getContacto().equals("/") ? remplazo.getContacto() : expertosAmbientales.getItem(expertoBuscado).getContacto());

        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: no hay expertos registrados");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: no se encontró el registro buscado");
        }catch (NullPointerException e){
            System.out.println("Error al ubicar elemento");
        }

    }

    public void eliminarRegistro(int expertoSeleccionado){
        try{
            expertosAmbientales.delete(expertoSeleccionado);

        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: no hay expertos registrados");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: no se encontró el registro buscado");
        }catch (NullPointerException e){
            System.out.println("Error al ubicar elemento");
        }

    }

    public String listarRegistros(){
        String listaDeExpertos = "----------------------------------------------------------------------------------------------------------------------------------------------------------\n";


        try{
            if (expertosAmbientales.size() == 0) {
                return "No hay expertos registrados.";
            }
            else{

                //listaDeExpertos = listarRegistrosRecursivo(0);
                for (int i = 0; i < expertosAmbientales.size(); i++){
                    listaDeExpertos += (i + 1) + ". " + expertosAmbientales.getItem(i).getNombre() + " --> " + expertosAmbientales.getItem(i).getEspecialidad() + "\t*Area de interes: "+ expertosAmbientales.getItem(i).getAreasDeInteres() + "\n" +
                            "Ubicacion: "+ expertosAmbientales.getItem(i).getUbicacionFija().ubicacionToString() + " || Telefono: " + expertosAmbientales.getItem(i).getTelefono() + " || Contacto: " + expertosAmbientales.getItem(i).getContacto() + "\n" +
                            "----------------------------------------------------------------------------------------------------------------------------------------------------------\n" ;
                }
            }

        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: la lista esta vacia");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: un elemento de la lista no existe");
        }

        return listaDeExpertos;

    }

    public String listarRegistrosRecursivo(int i) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado{
        if(i == expertosAmbientales.size()) return "";
        return (i + 1) + ". " + expertosAmbientales.getItem(i).getNombre() + " --> " + expertosAmbientales.getItem(i).getEspecialidad() + "\t*Area de interes: "+ expertosAmbientales.getItem(i).getAreasDeInteres() + "\n" +
                "Ubicacion: "+ expertosAmbientales.getItem(i).getUbicacionFija().ubicacionToString() + " || Telefono: " + expertosAmbientales.getItem(i).getTelefono() + " || Contacto: " + expertosAmbientales.getItem(i).getContacto() + "\n" +
                "----------------------------------------------------------------------------------------------------------------------------------------------------------" +
                "\n" + listarRegistrosRecursivo(i+1);

    }



    public void agregarCompromiso(Compromisos evento, int expertoSeleccionado){

        boolean agendaExpertoLibre = true;
        try {
            for (int j = 0; j < expertosAmbientales.size(); j++) {
                for (int i = 0; i < expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.size(); i++) {
                    //if ((!evento.getFechaInicio().isAfter(expertosAmbientales.getItem(j).agendaEventos.getItem(i).getFechaFin()) || !evento.getFechaFin().isBefore(expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getFechaInicio())) && !expertosAmbientales.getItem(j).agendaEventos.getItem(i).getUbicacionProgramada().equals(evento.getUbicacionProgramada())) {
                    if (!(evento.getFechaFin().isBefore(expertosAmbientales.getItem(j).agendaEventos.getItem(i).getFechaInicio()) || evento.getFechaInicio().isAfter(expertosAmbientales.getItem(j).agendaEventos.getItem(i).getFechaFin()))  && (expertosAmbientales.getItem(j).agendaEventos.getItem(i).getUbicacionProgramada().ubicacionToString().equals(evento.getUbicacionProgramada().ubicacionToString())   )) {

                        agendaExpertoLibre = false;
                        break;
                    }
                }
                if(!agendaExpertoLibre) break;
            }

            if(agendaExpertoLibre){
                expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.add(evento);
                System.out.println("Evento registrado. Total de compromisos: " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.size());
            }
            else{
                System.out.println("No se puede agregar el compromiso. Hay choque de fechas");
            }

        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: la lista esta vacia");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: un elemento de la lista no existe");
        }catch (ExcepcionDeListaLlena e){
            System.out.println("Error: ha  llegado al limite de eventos posibles");
        }catch (NullPointerException e){
            System.out.println("Error al ubicar elemento");
        }

    }

    public void modificarCompromiso(Compromisos eventoModificado, int expertoSeleccionado, int eventoSeleccionado){
        try{
            expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).setEncargadoDeAtencion(!eventoModificado.getEncargadoDeAtencion().equals("/")?  eventoModificado.getEncargadoDeAtencion() : expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).getEncargadoDeAtencion());
            expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).setTelefono(eventoModificado.getTelefono() != -1? eventoModificado.getTelefono() : expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).getTelefono());
            expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).setActividadesaDesarrollar( !eventoModificado.getActividadesaDesarrollar().equals("/")?  eventoModificado.getActividadesaDesarrollar() : expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(eventoSeleccionado).getActividadesaDesarrollar());
        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: la lista esta vacia");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: un elemento de la lista no existe");
        }
    }

    public void eliminarCompromiso(int expertoSeleccionado, int eventoSeleccionado){
        try{
            expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.delete(eventoSeleccionado);
        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: la lista esta vacia");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: un elemento de la lista no existe");
        }
        catch (NullPointerException e){
            System.out.println("Error al ubicar elemento");
        }
    }

    public String mostrarAgendaEventos(int expertoSeleccionado){
        String agenda = "----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
        try{
            for (int i = 0; i < expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.size(); i++){
                agenda += (i + 1) + ". " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getFechaInicio() + " -- " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getFechaFin() + "\n" +
                        "Actividades: " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getActividadesaDesarrollar() + "\n" +
                        "Ubicacion: " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getUbicacionProgramada().ubicacionToString() + "\n" +
                        "Encargado: " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getEncargadoDeAtencion() + "\tTelefono: " + expertosAmbientales.getItem(expertoSeleccionado).agendaEventos.getItem(i).getTelefono() + "\n" +
                        "----------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
        }catch(ExcepcionDeListaVacia e){
            System.out.println("Error: la lista esta vacia");
        }catch (ExcepcionDeElementoNoEncontrado e){
            System.out.println("Error: un elemento de la lista no existe");
        }catch (NullPointerException e){
            System.out.println("Error al ubicar elemento");
        }

        return agenda;
    }


    public void save(){
        SistemaGuardadoCargado save = new SistemaGuardadoCargado();
        try{
            save.guardarLista(expertosAmbientales);
            System.out.println("Datos guardados");
        }catch (IOException e){
            System.out.println("Error al guardar datos" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void load(){
        SistemaGuardadoCargado load = new SistemaGuardadoCargado();
        try{
            expertosAmbientales = load.cargarLista();
            System.out.println("Datos cargados");
        }catch (IOException | ClassNotFoundException  e){
            System.out.println("Error al cargar los datos");
            //e.printStackTrace();
        }
    }




}

package principal;

import adicional.Coordenadas;
import adicional.SistemaGuardadoCargado;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static final long serialVersionUID = 1L;
    static void cargarListaExpertos(MyApp app){
        System.out.println("Lista de expertos: ");
        System.out.println(app.listarRegistros());
    }
    static void cargarAgenda(MyApp app){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Introduzca el numero de experto para ver su agenda: "); int opcion = sc.nextInt();
            System.out.println(app.mostrarAgendaEventos(opcion - 1));
        }catch(NumberFormatException e){
            System.out.println("No se pudo cargar la agenda. Coloque un numero valido.");
        }

    }

    public static void main(String[] args) {
        MyApp app = new MyApp();

        menu(app);

    }

    public static void agregarRegistro(MyApp app){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agregar un registro nuevo. Ingrese los datos del experto:");
        double latitud = 0, longitud = 0;
        long telefono = 0;


        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Especialidad: "); String especialidad = sc.nextLine();
        System.out.print("Areas de interes: "); String areasDeInteres = sc.nextLine();
        try{
            System.out.print("Ubicacion \n" +
                    "latitud: "); latitud = sc.nextDouble();
        }catch(NumberFormatException e){
            latitud = 0;
        }
        try{
            System.out.print("longitud: ");  longitud = sc.nextDouble();
        }catch(NumberFormatException e){
            longitud = 0;
        }
        try{
            System.out.print("Telefono: ");  telefono = sc.nextLong();
        }catch(NumberFormatException e){
            telefono = 0;
        }
        sc.nextLine();
        System.out.print("Contacto: "); String contacto = sc.nextLine();

        app.registrarExperto(new Expertos(nombre, especialidad, areasDeInteres, new Coordenadas(latitud, longitud),telefono, contacto));
    }


    public static void modificarRegistro(MyApp app){
        Scanner sc = new Scanner(System.in);
        System.out.print("Coloque el numero del experto que desea modificar: "); int expertoSeleccionado = sc.nextInt();

        System.out.println("Ingrese los datos a modificar. Si hay datos que no quiere modificar introduzca solo el caracter '/'.");
        double latitud = 0, longitud = 0;
        long telefono = 0;

        sc.nextLine();
        System.out.print("Nombre: "); String nombre = sc.nextLine();
        System.out.print("Especialidad: "); String especialidad = sc.nextLine();
        System.out.print("Areas de interes: "); String areasDeInteres = sc.nextLine();
        try{
            System.out.print("Ubicacion \n" +
                    "latitud: "); latitud = sc.nextDouble();
        }catch(NumberFormatException | InputMismatchException e){
            latitud = -1000;
        }
        try{
            System.out.print("longitud: ");  longitud = sc.nextDouble();
        }catch(NumberFormatException | InputMismatchException e){
            longitud = -1000;
        }
        try{
            System.out.print("Telefono: ");  telefono = sc.nextLong();
        }catch(NumberFormatException | InputMismatchException e){
            telefono = -1;
        }
        sc.nextLine();
        System.out.print("Contacto: "); String contacto = sc.nextLine();

        app.modificarRegistro(new Expertos(nombre, especialidad, areasDeInteres, new Coordenadas(latitud, longitud),telefono, contacto), expertoSeleccionado - 1);
    }

    public static void eliminarRegistro(MyApp app){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Introduzca el numero de registro que desea eliminar: "); int expertoEliminar = sc.nextInt();
            app.eliminarRegistro(expertoEliminar - 1);
        }catch (NumberFormatException e){
            System.out.println("Introduzca un numero valido.");
        }

    }

    public static void agregarCompromiso (MyApp app){
        Scanner sc = new Scanner(System.in);
        int experto = 0;
        int anio = 0, mes = 0, dia = 0;
        LocalDate fechaInicio, fechaFin;
        double latitud, longitud;
        Coordenadas ubicacionProgramada;
        String actividades;
        String encargadoDeAtencion;
        long telefono;
        try{
            System.out.println("Introduzca el numero de registro al cual agregar el compromiso: "); experto = sc.nextInt();
            System.out.println("Introduzca los datos del evento: \n");

            System.out.print("Fecha de inicio: \n" +
                    "Año: "); anio = sc.nextInt();
            System.out.print("Mes: "); mes = sc.nextInt();
            System.out.print("Dia: "); dia = sc.nextInt();
            fechaInicio = LocalDate.of(anio, mes, dia);

            System.out.print("Fecha de Fin: \n" +
                    "Año: "); anio = sc.nextInt();
            System.out.print("Mes: "); mes = sc.nextInt();
            System.out.print("Dia: "); dia = sc.nextInt();
            fechaFin = LocalDate.of(anio, mes, dia);

            System.out.print("Ubicacion del evento (coordenadas): \n" +
                    "Latitud: "); latitud = sc.nextDouble();
            System.out.print("Longitud: "); longitud = sc.nextDouble();
            ubicacionProgramada = new Coordenadas(latitud, longitud);
            sc.nextLine();

            System.out.println("Actividades a realizar: ");
            actividades = sc.nextLine();
            System.out.print("Encargado de la atencion:"); encargadoDeAtencion = sc.nextLine();
            System.out.print("Telefono: "); telefono = sc.nextLong();


            app.agregarCompromiso(new Compromisos(fechaInicio, fechaFin, ubicacionProgramada, actividades, encargadoDeAtencion, telefono), experto - 1);

        }catch (NumberFormatException e){
            System.out.println("Error al agregar un evento.");
        }


    }

    public static void modificarCompromiso(MyApp app){
        Scanner sc = new Scanner(System.in);
       try {
           System.out.print("Introduzca el numero de registro: "); int experto = sc.nextInt();
           System.out.print("Introduzca el numero de evento a modificar: "); int compromiso = sc.nextInt();
            sc.nextLine();
           System.out.println("Modifique la informacion del compromiso. Si hay datos que no quiere modificar introduzca solo el caracter '/'.");
           System.out.println("Actividades a realizar: ");
           String actividades = sc.nextLine();
           System.out.print("Encargado de la atencion: ");
           String encargadoDeAtencion = sc.nextLine();
           long telefono;

           try{
               System.out.print("Telefono: ");
               telefono = sc.nextLong();
           }catch (NumberFormatException | NullPointerException | InputMismatchException e){
               telefono = -1;
           }


           app.modificarCompromiso(new Compromisos(null, null, null, actividades, encargadoDeAtencion, telefono), experto - 1, compromiso - 1);

       }catch (NumberFormatException e){
           System.out.println("Error al modificar compromiso.");

       }
    }
    public static void elimnarCompromiso(MyApp app){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Introduzca el numero de registro: "); int experto = sc.nextInt();
            System.out.print("Introduzca el numero de evento a eliminar: "); int compromiso = sc.nextInt();

            app.eliminarCompromiso(experto - 1 , compromiso - 1);

        }catch (NumberFormatException e){
            System.out.println("Error al eliminar los datos.");
        }


    }

    public static void guardar(MyApp app){
        app.save();
    }
    public static void cargar(MyApp app){
        app.load();
    }




    static void menu(MyApp app){
        boolean finalizar = false;
        Scanner sc = new Scanner(System.in);
        cargar(app);
        cargarListaExpertos(app);

        while (!finalizar) {

            System.out.println("Acciones disponibles:\n" +
                    "|1.Registrar experto|\t" +
                    "|2.Editar registro|\t" +
                    "|3.Eliminar registro|\t" +
                    "|4.Listar registros de expertos|\t" +
                    "|5.Agregar compromiso a una agenda|\t" +
                    "|6.Modificar compromiso en agenda|\t" +
                    "|7.Eliminar compromiso|\t" +
                    "|8.Listar compromisos|\t" +
                    "|9.Salir|"
            );
            int opcion = 0;
            try {
                opcion = sc.nextInt();
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Coloque una opcion valida");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarRegistro(app);
                    break;
                case 2:
                    modificarRegistro(app);
                    break;
                case 3:
                    eliminarRegistro(app);
                    break;
                case 4:
                    cargarListaExpertos(app);
                    break;
                case 5:
                    agregarCompromiso(app);
                    break;
                case 6:
                    modificarCompromiso(app);
                    break;
                case 7:
                    elimnarCompromiso(app);
                    break;
                case 8:
                    cargarAgenda(app);
                    break;
                case 9:
                    finalizar = true;
                    break;
                default:
                    System.out.println("No existen acciones validas para su opcion");
            }
        }
        guardar(app);

    }

}

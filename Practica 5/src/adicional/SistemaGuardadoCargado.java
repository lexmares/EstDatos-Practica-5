package adicional;
import java.io.*;
import ed.ito.*;
import principal.*;
public class SistemaGuardadoCargado{

    public void guardarLista(ListaDinamica<Expertos> listaExpertos) throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream("datos.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(listaExpertos);
        objectOutputStream.close();

    }
    public ListaDinamica<Expertos> cargarLista() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("datos.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ListaDinamica<Expertos> listaExpertos = (ListaDinamica<Expertos>) objectInputStream.readObject();
        objectInputStream.close();
        return listaExpertos;
    }






}

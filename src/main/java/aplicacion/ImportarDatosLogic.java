/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.DelitosDAO;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import modelo.Row;

/**
 *
 * @author andre
 */
public class ImportarDatosLogic {
    
    ArrayList<Row> delitos;
    
    //constructor de la clase
    public ImportarDatosLogic(){
        //inicimos la lista delitos
        delitos =  new ArrayList();
    }
    
    /***
     * Funcion que devolverá un ArrayList de delitos.
     * @return 
     */
     public ArrayList<Row> getDelitos() {
        return this.delitos;
    }
    
     /***
      * Funcion para cargar los delitos desde un archivo CSV.
      * @throws JAXBException 
      */
    public void caregarDelitos() throws JAXBException{
        //cargamos los delitos en el array 
        this.delitos.addAll(DelitosDAO.importarDatos());
           
    }
    
    /***
     * Funcion para buscar los delitos en delitosDAO.
     * 
     * @param busqueda
     * @return
     * @throws JAXBException 
     */
    public static ArrayList<Row> buscarDelitos(String busqueda, ArrayList<Row> delitos) throws JAXBException{
        ArrayList<Row> delitosBuscados = DelitosDAO.buscarDatos(busqueda, delitos);
        return delitosBuscados;
    }
    
    /***
     * Funcion que generara un archivo CSV.
     * @param delitos
     * @param archivo 
     */
    public static void generarCSV(ArrayList<Row> delitos, File archivo){
        DelitosDAO.generarCSV(delitos, archivo);
    }
    
    public static void generarXML(ArrayList<Row> delitos, File archivo) throws JAXBException{
        DelitosDAO.generarXML(delitos, archivo);
    }
    
}

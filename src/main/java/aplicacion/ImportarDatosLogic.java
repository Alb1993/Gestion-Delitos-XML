/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.DelitosDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBException;
import modelo.Row;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

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
    
    
     public ArrayList<Row> getDelitos() {
        //devolvemos el array delitos
        return this.delitos;
    }
    
     /***
      * Funcion para cargar los delitos desde un archivo CSV.
      * @param archivo
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
     */
    public static void generarCSV(ArrayList<Row> delitos, File archivo){
        DelitosDAO.generarCSV(delitos, archivo);
    }
    
}

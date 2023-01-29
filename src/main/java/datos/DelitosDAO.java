/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import modelo.Response;
import modelo.Row;

/**
 *
 * @author andre
 */
public class DelitosDAO {
    
     public static ArrayList<Row> importarDatos() throws JAXBException{
        
        Response myObject = DataSource.getResponse();
        //obtemos la lista de los delitos del objeto myObject
        ArrayList<Row> delitos = myObject.getRow();
        
        //devolvemos la lista de los delitos
        return delitos;
     
     }
     
    /***
     * Función que filtrará el ArrayList de delitos segun si el String busqueda tiene texto o no.
     * 
     * @param busqueda
     * @return
     * @throws JAXBException 
     */
    public static ArrayList<Row> buscarDatos(String busqueda) throws JAXBException{
        ArrayList<Row> delitosBuscados = new ArrayList<Row>();
        Response myObject = DataSource.getResponse();
        //obtemos la lista de los delitos del objeto myObject
        ArrayList<Row> delitos = myObject.getRow();
        /***
         * Si busqueda esta vacio, la funcion devolvera la lista de delitos completa.
         */
        if(busqueda.isEmpty()){
            delitosBuscados=delitos;
        }else{
            /***
             * Si busqueda contiene un String, la funcion devolvera los delitos que coincidan con el tipo de delito.
             */
            for(int i=0; i<delitos.size(); i++){
                if(delitos.get(i).getTipusdelicte().toLowerCase().contains(busqueda)){
                    delitosBuscados.add(delitos.get(i));
                }
            }
        }
        return delitosBuscados;
    }
    
}

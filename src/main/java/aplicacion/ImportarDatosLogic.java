/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.DelitosDAO;
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
    
    
     public ArrayList<Row> getDelitos() {
        //devolvemos el array delitos
        return this.delitos;
    }
    
    
    public void caregarDelitos() throws JAXBException{
        //cargamos los delitos en el array 
        this.delitos.addAll(DelitosDAO.importarDatos());
        
       
    }
}

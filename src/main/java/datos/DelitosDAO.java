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
        
        //creamos una nueva instancia JAXBContext para la clase Response que representa la estructira del archivo XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        //creamos un objeto Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //utilizamos el metodo unmarshal del objeto unmarshaller para convertir el archivo XML en un objeto de la clase Response
        Response myObject = (Response) unmarshaller.unmarshal(new File("C:\\Users\\andre\\Downloads\\delitos.xml")); 
        //obtemos la lista de los delitos del objeto myObject
        ArrayList<Row> delitos = myObject.getRow();
        
        //devolvemos la lista de los delitos
        return delitos;
     
     }
    
    
}

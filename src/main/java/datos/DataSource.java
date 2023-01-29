/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import modelo.Response;

/***
 * Funcion que devolvera la ruta del archivo XML.
 * 
 * @author Albert
 */
public class DataSource {
    
    public static Response getResponse() throws JAXBException{
        //creamos una nueva instancia JAXBContext para la clase Response que representa la estructira del archivo XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        //creamos un objeto Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //utilizamos el metodo unmarshal del objeto unmarshaller para convertir el archivo XML en un objeto de la clase Response      
    return (Response) unmarshaller.unmarshal(new File("C:\\Users\\Albert\\Desktop\\delitos.xml")); 
    }
    
}

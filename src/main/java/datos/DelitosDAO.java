/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import modelo.Response;
import modelo.Row;
import org.apache.commons.csv.CSVFormat;
import presentacion.App;
import presentacion.Notificaciones;

/**
 *
 * @author andre
 */
public class DelitosDAO {
    
     public static ArrayList<Row> importarDatos() throws JAXBException{
        File file = new File(App.class.getResource("/xml/delitos.xml").getFile());
        //creamos una nueva instancia JAXBContext para la clase Response que representa la estructira del archivo XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
        //creamos un objeto Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        //utilizamos el metodo unmarshal del objeto unmarshaller para convertir el archivo XML en un objeto de la clase Response      
        Response myObject = (Response) unmarshaller.unmarshal(file); 
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
    public static ArrayList<Row> buscarDatos(String busqueda, ArrayList<Row> delitos) throws JAXBException{
        ArrayList<Row> delitosBuscados = new ArrayList<Row>();
        //obtemos la lista de los delitos del objeto myObject
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
    
    public static void generarCSV(ArrayList<Row> data, File archivo) {
        String separador = ";";
        try (FileWriter writer = new FileWriter(archivo.getAbsolutePath());
             CSVWriter csvWriter = new CSVWriter(writer, separador.charAt(0))) {
            for (Row row : data) {
                String[] record = {row.getArticlecodipenal(), 
                    row.getCodicomunitatautonoma(), 
                    row.getCodigrupdelicte(),
                    row.getCodisentencia(),
                    row.getCoditipusdelicte(),
                    row.getComissiofets(),
                    row.getComunitatautonoma(),
                    row.getGrupdelicte(),
                    row.getNumerojutjat(),
                    row.getSexe(),
                    row.getTipusdelicte()};
                csvWriter.writeNext(record);
            }
            
            Notificaciones.mostrarConfirmacion("El archivo CSV se ha generado exitosamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        
    public static void generarXML(ArrayList<Row> data) throws PropertyException, JAXBException {

        JAXBContext context = JAXBContext.newInstance(Row.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(data, new File("C\\Users\\Albert\\Desktop\\rows.xml"));
        
    }
       
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que prrepresnta la raiz del archivo XML
 * @author andre
 */

//Indicamos que es un elemnto raiz y cual elemento repesenta exactamente
@XmlRootElement(name="response")
public class Response {
    
    private ArrayList<Row> row ;

    public Response() {
    }
    
    //indicamon que este arraylist representa un elemento que contiene elementos y especifiamos que elemnto del XML representa
    @XmlElementWrapper(name="row")
    //indicamos el nombre de los elementos que contiene el wrapper
    @XmlElement(name="row")
    public ArrayList<Row> getRow() {
        return row;
    }

    public void setRow(ArrayList<Row> row) {
        this.row = row;
    }

   
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albert
 */
@XmlRootElement(name = "delitos")
public class DelitosWrapper {

    private ArrayList<Row> rows;

    @XmlElement(name = "delito")
    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public DelitosWrapper() {
    }

    public DelitosWrapper(ArrayList<Row> rows) {
        this.rows = rows;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *Clase que representa el elemento row del archivo XML.
 * @author andre
 */

//indicamos el nombre del elemnto dentro del XML
@XmlRootElement(name="row")
//Indicamos losq elementos que queremos recuperar del archivo XML y en que orden
@XmlType(propOrder={"codisentencia", "comissiofets", "articlecodipenal", "coditipusdelicte", "tipusdelicte", "codigrupdelicte", "grupdelicte", "sexe", "numerojutjat", "codicomunitatautonoma", "comunitatautonoma"})
public class Row {
    
   private String codisentencia; 
   private String comissiofets;
   private String articlecodipenal;
   private String coditipusdelicte;
   private String tipusdelicte;
   private String codigrupdelicte;
   private String grupdelicte;
   private String sexe;
   private String numerojutjat;
   private String codicomunitatautonoma;
   private String comunitatautonoma;
   
   private ArrayList<Row> rows;
   
    public Row() {
        this.sexe = "X";
    }

    public String getCodisentencia() {
        return codisentencia;
    }

    public void setCodisentencia(String codisentencia) {
        this.codisentencia = codisentencia;
    }

    public String getComissiofets() {
        return comissiofets;
    }

    public void setComissiofets(String comissiofets) {
        this.comissiofets = comissiofets;
    }

    public String getArticlecodipenal() {
        return articlecodipenal;
    }

    public void setArticlecodipenal(String articlecodipenal) {
        this.articlecodipenal = articlecodipenal;
    }

    public String getCoditipusdelicte() {
        return coditipusdelicte;
    }

    public void setCoditipusdelicte(String coditipusdelicte) {
        this.coditipusdelicte = coditipusdelicte;
    }

    public String getTipusdelicte() {
        return tipusdelicte;
    }

    public void setTipusdelicte(String tipusdelicte) {
        this.tipusdelicte = tipusdelicte;
    }

    public String getCodigrupdelicte() {
        return codigrupdelicte;
    }

    public void setCodigrupdelicte(String codigrupdelicte) {
        this.codigrupdelicte = codigrupdelicte;
    }

    public String getGrupdelicte() {
        return grupdelicte;
    }

    public void setGrupdelicte(String grupdelicte) {
        this.grupdelicte = grupdelicte;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumerojutjat() {
        return numerojutjat;
    }

    public void setNumerojutjat(String numerojutjat) {
        this.numerojutjat = numerojutjat;
    }

    public String getCodicomunitatautonoma() {
        return codicomunitatautonoma;
    }

    public void setCodicomunitatautonoma(String codicomunitatautonoma) {
        this.codicomunitatautonoma = codicomunitatautonoma;
    }

    public String getComunitatautonoma() {
        return comunitatautonoma;
    }

    public void setComunitatautonoma(String comunitatautonoma) {
        this.comunitatautonoma = comunitatautonoma;
    }

    @Override
    public String toString() {
        return "Row{" + "codisentencia=" + codisentencia + ", comissiofets=" + comissiofets + ", articlecodipenal=" + articlecodipenal + ", coditipusdelicte=" + coditipusdelicte + ", tipusdelicte=" + tipusdelicte + ", codigrupdelicte=" + codigrupdelicte + ", grupdelicte=" + grupdelicte + ", sexe=" + sexe + ", numerojutjat=" + numerojutjat + ", codicomunitatautonoma=" + codicomunitatautonoma + ", comunitatautonoma=" + comunitatautonoma + '}';
    }
   
   
   
}

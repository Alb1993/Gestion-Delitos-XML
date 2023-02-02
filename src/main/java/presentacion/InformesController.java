/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package presentacion;

import aplicacion.InformesLogic;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Informe;
import modelo.Row;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class InformesController implements Initializable {

    private ArrayList<Row> delitos;

    private InformesLogic il;

    private Informe informe1;

    private Informe informe2;

    private Informe informe3;

    @FXML
    private Label tituloinforme3;

    @FXML
    private Label descripcioninforme3;

    @FXML
    private Button exportarinforme2;

    @FXML
    private Button exportarinforme1;

    @FXML
    private Label tituloinforme1;

    @FXML
    private Label tituloinforme2;

    @FXML
    private Button exportarinforme3;

    @FXML
    private Label descripcioninforme1;

    @FXML
    private Label descripcioninforme2;
    
    /*
        Función por la cual al pulsar el boton de exportar el informe 1 se abre un escogedor de archivos para indicar el archivo donde se exporte el informe y luego llamamos
        a la función para generar el contenido del  archivo
    */
    @FXML
    void onClick_exportar1(ActionEvent event) {

        File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe1);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
           
        }

    }
    
    
    /*
        Función por la cual al pulsar el boton de exportar el informe 2 se abre un escogedor de archivos para indicar el archivo donde se exporte el informe y luego llamamos
        a la función para generar el contenido del  archivo
    */
    @FXML
    void onClick_exportar2(ActionEvent event) {
        
         File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe2);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
           
        }

    }
    
    /*
        Función por la cual al pulsar el boton de exportar el informe 3 se abre un escogedor de archivos para indicar el archivo donde se exporte el informe y luego llamamos
        a la función para generar el contenido del  archivo
    */
    @FXML
    void onClick_exportar3(ActionEvent event) {
        
         File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe3);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
            
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //iniciamos el arraylist
        delitos = new ArrayList();
        
        //iniciamos la logica del informe
        il = new InformesLogic();
        
        //iniciamos los informes
        informe1 = new Informe();
        informe2 = new Informe();
        informe3 = new Informe();
        
        //especificamos que losa textos que se pondrán en los labels se ajuste a la altura del label si es necesario
        tituloinforme1.setWrapText(true);
        tituloinforme2.setWrapText(true);
        tituloinforme3.setWrapText(true);
        descripcioninforme1.setWrapText(true);
        descripcioninforme2.setWrapText(true);
        descripcioninforme3.setWrapText(true);
        
        //establecemos el contenido de los labels de titulos de los informes
        tituloinforme1.setText("Cuantos delitos de tipo 'Robatori amb violència o intimidació' se han cometido en el año 2022 en las Islas Baleares");
        tituloinforme2.setText("Cuantos delitos del grupo de delitos 'De les lesions' se han cometido durante el año 2021 en las Islas Baleares por hombres");
        tituloinforme3.setText("Cuantos delitos del grupo de delitos 'Delictes contra el patrimoni i contra l'ordre socioeconòmic' se han cometido durante el año 2020");
        
    }
    
    /*
    Función con la que abrimos el selector de archivos
    @return archivo
    */
    public static File exportarInforme() {
        //creamos un stage para mostrar el selector de archivos
        Stage stage = new Stage();
        // creamos el selector de archivos
        FileChooser filechooser = new FileChooser();
        //esoecificamos el titulo del selector de archivos
        filechooser.setTitle("Exportar informe");
        
        // Creamos un filtro de archivos que solo muestre archivos .txt
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");

        // Añadir el filtro al filechooser
        filechooser.getExtensionFilters().add(txtFilter);
        
        //mostramos el selector de archivos y recogemos el archivo seleccionado 
        File archivo = filechooser.showSaveDialog(stage);

        return archivo;

    }
    /*
    Funcion con  la cual carrgarmos los delitos recibidos por el PrimaryController
       @param delitos
    */
    public void setDelitos(ArrayList<Row> delitos) {
        
        //ponemos los delitos recibidos en el array del controler
        this.delitos.addAll(delitos);   
         //cargamos la información de los informes
         cargarInforme1();
         cargarInforme2();
         cargarInforme3();
    
    }
    
    /*
    Función con la cual cargamos la información del informe 1 y luego especificamos la descripción del informe de la psntalla con el contenido del informe
    */
    private void cargarInforme1() {

        informe1 = il.cargarInforme1(delitos);

        descripcioninforme1.setText(informe1.getInfromacion());

    }
    
    /*
    Función con la cual cargamos la información del informe2 y luego especificamos la descripción del informe de la psntalla con el contenido del informe
    */
    private void cargarInforme2() {

        informe2 = il.cargarInforme2(delitos);

        descripcioninforme2.setText(informe2.getInfromacion());
    }
    
    /*
    Función con la cual cargamos la información del informe 3 y luego especificamos la descripción del informe de la psntalla con el contenido del informe
    */
    private void cargarInforme3() {
        informe3 = il.cargarInforme3(delitos);

        descripcioninforme3.setText(informe3.getInfromacion());
    }

}

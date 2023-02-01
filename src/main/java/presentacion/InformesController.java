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

    @FXML
    void onClick_exportar1(ActionEvent event) {

        File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe1);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
            Logger.getLogger(InformesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void onClick_exportar2(ActionEvent event) {
        
         File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe2);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
            Logger.getLogger(InformesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void onClick_exportar3(ActionEvent event) {
        
         File archivo = exportarInforme();

        try {
            il.crearInforme(archivo, informe3);
            Notificaciones.mostrarConfirmacion("El archivo se ha creado con exito.");
        } catch (IOException ex) {
            Logger.getLogger(InformesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        delitos = new ArrayList();
        il = new InformesLogic();
        informe1 = new Informe();
        informe2 = new Informe();
        informe3 = new Informe();
        tituloinforme1.setWrapText(true);
        tituloinforme2.setWrapText(true);
        tituloinforme3.setWrapText(true);
        descripcioninforme1.setWrapText(true);
        descripcioninforme2.setWrapText(true);
        descripcioninforme3.setWrapText(true);
        tituloinforme1.setText("Cuantos delitos de tipo 'Robatori amb violència o intimidació' se han cometido en el año 2022 en las Islas Baleares");
        tituloinforme2.setText("Cuantos delitos del grupo de delitos 'De les lesions' se han cometido durante el año 2021 en las Islas Baleares por hombres");
        tituloinforme3.setText("Cuantos delitos del grupo de delitos 'Delictes contra el patrimoni i contra l'ordre socioeconòmic' se han cometido durante el año 2020");
        
    }

    public static File exportarInforme() {
        Stage stage = new Stage();
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Exportar informe");
        File archivo = filechooser.showSaveDialog(stage);

        return archivo;

    }

    public void setDelitos(ArrayList<Row> delitos) {
        this.delitos.addAll(delitos);
        if (!this.delitos.isEmpty()) {
            cargarInforme1();
            cargarInforme2();
            cargarInforme3();
        }else{
             Notificaciones.mostrarError("No se ha podido recuperar los datos de  los delitos");
             String error = "No se ha podido recuperar los datos de  los delitos";
             descripcioninforme1.setText(error);
             descripcioninforme2.setText(error);
             descripcioninforme3.setText(error);
             
             exportarinforme2.setDisable(true);
             exportarinforme1.setDisable(true);
             exportarinforme3.setDisable(true);

             
        }

    }

    private void cargarInforme1() {

        informe1 = il.cargarInforme1(delitos);

        descripcioninforme1.setText(informe1.getInfromacion());

    }

    private void cargarInforme2() {

        informe2 = il.cargarInforme2(delitos);

        descripcioninforme2.setText(informe2.getInfromacion());
    }

    private void cargarInforme3() {
        informe3 = il.cargarInforme3(delitos);

        descripcioninforme3.setText(informe3.getInfromacion());
    }

}

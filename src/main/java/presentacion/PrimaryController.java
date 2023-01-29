/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import aplicacion.ImportarDatosLogic;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import modelo.Row;


/**
 *
 * @author Albert
 */
public class PrimaryController implements Initializable {
    
    private ImportarDatosLogic idl;  
    
    private ArrayList<Row> delitos;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnExport;

    @FXML
    private ToggleButton btnSwitch;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnDoc;

    @FXML
    private Button btnImport;
    
     @FXML
    void onClick_importar(ActionEvent event) {
       
        try {
            
            File archivo = cargarArchivo();
                /***
                 *  Cargamos los delitos.
                 */
                idl.caregarDelitos(archivo);
                /***
                 * Una vez cargados los delitos los obtenemos y añadimos el array delitos.
                 */          
                delitos.addAll(idl.getDelitos());
                Notificaciones.mostrarConfirmacion("El archivo se ha cargado con exito.");
        } catch (JAXBException ex) {
            Notificaciones.mostrarError("Formato de archivo no valido.");
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /***
         * Iniciamos una nueva instancia de la clase ImportarDatosLogic.
         */
        idl = new ImportarDatosLogic();
        //iniciamos  el array de delitos
        delitos = new ArrayList();
         
    }
    
    /***
     * Función ejecutada por el botón de Busqueda que devolverá un ArrayList filtrado según el texto escrito.
     * 
     * @param event
     * @throws JAXBException 
     */
    @FXML
    void onClick_Search(ActionEvent event) throws JAXBException {
        String searchString = txtSearch.getText().toLowerCase();
        delitos = ImportarDatosLogic.buscarDelitos(searchString, delitos);
    }
    
    @FXML
    void exportarCSV(ActionEvent event) {
        ImportarDatosLogic.generarCSV(delitos);
    }
    
    
    
    @FXML
    void gen_Informe(ActionEvent event) {
       
    }
    
    public static File cargarArchivo(){
        Stage stage1 = new Stage();
        FileChooser filechooser1 = new FileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Archivo XML", "xml");
        filechooser1.setTitle("Selecciona archivo XML");
        File archivo = filechooser1.showOpenDialog(stage1);
        
        
        return archivo;
    }
    
}


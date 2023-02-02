/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import aplicacion.ImportarDatosLogic;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import modelo.Row;

/**
 *
 * @author Albert
 */
public class PrimaryController implements Initializable {

    private ObservableList<Row> listaObservabledelitos;

    private ImportarDatosLogic idl;

    private MenuItem itemDefault,itemCodiSentencia,itemComisionHechos,itemArticuloPenal,itemTipoDelito,itemGrupoDelito,itemSexo,itemComunidadAutonoma;
    
    private ArrayList<Row> delitos;

    private ArrayList<Row> filteredData;

    private MenuItem item; 

    @FXML
    private Button btnSearch;

    @FXML
    private RadioButton radioXML;

    @FXML
    private RadioButton radioCSV;

    @FXML
    private Button btnExport;

    @FXML
    private TableView<Row> tabladelitos;

    @FXML
    private TableColumn<Row, String> codigosentencia, comisionhechos, articulopenal, tipodlito, grupodelito, sexo, comunidadautonoma;

    @FXML
    private ToggleButton btnSwitch;

    @FXML
    private TextField txtSearch;

    @FXML
    private MenuButton orderMenu;

    @FXML
    private Button btnDoc;

    @FXML
    private Button btnImport;

    @FXML
    void onClick_CSV(ActionEvent event) {
        radioXML.setSelected(false);
    }

    @FXML
    void onClick_XML(ActionEvent event) {
        radioCSV.setSelected(false);
    }

    @FXML
    void onClick_importar(ActionEvent event) {
        try {
            //Cargamos los delitos.
            idl.caregarDelitos();
            // Una vez cargados los delitos los obtenemos y añadimos el array delitos.       
            delitos.addAll(idl.getDelitos());
            //y carrgamos los delitos en la lista observable para que se miestren los elementos en el tableview
            listaObservabledelitos.setAll(delitos);
            Notificaciones.mostrarConfirmacion("El archivo se ha cargado con exito.");
        } catch (JAXBException ex) {
            Notificaciones.mostrarError("Formato de archivo no valido.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *
         * Iniciamos una nueva instancia de la clase ImportarDatosLogic.
         */
        idl = new ImportarDatosLogic();
        //iniciamos  el array de delitos
        delitos = new ArrayList();
        //iniciamos la lista observable con la que mostrara los delitos 
        listaObservabledelitos = FXCollections.<Row>observableArrayList();
        //indicamos que los elementos que se mostrara son de la lista listaObservabledelitos 
        tabladelitos.setItems(listaObservabledelitos);
        //asignamos las columnas de la tabla con .los atributos del objeto Row que mostraran 
        codigosentencia.setCellValueFactory(new PropertyValueFactory<>("Codisentencia"));
        comisionhechos.setCellValueFactory(new PropertyValueFactory<>("Comissiofets"));
        articulopenal.setCellValueFactory(new PropertyValueFactory<>("Articlecodipenal"));
        tipodlito.setCellValueFactory(new PropertyValueFactory<>("Tipusdelicte"));
        grupodelito.setCellValueFactory(new PropertyValueFactory<>("Grupdelicte"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        comunidadautonoma.setCellValueFactory(new PropertyValueFactory<>("Comunitatautonoma"));
        itemDefault = new MenuItem("Default");
        itemCodiSentencia = new MenuItem("Codigo Sentencia");
        itemComisionHechos = new MenuItem("Comision Hechos");
        itemArticuloPenal = new MenuItem("Articulo Penal");
        itemTipoDelito = new MenuItem("Tipo Delito");
        itemGrupoDelito = new MenuItem("Grupo Delito");
        itemSexo = new MenuItem("Sexo");
        itemComunidadAutonoma = new MenuItem("Comunidad Autonoma");
        orderMenu.getItems().addAll(itemDefault,itemCodiSentencia,itemComisionHechos,itemArticuloPenal,itemTipoDelito,itemGrupoDelito,itemSexo,itemComunidadAutonoma);
        
        /**
         * *
         * Listener que filtrará los datos en funcion del texto escrito.
         */
        txtSearch.addEventFilter(KeyEvent.KEY_PRESSED, event
                -> {
            if (!delitos.isEmpty()) {
                String searchString = txtSearch.getText().toLowerCase();

                txtSearch.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    filteredData = (ArrayList<Row>) delitos.stream()
                            .filter((Row data) -> data.getTipusdelicte().toLowerCase().contains(newValue.toLowerCase()))
                            .collect(Collectors.toList());
                    listaObservabledelitos.clear();
                    listaObservabledelitos.setAll(filteredData);
                    tabladelitos.refresh();
                });
            }
        }
        );

    }

    /**
     * *
     * Accion Realizada al pulsar boton Exportar.
     *
     * @param event
     * @throws JAXBException
     */
    @FXML
    void exportarCSV(ActionEvent event) throws JAXBException {
        //if (!cifradoActivado()) {
        if (delitos.isEmpty()) {
            Notificaciones.mostrarError("Debes importar el documento para exportar datos.");
        } else {
            if (this.filteredData == null) {
                this.filteredData = delitos;
                cargarDoc();
            } else {
                cargarDoc();
            }
        }
    }

    /**
     * *
     * Funcion para cargar Documento XML o CSV
     *
     * @throws JAXBException
     */
    void cargarDoc() throws JAXBException {
        if (radioXML.isSelected()) {
            File archivo = crearArchivo("xml");
            ImportarDatosLogic.generarXML(filteredData, archivo);
        } else if (radioCSV.isSelected()) {
            File archivo = crearArchivo("csv");
            ImportarDatosLogic.generarCSV(filteredData, archivo);

        } else {
            Notificaciones.mostrarError("Selecciona una opcion para importar");
        }
    }

    /**
     * *
     * Funcion que generará tres informes exportables si un Array de delitos ha
     * sido importado previamente.
     *
     * @param event
     * @throws presentacion.PrimaryController.DelitoException
     */
    @FXML
    void gen_Informe(ActionEvent event) throws DelitoException {
        if (delitos.isEmpty()) {
            throw new DelitoException("Importa los delitos antes de generar el informe.");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("informes.fxml"));
                Parent root = null;
                root = fxmlLoader.load();
                InformesController informesController = fxmlLoader.getController();
                informesController.setDelitos(delitos);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();

            } catch (IOException | IllegalStateException ex) {
                System.out.println("fff");

            }

        }

    }

    /**
     * *
     * Excepcion personalizada de Delito.
     */
    public class DelitoException extends Exception {

        public DelitoException(String n) {
            Notificaciones.mostrarError(n);
        }
    }

    /**
     * *
     * Funcion que devuelve un objeto File a traves de un FileChooser.
     *
     * @return
     */
    public static File crearArchivo(String extension) {
        Stage stage1 = new Stage();
        FileChooser filechooser1 = new FileChooser();
        try {
            FileFilter imageFilter = new FileNameExtensionFilter("Archivo " + extension.toUpperCase(), extension);
            filechooser1.setTitle("Crear Archivo " + extension.toUpperCase());
            File archivo = filechooser1.showSaveDialog(stage1);
            return archivo;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public boolean cifradoActivado() {

        boolean cifradoActivado = false;

        if (btnSwitch.isPressed()) {
            cifradoActivado = true;
        }

        return cifradoActivado;
    }
    
}
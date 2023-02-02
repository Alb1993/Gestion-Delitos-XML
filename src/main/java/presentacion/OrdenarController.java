/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Row;

/**
 *
 * @author Albert
 */
public class OrdenarController {

    public ArrayList<Row> delitos;

    @FXML
    private Button btnComision;

    @FXML
    private Button btnGrupo;

    @FXML
    private Button btnComunidad;

    @FXML
    private Button btnTipo;

    @FXML
    private Button btnCodigo;

    @FXML
    private Button btnSexo;

    /***
     * Recoge los delitos de la pantalla Principal.
     * @param delitos 
     */
    public void setData(ArrayList<Row> delitos) {
        this.delitos = delitos;
    }
    
    /***
     * Accion que ordena por Tipo de Delito.
     * @param event 
     */
    @FXML
    void onAction_Tipo(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getTipusdelicte().compareTo(o2.getTipusdelicte());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }
    
    
    /***
     * Accion que ordena por Codigo de Delito.
     * @param event 
     */
    @FXML
    void onAction_Codigo(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getCodisentencia().compareTo(o2.getCodisentencia());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }
    
    /***
     * Accion que ordena por Comisiones.
     * @param event 
     */
    @FXML
    void onAction_Comision(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getComissiofets().compareTo(o2.getComissiofets());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
        
    }

    /***
     * Accion que ordena por Grupo de Delito.
     * @param event 
     */
    @FXML
    void onAction_Grupo(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getGrupdelicte().compareTo(o2.getGrupdelicte());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    /***
     * Accion que ordena por sexo.
     * @param event 
     */
    @FXML
    void onAction_Sexo(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getSexe().compareTo(o2.getSexe());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
    }

    /***
     * Accion que ordena por comunidad autonoma.
     * @param event 
     */
    @FXML
    void onAction_Comunidad(ActionEvent event) {
        Collections.sort(delitos, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.getCodicomunitatautonoma().compareTo(o2.getCodicomunitatautonoma());
            }
        });
        Notificaciones.mostrarConfirmacion("Ordenacion Realizada.");
        PrimaryController.setDatosOrdenados(delitos);
        Node source = (Node) event.getSource();
        Stage stage1 = (Stage) source.getScene().getWindow();
        stage1.close();
        
    }

}

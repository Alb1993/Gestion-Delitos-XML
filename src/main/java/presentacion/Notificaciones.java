/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 *
 * @author Albert
 */
public class Notificaciones {
    
    /***
     * Funcion que muestra un mensaje de Error por pantalla.
     * @param txt 
     */
    public static void mostrarError(String txt){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("ERROR");
        alert.setContentText(txt);

        alert.showAndWait();
    }
    
    /***
     * Funcion que muestra un mensaje de Confirmacion por pantalla.
     * @param txt 
     */
    public static void mostrarConfirmacion(String txt){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("CONFIRMATION");
        alert.setContentText(txt);

        alert.showAndWait();
    }
    
}

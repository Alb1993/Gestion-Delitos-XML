package presentacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import aplicacion.ContraseñaLogic;
import aplicacion.CifradoLogic;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author FPShare
 */
public class ContraseñaController implements Initializable {

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField inputPassword;

    /**
     * Función para que al pulsar el botón se almacene el String del campo
     * inputPassword
     * 
     * @param event
     * @throws Exception 
     */
    @FXML
    void guardarContraseña(ActionEvent event) throws Exception {
        String contraseña = "";
        if (ContraseñaLogic.escrituraContraseña(inputPassword.getText())) {
            contraseña = inputPassword.getText();
        } else {
            errorContraseña();
        }
        
        almacenarContraseña(contraseña);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Función para mostrar error de contraseña no valida
     */
    public void errorContraseña() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Ha ocurrido un error");
        alert.setContentText("La contraseña no posee una longitud valida (entre 4 y 20 caracteres)");
        alert.showAndWait();
    }
    
    /**
     * Función para almacenar la contraseña escrita por el usuario
     * 
     * @param contraseña
     * @return 
     */
    public String almacenarContraseña(String contraseña) {
        return contraseña;
    }
}

package presentacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import datos.ContraseñaDAO;
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

    @FXML
    void guardarContraseña(ActionEvent event) throws Exception {
        if (ContraseñaDAO.escrituraContraseña(inputPassword.getText())) {
            String contraseña = inputPassword.getText();
        } else {
            errorContraseña();
        }
        
        
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

    public void errorContraseña() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Ha ocurrido un error");
        alert.setContentText("La contraseña no posee una longitud valida (entre 4 y 20 caracteres)");
        alert.showAndWait();
    }
}

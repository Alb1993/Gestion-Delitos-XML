module presentacion {
    requires javafx.controls;
    requires javafx.fxml;

    opens presentacion to javafx.fxml;
    exports presentacion;
}

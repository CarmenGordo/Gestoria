package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorModalAlerta implements Initializable{

    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCerrarAlerta;
    @FXML
    private FlowPane modalAjustes;
    @FXML
    private Pane paneCreditos;
    @FXML
    private Label textCreditos;

    @FXML
    void aceptarOperacion() {

    }

    @FXML
    void cancelarOperacion() {

    }

    @FXML
    void cerrarModalAlerta() {

    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       paneCreditos.setVisible(false);
    }

}

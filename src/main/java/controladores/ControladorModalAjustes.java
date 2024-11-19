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

public class ControladorModalAjustes implements Initializable{

    @FXML
    private Button btnCerrarAjustes;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnVerCreditos;
    @FXML
    private FlowPane modalAjustes;
    @FXML
    private Pane paneCreditos;
    @FXML
    private Label textCreditos;
    
    @FXML
    private void cerrarModalAjustes() {
        Stage stage = (Stage) btnCerrarAjustes.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void verCreditos() {
        
        paneCreditos.setVisible(true);
    }
    
    @FXML
    private void salir() {
        
        System.exit(0);
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}

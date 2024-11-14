package paquete.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Molina
 */
public class ControladorPgProductos implements Initializable {

     @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAñadir;

    @FXML
    private Button btnBorrar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnHerramientas;

    @FXML
    private void btnProductos(ActionEvent event){
        try{
            //carga el nuevo archivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../trabajo_pg_productos/pg_productos.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    private void btnTiendas(ActionEvent event){
        try{
            //carga el nuevo archivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../trabajo_pg_tiendas/pg_tiendas.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace(); 
        }
    }
    
    @FXML
    private void btnAlmacenes(ActionEvent event){
        try{
            //carga el nuevo archivo
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../trabajo_pg_almacenes/pg_almacenes.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        }catch(IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    private CheckBox chckTodos;

    @FXML
    private TableColumn<?, ?> columnCheck;
    
    @FXML
    private TableView<?> tablaProductos;

    @FXML
    private TableColumn<?, ?> columnId;

    @FXML
    private TableColumn<?, ?> columnImg;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnStock;

    @FXML
    private TableColumn<?, ?> columnTalla;

    @FXML
    private TableColumn<?, ?> columnTipo;

    @FXML
    private ImageView imgLogo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

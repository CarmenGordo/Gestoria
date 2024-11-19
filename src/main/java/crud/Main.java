package crud;

import controladores.ControladorIndex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author carmen_gordo
 */
public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Index.fxml"));
        
        Parent root = loader.load();
        //pasar el stage para usar el modal:
        ControladorIndex controlador = loader.getController();
        controlador.setStage(stage);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

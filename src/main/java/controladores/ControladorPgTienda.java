package controladores;

import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelos.Tiendas;


/**
 *
 * @author carmen_gordo
 */
public class ControladorPgTienda {
    
    @FXML
    private TableView<Tiendas> tablaTienda;
    @FXML
    private TableColumn<Tiendas, String> columnIdTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnDirTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Map> columnHorarioTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnNombreTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnPaisTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Tiendas.TipoTienda> columnTipoTiendaSelec;
    
    
    public void recogerTiendaSelec(Tiendas tienda){
        columnIdTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombreTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTipoTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDirTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnHorarioTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("horario"));
       
        tablaTienda.getItems().clear();
        //tablaTienda.getItems().add(tienda);
    }
    
}

package controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.Tiendas;
import modelos.Almacenes;
import modelos.Productos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.ResourceBundle;

import java.sql.Connection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ConexionBD;

public class ControladorPgTiendas implements Initializable {

    public Connection conexion;
    public Statement st;
    public ResultSet rs;

    ObservableList<Tiendas> listaTiendas = FXCollections.observableArrayList();
    ObservableList<Almacenes> listaAlmacenes = FXCollections.observableArrayList();
    ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
    
    
    
    //Botones iniciales menu:
    @FXML
    private Button cambiarPaneListaTiendas;
    @FXML
    private void cambiarPaneListaTiendas(){
        paneContenidoListaTiendas.setViewOrder(0);
        paneContenidoListaAlmacenes.setViewOrder(1);
        paneContenidoListaProductos.setViewOrder(2);
    }
    @FXML
    private Button cambiarPaneListaAlmacenes;
    @FXML
    private void cambiarPaneListaAlmacenes(){
        paneContenidoListaAlmacenes.setViewOrder(0);
        paneContenidoListaTiendas.setViewOrder(1);
        paneContenidoListaProductos.setViewOrder(2);
    }
    @FXML
    private Button cambiarPaneListaProductos;
    @FXML
    private void cambiarPaneListaProductos(){
        paneContenidoListaProductos.setViewOrder(0);
        paneContenidoListaTiendas.setViewOrder(1);
        paneContenidoListaTiendas.setViewOrder(2);
    }

    //Pane:
    @FXML
    private Pane paneContenidoListaTiendas;
    @FXML
    private Pane paneContenidoTiendaSelec;
    @FXML
    private Pane paneContenidoListaAlmacenes;
    @FXML
    private Pane paneContenidoListaProductos;
    
    //Tabla lista tiendas:
    @FXML
    private TableView<Tiendas> tablaListaTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnIdListaTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnNombreListaTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadListaTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnDirListaTiendas;
    @FXML
    private TableColumn<Tiendas, Map> columnHorarioListaTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnPaisListaTiendas;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelListaTiendas;
    @FXML
    private TableColumn<Tiendas, Tiendas.TipoTienda> columnTipoListaTiendas;
    
    
    
    
    //Tabla almacenes lista:
    @FXML
    private TableView<Almacenes> tablaListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, String> columnIdListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, String> columnNombreListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, String> columnDirListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, String> columnCiudadListaAlmacenes;   
    @FXML
    private TableColumn<Almacenes, String> columnPaisListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, Integer> columnTelListaAlmacenes;
    @FXML
    private TableColumn<Almacenes, Map> columnHorarioListaAlmacenes;    
    @FXML
    private TableColumn<Almacenes, Integer> columnCapOcupadaListaAlmacenes; 
    @FXML
    private TableColumn<Almacenes, Integer> columnCapTotalListaAlmacenes; 
 
    
    
    
    
    
    
    //pg tienda selec:
    @FXML
    private void verSeleccion() throws IOException {
        Tiendas tiendaSelec = tablaListaTiendas.getSelectionModel().getSelectedItem();
        
        visiblePaneCabecera(true);
        textoMigas.setText("Tiendas"+ " > "+tiendaSelec.getNombre());
        
        paneContenidoListaTiendas.setVisible(false);
        paneContenidoTiendaSelec.setVisible(true);
        
        
    }
    
    @FXML
    private TableView tablaTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnIdTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnNombreTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnDirTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Map> columnHorarioTiendaSelec;
    @FXML
    private TableColumn<Tiendas, String> columnPaisTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelTiendaSelec;
    @FXML
    private TableColumn<Tiendas, Tiendas.TipoTienda> columnTipoTiendaSelec;
   
    @FXML
    private Button btnVolver;
    @FXML
    private Text textoMigas;
    @FXML
    private void volverTiendas(){
        
    }
    
    private void visiblePaneCabecera(boolean v){
        btnVolver.setVisible(v);
        textoMigas.setVisible(v);
    }

    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conexion = ConexionBD.getConexion();  
            if (conexion != null) {
                st = conexion.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error de conexión");
            alert.setContentText("No se pudo establecer la conexión con la base de datos");
            alert.showAndWait();
        }
        
        if (conexion != null) {
            try {
                ObservableList<Tiendas> listaT = darListaTiendas();
                ObservableList<Almacenes> listaA = darListaAlmacenes();
                
                columnIdListaTiendas.setCellValueFactory(new PropertyValueFactory<>("id_tienda"));
                columnNombreListaTiendas.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                columnTipoListaTiendas.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                columnDirListaTiendas.setCellValueFactory(new PropertyValueFactory<>("direccion"));
                columnCiudadListaTiendas.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
                columnPaisListaTiendas.setCellValueFactory(new PropertyValueFactory<>("pais"));
                columnTelListaTiendas.setCellValueFactory(new PropertyValueFactory<>("telefono"));
                columnHorarioListaTiendas.setCellValueFactory(new PropertyValueFactory<>("horario"));
                
                tablaListaTiendas.setItems(listaT); 
                
                columnIdListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("id_almacen"));
                columnNombreListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                columnDirListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("direccion"));
                columnCiudadListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
                columnPaisListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("pais"));
                columnTelListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("telefono"));
                columnHorarioListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("horario"));
                columnCapOcupadaListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("capacidad_ocupada"));
                columnCapTotalListaAlmacenes.setCellValueFactory(new PropertyValueFactory<>("capacidad_total"));
                
                tablaListaAlmacenes.setItems(listaA);
                
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se han podido recoges los datos");
                alert.showAndWait();
            }
        }
    }
    
   //llamada a las listas:
    
    public ObservableList<Tiendas> darListaTiendas() throws JsonProcessingException {
        ObservableList<Tiendas> listaTiendas = FXCollections.observableArrayList();
        
        if (conexion != null) {
            String query = "SELECT * FROM tiendas";
            try {
                rs = st.executeQuery(query);
                while (rs.next()) {
                    //convertir el enum a string
                    Tiendas.TipoTienda tipo = Tiendas.TipoTienda.valueOf(rs.getString("tipo"));

                    //convertir el json a string
                    String horarioJson = rs.getString("horario");
                    Map<String, String> horarioMap = null;
                    if (horarioJson != null && !horarioJson.isEmpty()) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            horarioMap = objectMapper.readValue(horarioJson, Map.class);
                        } catch (JsonProcessingException e) {
                            System.out.println("Error al procesar el JSON: " + e.getMessage());
                            continue;  
                        }
                    }

                    
                    Tiendas tienda = new Tiendas(
                        rs.getString("id_tienda"),
                        rs.getString("nombre"),
                        tipo,
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("pais"),
                        rs.getInt("telefono"),
                        horarioMap  
                    );

                    
                    listaTiendas.add(tienda);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaTiendas;
    }
    
    public void mostrarTiendas() {
       tablaListaTiendas.setItems(listaTiendas);
    }
    
    public ObservableList<Almacenes> darListaAlmacenes() throws JsonProcessingException {
        ObservableList<Almacenes> listaAlmacenes = FXCollections.observableArrayList();
        
        if (conexion != null) {
            String query = "SELECT * FROM almacenes";
            try {
                rs = st.executeQuery(query);
                while (rs.next()) {
                  
                    //convertir el json a string
                    String horarioJson = rs.getString("horario");
                    Map<String, String> horarioMap = null;
                    if (horarioJson != null && !horarioJson.isEmpty()) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            horarioMap = objectMapper.readValue(horarioJson, Map.class);
                        } catch (JsonProcessingException e) {
                            System.out.println("Error al procesar el JSON: " + e.getMessage());
                            continue;  
                        }
                    }

                    
                    Almacenes almacen = new Almacenes(
                        rs.getString("id_almacen"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("pais"),
                        rs.getInt("telefono"),
                        horarioMap,
                        rs.getInt("capacidad_ocupada"),
                        rs.getInt("capacidad_total"),
                        rs.getString("id_tienda")
                    );

                    
                    listaAlmacenes.add(almacen);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaAlmacenes;
    }
    
    public void mostrarAlmacenes() {
       tablaListaAlmacenes.setItems(listaAlmacenes);
    }
}

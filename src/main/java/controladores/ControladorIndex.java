package controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.io.File;

import modelos.Tiendas;
import modelos.Almacenes;
import modelos.HorarioAlmacen;
import modelos.Productos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Set;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationMessage;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import javafx.scene.control.Control;
import org.controlsfx.validation.Validator;
import org.controlsfx.validation.decoration.GraphicValidationDecoration;
import utils.ConexionBD;

public class ControladorIndex implements Initializable {

    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    
    private ResourceBundle rb;

    private Stage stage;
    
    ObservableList<Tiendas> listaTiendas = FXCollections.observableArrayList();
    ObservableList<Almacenes> listaAlmacenes = FXCollections.observableArrayList();
    ObservableList<HorarioAlmacen> horarioAlmacen = FXCollections.observableArrayList();
    ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
    //? cambiar a libreria para conseguir paises y ciudades
    ObservableList<String> ciudadesEspaña = FXCollections.observableArrayList("","Sevilla", "Málaga", "Granada", "Córdoba", "Almería", "Cádiz","Jaén", "Huelva","Zaragoza", "Huesca", "Teruel","Oviedo", "Gijón", "Avilés","Santander","Toledo", "Albacete", "Ciudad Real","Guadalajara", "Cuenca","Barcelona");
    ObservableList<String> paisesEu = FXCollections.observableArrayList("","España", "Francia", "Alemania", "Italia", "Portugal", "Reino Unido", "Irlanda","Suecia");
    
    
    //general pane: cabeceras
    @FXML
    private AnchorPane anchorPaneContenedor;
    @FXML
    private Pane paneCabecera;
    @FXML
    private Pane paneBotonera;
    @FXML
    private StackPane stackpaneContenido;
    
    
    
    //Pane contenido:
    @FXML
    private Pane paneContenidoListaProductos;
    @FXML
    private Pane paneContenidoProductoSelec;
    @FXML
    private Pane paneAñadirProducto;
    @FXML
    private Pane paneContenidoInicio;
    @FXML
    private Pane paneContenidoListaTiendas;
    @FXML
    private Pane paneContenidoTiendaSelec;
    @FXML
    private Pane paneContenidoListaAlmacenes;
    @FXML
    private Pane paneContenidoAlmacenSelec;
    @FXML
    private Pane paneAñadirAlmacen;
    
    
   
    
    
    //PaneCabecera: 
    @FXML
    private Button btnVolver;
    //? arreglar migas y volver atras
    
    @FXML
    private void volverTiendas(){
        
    }
    private void visiblePaneCabecera(boolean b){
        btnVolver.setVisible(b);
        //textoMigas.setVisible(b);
    }
    private void quitarPaneCabecera(boolean b){
        paneBotonera.setVisible(!b);
        paneBotonera.setManaged(!b);
    }
    
    
    
    //Botones iniciales menu:
    @FXML
    private VBox menuPrincipal;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Button btnMenu;
    @FXML
    private void btnCambiarMenu(){
        if (menuPrincipal.getPrefWidth() == 150) {
            menuPrincipal.setPrefWidth(80);
            
            cambiarMenuPrincipal();
            
        } else {
            menuPrincipal.setPrefWidth(150);
        }
    }
    private void cambiarMenuPrincipal(){
        //?cambiar solo a icono
        btnTablero.setText("D");
        btnProductos.setText("P");
        btnTiendas.setText("T");
        btnAlmacenes.setText("A");
        btnAjustes.setText("H");
        
        btnTablero.setPrefWidth(80);
        btnProductos.setPrefWidth(80);
        btnTiendas.setPrefWidth(80);
        btnAlmacenes.setPrefWidth(80);
        btnAjustes.setPrefWidth(80);
        paneCabecera.setPrefWidth(720);
        paneBotonera.setPrefWidth(720);
        stackpaneContenido.setPrefWidth(720);
        
        AnchorPane.setRightAnchor(paneCabecera, 0.0);
        AnchorPane.setRightAnchor(paneBotonera, 0.0);
        AnchorPane.setRightAnchor(stackpaneContenido, 0.0);
        anchorPaneContenedor.getChildren().addAll(paneCabecera, paneBotonera, stackpaneContenido);
        //? ajustar mejor
  
    }
    @FXML
    private Button btnTablero;
    @FXML
    private void cambiarPaneInicio(){
        quitarPaneCabecera(true);
        visiblePaneCabecera(false);
        mostrarPane(paneContenidoInicio);
        
    }
    @FXML
    private Button btnTiendas;
    @FXML
    private void cambiarPaneListaTiendas(){
        quitarPaneCabecera(false);
        visiblePaneCabecera(false);
        mostrarPane(paneContenidoListaTiendas);
    }
    private void cambiarPaneTiendaSelec(){
        quitarPaneCabecera(false);
        mostrarPane(paneContenidoTiendaSelec);
    }
    @FXML
    private Button btnAlmacenes;
    @FXML
    private void cambiarPaneListaAlmacenes(){
        quitarPaneCabecera(false);
        visiblePaneCabecera(false);
        mostrarPane(paneContenidoListaAlmacenes);
    }
    @FXML
    private Button btnProductos;
    @FXML
    private void cambiarPaneListaProductos(){
        quitarPaneCabecera(false);
        visiblePaneCabecera(false);
        mostrarPane(paneContenidoListaProductos);
    }
    private void mostrarPane(Pane paneMostrar) {
        paneContenidoInicio.setVisible(false);
        paneContenidoListaProductos.setVisible(false);
        paneContenidoProductoSelec.setVisible(false);
        paneAñadirProducto.setVisible(false);
        
        paneContenidoListaTiendas.setVisible(false);
        paneContenidoTiendaSelec.setVisible(false);
        
        paneContenidoListaAlmacenes.setVisible(false);
        paneContenidoAlmacenSelec.setVisible(false);
        paneAñadirAlmacen.setVisible(false);
        
        paneMostrar.setVisible(true);
    } 
    @FXML
    private Button btnAjustes;
    //recoger el stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    private void abrirAjustes(){
        
        try {
            //System.out.println("abrirAjustes");
            //cargar modal
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vistas/ModalAjustes.fxml"));
            Parent root = fxmlLoader.load();

            
            Stage modalStage = new Stage();
            //no se puede salir del modal
            modalStage.initModality(Modality.WINDOW_MODAL.WINDOW_MODAL);
            modalStage.initOwner(stage);
            modalStage.setTitle("Ajustes");
            modalStage.setScene(new Scene(root));
            
            //mostrar el modal sin salir de inicio
            modalStage.showAndWait();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
    
    
    
    //Tabla lista productos:
    @FXML
    private TableView<Productos> tablaListaProductos;
    @FXML
    private TableColumn<Productos, String> columnIdListaProductos;
    @FXML
    private TableColumn<Productos, String> columnNombreListaProductos;
    @FXML
    private TableColumn<Productos, String> columnImgListaProductos;
    @FXML
    private TableColumn<Productos, Productos.TipoProducto> columnTipoListaProductos;
    @FXML
    private TableColumn<Productos, String> columnSubTipoListaProductos;
    @FXML
    private TableColumn<Productos, String> columnTallaListaProductos;
    @FXML
    private TableColumn<Productos, Double> columnPrecioListaProductos;
    
    
    //pg producto selec:
    @FXML
    private Text textIdProductoSelec;
    @FXML
    private Text textNombreProductoSelec;
    @FXML
    private Text textTipoProductoSelec;
    @FXML
    private Text textSubTipoProductoSelec;
    @FXML
    private Text textTallaProductoSelec;
    @FXML
    private Text textPrecioProductoSelec;
    @FXML
    private ImageView imgProductoSelec;
    
    //pg producto selec, tabla tiendas:
    @FXML
    private TableView<Tiendas> tablaTiendasProducto;
    @FXML
    private TableColumn<Tiendas, String> columnIdProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnNombreProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnTipoProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnDirProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnPaisProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelProductoSelecTiendas;
    @FXML
    private TableColumn<Tiendas, Integer> columnStockProductoSelecTiendas;
   
    @FXML
    private TableView<Almacenes> tablaAlmacenesProductoSelec;
    @FXML
    private TableColumn<Almacenes, String> columnIdAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnNombreAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnDirAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnCiudadAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnPaisAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnTelAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnHoarioAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnCapOcupadaAlmacenesSelecProducto;
    @FXML
    private TableColumn<Almacenes, String> columnCapTotalAlmacenesSelecProducto;
    
    
    
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
    
    
    
    //pg tienda selec, tabla tienda:
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
    
    //pg tienda selec, tabla productos:
    @FXML
    private TableView<Productos> tablaProductosTienda;
    @FXML
    private TableColumn<Productos, String> columnIdTiendaSelecProd;
    @FXML
    private TableColumn<Productos, String> columnNombreTiendaSelecProd;
    @FXML
    private TableColumn<Productos, String>columnImgTiendaSelecProd;
    @FXML
    private TableColumn<Productos, Productos.TipoProducto>columnTipoTiendaSelecProd;
    @FXML
    private TableColumn<Productos, String>columnSubTipoTiendaSelecProd;
    @FXML
    private TableColumn<Productos, String>columnTallaTiendaSelecProd;
    @FXML
    private TableColumn<Productos, Double>columnPrecioTiendaSelecProd;
    @FXML
    private TableColumn<Productos, Integer>columnStockTiendaSelecProd;
    
    //pg tienda selec, tabla almacenes:
    @FXML
    private TableView<Almacenes> tablaAlmacenesTienda;
    @FXML
    private TableColumn<Almacenes, String> columnIdTiendaSelecAlmac;
    @FXML
    private TableColumn<Almacenes, String> columnNombreTiendaSelecAlmac;
    @FXML
    private TableColumn<Almacenes, String> columnDirTiendaSelecAlmac;
    @FXML
    private TableColumn<Almacenes, String> columnCiudadTiendaSelecAlmac;   
    @FXML
    private TableColumn<Almacenes, String> columnPaisTiendaSelecAlmac;
    @FXML
    private TableColumn<Almacenes, Integer> columnTelTiendaSelecAlmac;
    @FXML
    private TableColumn<Almacenes, String> columnHorarioTiendaSelecAlmac;    
    @FXML
    private TableColumn<Almacenes, Integer> columnCapOcupadaTiendaSelecAlmac; 
    @FXML
    private TableColumn<Almacenes, Integer> columnCapTotalTiendaSelecAlmac;
    
    
    
    
    
    //Tabla lista almacenes:
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
    
    //pg almacen selec: elmentos
    @FXML
    private Label texIdAlmacenSelec;
    @FXML
    private Label textNombreAlmacenSelec;
    @FXML
    private Label textTelAlmacenSelec;
    @FXML
    private Label textDirAlmacenSelec;
    @FXML
    private TableView<HorarioAlmacen> tablaHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnLHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnMHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnXHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnJHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnVHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnSHorarioAlmacenSelec;
    @FXML
    private TableColumn<Almacenes, String> columnDHorarioAlmacenSelec;
    @FXML
    private Label textCiudadAlmacenSelec;
    @FXML
    private Label textPaisAlmacenSelec;
    @FXML
    private Canvas barraCapacidad;
    //? acabar barrcaCapacidad
    
    
    //pg almacen selec, tabla productos:
    @FXML
    private TableView<Productos> tablaProductosAlmacen;
    @FXML
    private TableColumn<Productos, String> columnIdProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, String> columnNombreProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, String> columnImgProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, String> columnTipoProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, String> columnSubTipoProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, String> columnTallaProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, Double> columnPrecioProductosSelecAlmacen;
    @FXML
    private TableColumn<Productos, Integer> columnStockProductosSelecAlmacen;
            
    //pg almacen selec, tabla tiendas:
    @FXML
    private TableView<Tiendas> tablaTiendasAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnIdTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnNombreTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnTipoTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnDirTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnPaisTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelTiendasSelecAlmacen;
    @FXML
    private TableColumn<Tiendas, Map> columnHorarioTiendasSelecAlmacen;
    
    
    //en productos al editar aparece:
    @FXML
    private HBox editarProductoElegirTienda;
    @FXML
    private HBox editarProductoElegirAlmacen;
    private void editarProducto(boolean b){
        editarProductoElegirTienda.setVisible(!b);
        editarProductoElegirAlmacen.setVisible(!b);
    }
    
    
    
    
    //Botones pane botonera:
    //btn añadir y sus elementos de productos:
    @FXML
    private Label labelNombreAñProducto;
    @FXML
    private ChoiceBox<Productos.TipoProducto> choiceBoxTipoAñProducto;
    @FXML
    private Label labelTipoAñProducto;
    @FXML
    private ChoiceBox choiceBoxSubTipoAñProducto;
    @FXML
    private Label labelSubTipoAñProducto;
    @FXML
    private ComboBox<Productos.TallaProducto> comboBoxTallasAñProducto;
    @FXML
    private Label labelTallaAñProducto;
    @FXML
    private ChoiceBox choiceBoxTipoPrecioAñProducto;
    @FXML
    private Label labelPrecioAñProducto;
  
   
    
    //elementos de tiendas:
    //elementos de almacenes:
    @FXML
    private TextField textNombreAñAlmacen;
    @FXML
    private Label iconoValiNombreAñAlmacen;
    @FXML
    private TextField textDirAñAlmacen;
    @FXML
    private Label iconoValiDirAñAlmacen;
    @FXML
    private ComboBox<String> comboBoxPaisAñAlmacen;
    @FXML
    private Label iconoValiPaisAñAlmacen;
    @FXML
    private ComboBox comboBoxCiudadAñAlmacen;
    @FXML
    private Label iconoValiCiudaadAñAlmacen;
    @FXML
    private TextField textTelAñAlmacen;
    @FXML
    private Label iconoValiTelAñAlmacen;
    @FXML
    private TextField textCapTotalAñAlmacen;
    @FXML
    private Label iconoValiCapTotalAñAlmacen;
    @FXML
    private TextField textIdTiendaAñAlmacen;
    @FXML
    private Label iconoValiIdTiendaAñAlmacen;
    @FXML
    private HBox tablaHorarioAñAlmacen;
    @FXML
    private Label iconoValiHorarioAñAlmacen;
    @FXML
    private TextField textAperLHorarioAñAlmacen;
    @FXML
    private TextField textCieLHorarioAñAlmacen;
    @FXML
    private TextField textAperMHorarioAñAlmacen;
    @FXML
    private TextField textCieMHorarioAñAlmacen;
    @FXML
    private TextField textAperXHorarioAñAlmacen;
    @FXML
    private TextField textCieXHorarioAñAlmacen;
    @FXML
    private TextField textAperJHorarioAñAlmacen;
    @FXML
    private TextField textCieJHorarioAñAlmacen;
    @FXML
    private TextField textAperVHorarioAñAlmacen;
    @FXML
    private TextField textCieVHorarioAñAlmacen;
    @FXML
    private TextField textAperSHorarioAñAlmacen;
    @FXML
    private TextField textCieSHorarioAñAlmacen;
    @FXML
    private TextField textAperDHorarioAñAlmacen;
    @FXML
    private TextField textCieDHorarioAñAlmacen;
    @FXML
    private void añadir(){
        limpiarPaneAñAlmacen();
        //tablaListaAlmacenes.getSelectionModel().clearSelection();

        if (paneContenidoListaProductos.isVisible() || paneContenidoProductoSelec.isVisible()) {
            mostrarPane(paneAñadirProducto);
            
            ObservableList<Productos.TipoProducto> opcTipo = FXCollections.observableArrayList(Productos.TipoProducto.values());
            ObservableList<Productos.TallaProducto> opcTalla = FXCollections.observableArrayList(Productos.TallaProducto.values());
            choiceBoxTipoAñProducto.setItems(opcTipo);
            
            choiceBoxTipoAñProducto.setOnAction((event) -> {
                if (choiceBoxTipoAñProducto.getValue() == Productos.TipoProducto.Ropa) {
                    ObservableList<Productos.SubTipoRopaProducto> ropaOpciones = FXCollections.observableArrayList(Productos.SubTipoRopaProducto.values());
                    choiceBoxSubTipoAñProducto.setItems(ropaOpciones);
                    choiceBoxSubTipoAñProducto.setDisable(false);
                    
                    //labelTipoAñProducto.setText("Ropa");
                } else if (choiceBoxTipoAñProducto.getValue() == Productos.TipoProducto.Accesorios) {
                    ObservableList<Productos.SubTipoAccProducto> accesoriosOpciones = FXCollections.observableArrayList(Productos.SubTipoAccProducto.values());
                    choiceBoxSubTipoAñProducto.setItems(accesoriosOpciones);
                    choiceBoxSubTipoAñProducto.setDisable(false);
                    
                    //labelTipoAñProducto.setText("Accesorios");
                } else {
                    choiceBoxSubTipoAñProducto.setItems(FXCollections.observableArrayList());
                    labelTipoAñProducto.setText("Zapatillas");
                }
                //labelSubTipoAñProducto.setText(choiceBoxSubTipoAñProducto.getValue().toString());

            });
            choiceBoxSubTipoAñProducto.setDisable(true);
            comboBoxTallasAñProducto.setItems(opcTalla);
            
            choiceBoxTipoPrecioAñProducto.getItems().addAll("€", "£");
            choiceBoxTipoPrecioAñProducto.getSelectionModel().selectFirst();
            
        }else if (paneContenidoListaTiendas.isVisible() || paneContenidoTiendaSelec.isVisible()){
            
        }else if (paneContenidoListaAlmacenes.isVisible() || paneContenidoAlmacenSelec.isVisible()){
            mostrarPane(paneAñadirAlmacen);
            footerAñAlmacen.setVisible(true);
            footerEdAlmacen.setVisible(false);
            
            comboBoxCiudadAñAlmacen.getItems().addAll(ciudadesEspaña);
            comboBoxCiudadAñAlmacen.getSelectionModel().selectFirst();
            comboBoxPaisAñAlmacen.getItems().addAll(paisesEu);
            comboBoxPaisAñAlmacen.getSelectionModel().selectFirst();
            
            
            comprobarValidacionesAñAlmacen();
            
        }
        
    }
    
    //Recoger todo el horario:
    private Map<String, String> obtenerHorarioDia(TextField aperturaField, TextField cierreField) {
        //LinkedHashMap mejor q map porque este mantiene el orden
        Map<String, String> horarioDia = new LinkedHashMap<>();

        String apertura = aperturaField.getText();
        String cierre = cierreField.getText();

        if (aperturaField.getText().isEmpty()) {
            apertura = "cerrado";
        }
        if (cierreField.getText().isEmpty()) {
            cierre = "cerrado";
        }

        horarioDia.put("apertura", apertura);
        horarioDia.put("cierre", cierre);

        return horarioDia;
    }
    private Map<String, Map<String, String>> recogerHorario(){
        Map<String, Map<String, String>> horario = new LinkedHashMap<>();
  
        horario.put("lunes", obtenerHorarioDia(textAperLHorarioAñAlmacen, textCieLHorarioAñAlmacen));
        horario.put("martes", obtenerHorarioDia(textAperMHorarioAñAlmacen, textCieMHorarioAñAlmacen));
        horario.put("miércoles", obtenerHorarioDia(textAperXHorarioAñAlmacen, textCieXHorarioAñAlmacen));
        horario.put("jueves", obtenerHorarioDia(textAperJHorarioAñAlmacen, textCieJHorarioAñAlmacen));
        horario.put("viernes", obtenerHorarioDia(textAperVHorarioAñAlmacen, textCieVHorarioAñAlmacen));
        horario.put("sábado", obtenerHorarioDia(textAperSHorarioAñAlmacen, textCieSHorarioAñAlmacen));
        horario.put("domingo", obtenerHorarioDia(textAperDHorarioAñAlmacen, textCieDHorarioAñAlmacen));

        return horario;
    }
    
    
    @FXML
    private void aceptarAñAlmacen(){
        System.out.println("Almacen añadido");
       
        String nombreAlmacen = textNombreAñAlmacen.getText();
        String dirAlmacen = textDirAñAlmacen.getText();
        String ciudadAlmacen = comboBoxCiudadAñAlmacen.getValue().toString();
        String paisAlmacen = comboBoxPaisAñAlmacen.getValue().toString();
        String telefonoAlmacenS = textTelAñAlmacen.getText();
        String capacidadTotalAlmacenS = textCapTotalAñAlmacen.getText();
        String idTiendaAlmacen = textIdTiendaAñAlmacen.getText();
        Map<String, Map<String, String>> horario = recogerHorario();
        
        int telefonoAlmacen = Integer.parseInt(telefonoAlmacenS);
        int capacidadTotalAlmacen = Integer.parseInt(capacidadTotalAlmacenS);
        System.out.println("-- aceptarAñAlmacen");
        
        if(comprobarDatosAlmacen()){
            System.out.println("-- aceptarAñAlmacen -- comprobarDatosAlmacen");
            añadirAlmacen(nombreAlmacen, dirAlmacen, ciudadAlmacen, paisAlmacen, telefonoAlmacen, horario, capacidadTotalAlmacen, idTiendaAlmacen);
            limpiarPaneAñAlmacen();
        }
       
    }
    @FXML
    private void cancelarAñAlmacen(){
        mostrarPane(paneContenidoListaAlmacenes);
        limpiarPaneAñAlmacen();
    }
    private void limpiarPaneAñAlmacen() {
        tablaListaAlmacenes.getSelectionModel().clearSelection();
        textNombreAñAlmacen.clear();
        textDirAñAlmacen.clear();
        comboBoxPaisAñAlmacen.getSelectionModel().clearSelection();
        comboBoxCiudadAñAlmacen.getSelectionModel().clearSelection();
        textTelAñAlmacen.clear();
        textCapTotalAñAlmacen.clear();
        textIdTiendaAñAlmacen.clear();

        textAperLHorarioAñAlmacen.clear();
        textCieLHorarioAñAlmacen.clear();
        textAperMHorarioAñAlmacen.clear();
        textCieMHorarioAñAlmacen.clear();
        textAperXHorarioAñAlmacen.clear();
        textCieXHorarioAñAlmacen.clear();
        textAperJHorarioAñAlmacen.clear();
        textCieJHorarioAñAlmacen.clear();
        textAperVHorarioAñAlmacen.clear();
        textCieVHorarioAñAlmacen.clear();
        textAperSHorarioAñAlmacen.clear();
        textCieSHorarioAñAlmacen.clear();
        textAperDHorarioAñAlmacen.clear();
        textCieDHorarioAñAlmacen.clear();
    }

    
    
    
    @FXML
    private HBox footerModificarProductoSelect;
    @FXML
    private TabPane tabPaneProductos;
    @FXML
    private HBox footerAñAlmacen;
    @FXML
    private HBox footerEdAlmacen;
    private String idObjSelecEd;
    @FXML
    public void editar(){
        
        ObservableList<Productos> productos = darListaProductos();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        ObservableList<Almacenes> almacenes = darListaAlmacenes();
        
        if(tablaListaProductos.getSelectionModel().getSelectedItem() != null){
           
           //cambiar vista de pg productos para elegir su tienda y almacen enlazados
           tabPaneProductos.setPrefHeight(330);
           footerModificarProductoSelect.setVisible(true);
            
           Productos productoSelec = tablaListaProductos.getSelectionModel().getSelectedItem();
           String id = productoSelec.getId_producto();
           System.out.println("ver seleccion-- "+ productoSelec.getId_producto());
            for (int i = 0; i < productos.size(); i++) {
                Productos producto = productos.get(i);

                if (id == producto.getId_producto()) {

                    mostrarPane(paneContenidoProductoSelec);
                    editarProducto(true);
                } 
            }
        } else if (tablaListaTiendas.getSelectionModel().getSelectedItem() != null){
        /*
            for (int i = 0; i < tiendas.size(); i++) {
                Tiendas tienda = tiendas.get(i);
                
                if (id == tienda.getId_tienda()) {

                    mostrarPane(paneContenidoProductoSelec);
                } 
            }
            */
        }else if(tablaListaAlmacenes.getSelectionModel().getSelectedItem() != null){
            
            Almacenes almacenSelec = tablaListaAlmacenes.getSelectionModel().getSelectedItem();
            
            mostrarPane(paneAñadirAlmacen);
            footerAñAlmacen.setVisible(false);
            footerAñAlmacen.setPrefHeight(0);
            footerEdAlmacen.setVisible(true);
            
            idObjSelecEd = almacenSelec.getId_almacen();
            System.out.println("almacenSelec idAlam"+idObjSelecEd);
            
            textNombreAñAlmacen.setText(almacenSelec.getNombre());
            textDirAñAlmacen.setText(almacenSelec.getDireccion());
            comboBoxPaisAñAlmacen.setValue(almacenSelec.getPais());
            comboBoxCiudadAñAlmacen.setValue(almacenSelec.getCiudad());
            textTelAñAlmacen.setText(Integer.toString(almacenSelec.getTelefono()));
            textCapTotalAñAlmacen.setText(Integer.toString(almacenSelec.getCapacidad_total()));
            textIdTiendaAñAlmacen.setText(almacenSelec.getId_tienda());
            
            //? mostrar el horario real
            textAperLHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieLHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperMHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieMHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperXHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieXHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperJHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieJHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperVHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieVHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperSHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieSHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textAperDHorarioAñAlmacen.setText(almacenSelec.getNombre());
            textCieDHorarioAñAlmacen.setText(almacenSelec.getNombre());
            
        }

    }
    @FXML
    private void aceptarEdAlmacen(){
        String idAlmacenSelec = idObjSelecEd;
        String nombreAlmacen = textNombreAñAlmacen.getText();
        String dirAlmacen = textDirAñAlmacen.getText();
        String ciudadAlmacen = comboBoxCiudadAñAlmacen.getValue().toString();
        String paisAlmacen = comboBoxPaisAñAlmacen.getValue().toString();
        int telefonoAlmacen = Integer.parseInt(textTelAñAlmacen.getText());
        int capacidadTotalAlmacen = Integer.parseInt(textCapTotalAñAlmacen.getText());
        String idTiendaAlmacen = textIdTiendaAñAlmacen.getText();
        Map<String, Map<String, String>> horario = recogerHorario();
        

        editarAlmacen(idAlmacenSelec,nombreAlmacen, dirAlmacen, ciudadAlmacen, paisAlmacen, telefonoAlmacen, horario, capacidadTotalAlmacen, idTiendaAlmacen);
        
        limpiarPaneAñAlmacen();
    }
    @FXML
    private void cancelarEdAlmacen(){
        mostrarPane(paneContenidoListaAlmacenes);
        limpiarPaneAñAlmacen();
    }
            
    @FXML
    private void actualizar(){
        
        if (paneContenidoListaProductos.isVisible()) {
            ObservableList<Productos> productosActualizados = darListaProductos();
            
            if (productosActualizados != null && !productosActualizados.isEmpty()) {
                tablaListaProductos.setItems(productosActualizados);
                tablaListaProductos.refresh();
                System.out.println("Tabla de almacenes actualizada");
            } 
            
        }else if (paneContenidoListaTiendas.isVisible()) {
            ObservableList<Tiendas> tiendasActualizadas = darListaTiendas();
            
            if (tiendasActualizadas != null && !tiendasActualizadas.isEmpty()) {
                tablaListaTiendas.setItems(tiendasActualizadas);
                tablaListaTiendas.refresh();
                System.out.println("Tabla de almacenes actualizada");
            } 
            
        } else if (paneContenidoListaAlmacenes.isVisible()) {
            ObservableList<Almacenes> almacenesActualizados = darListaAlmacenes();
            
            if (almacenesActualizados != null && !almacenesActualizados.isEmpty()) {
                tablaListaAlmacenes.setItems(almacenesActualizados);
                tablaListaAlmacenes.refresh();
                System.out.println("Tabla de almacenes actualizada");
            } 
        }
    }
            
    @FXML
    private void borrar(){
        ObservableList<Productos> productos = darListaProductos();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        ObservableList<Almacenes> almacenes = darListaAlmacenes();
        
        //? poner mensaje para asegurarse de que se quiere borrar
        
        if(tablaListaProductos.getSelectionModel().getSelectedItem() != null){
            //mostrarModalAlerta(tablaListaProductos.getSelectionModel().getSelectedItem());
        
        } else if(tablaListaTiendas.getSelectionModel().getSelectedItem() != null){
            Tiendas tiendaSelec = tablaListaTiendas.getSelectionModel().getSelectedItem();
            String idTienda = tiendaSelec.getId_tienda();

            boolean eliminado = borrarTienda(idTienda);

            if (eliminado) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "La tienda ha sido borrada");
                actualizar();
            } 
            
        } else if(tablaListaAlmacenes.getSelectionModel().getSelectedItem() != null){
            Almacenes almacenSelec = tablaListaAlmacenes.getSelectionModel().getSelectedItem();
            String idAlmacen = almacenSelec.getId_almacen();

            boolean eliminado = borrarAlmacen(idAlmacen);

            if (eliminado) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "El almacén ha sido borrado");
                actualizar();
            } 
        }
    }
    /*
    private void mostrarModalAlerta(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    // Establecer el título y el mensaje del modal
    alert.setTitle("Confirmar Operacion");
    alert.setHeaderText("¿seguro quieres conformar?");
    
    Button btnYes = new Button("Aceptar");
    Button btnNo = new Button("Cancelar");

    Scene scene = new Scene(vbox, 300, 150);
    modalStage.setScene(scene);

    // Mostrar el modal y esperar la respuesta
    modalStage.showAndWait();
    }
    */
    
    
    @FXML
    private void verSeleccion() {
       
        if (tablaListaProductos.getSelectionModel().getSelectedItem() != null){
            Productos productoSelec = tablaListaProductos.getSelectionModel().getSelectedItem();
            var almacenProductoSelec = productoSelec.getId_almacen();
            mostrarPane(paneContenidoProductoSelec);
            visiblePaneCabecera(true);

            System.out.println("producto Selec id-- " + productoSelec.getId_producto());
            rellenarProductoSelec(productoSelec);
            rellenarTiendasProductoSelec(productoSelec.getId_producto());
            rellenarAlmacenesProductoSelec(almacenProductoSelec);

            tablaListaProductos.getSelectionModel().clearSelection();
                    
        }else if (tablaListaTiendas.getSelectionModel().getSelectedItem() != null){
            Tiendas tiendaSelec = tablaListaTiendas.getSelectionModel().getSelectedItem();
            mostrarPane(paneContenidoTiendaSelec);
            visiblePaneCabecera(true);
            
            System.out.println("tiendaSelec id-- " + tiendaSelec.getId_tienda());
            rellenarTablaTiendaSelec(tiendaSelec);
            rellenarProductosTiendaSelec(tiendaSelec.getId_tienda());
            rellenarAlmacenesTiendaSelec(tiendaSelec.getId_tienda());
            
            tablaListaTiendas.getSelectionModel().clearSelection();
            
        }else if (tablaListaAlmacenes.getSelectionModel().getSelectedItem() != null){
            Almacenes almacenSelec = tablaListaAlmacenes.getSelectionModel().getSelectedItem();
            var tiendaAlmacenSelec = almacenSelec.getId_tienda();
            mostrarPane(paneContenidoAlmacenSelec);
            visiblePaneCabecera(true);
            
            System.out.println("almacen selec -- " + almacenSelec.getId_almacen());
            rellenarAlmacenSelec(almacenSelec);
            rellenarProductosAlmacenSelec(almacenSelec.getId_almacen());
            rellenarTiendasAlmacenSelec(tiendaAlmacenSelec);
            
            tablaListaAlmacenes.getSelectionModel().clearSelection();
        }
       
    }  
    
    
    //pg producto selec:
    private void rellenarProductoSelec(Productos productoSelec){
        textIdProductoSelec.setText(productoSelec.getId_producto());
        textNombreProductoSelec.setText(productoSelec.getNombre());
        textTipoProductoSelec.setText(productoSelec.getTipo().name());
        
        textSubTipoProductoSelec.setText(productoSelec.recogerSubTipo());
        textTallaProductoSelec.setText(productoSelec.recogerTallas());
        
        textPrecioProductoSelec.setText(String.format("%.2f €", productoSelec.getPrecio()));
        
        cargarImagen(productoSelec.getImagen(), imgProductoSelec);
    }
    //? pasar a modelos??
    public Object contenerProducto(String idProducto) {
        ObservableList<Productos> productos = darListaProductos();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        ObservableList<Almacenes> almacenes = darListaAlmacenes();
        
        for(Productos producto : productos){
            if(producto.getId_producto().equals(idProducto)){
                //System.out.println("idProducto contenerr---"+ producto);
                
                for (Tiendas tienda : tiendas){
                    var idTienda = tienda.getId_tienda();
                    
                    if(producto.getId_tienda().equals(idTienda)){
                        return tienda;
                    }
                }
                
                
                for (Almacenes almacen : almacenes){
                    var idAlmacen = almacen.getId_tienda();
                    
                    if(producto.getId_tienda().equals(idAlmacen)){
                        return almacen;
                    }
                }
            }
        }
        
        return null;
               
    }
    private void rellenarTiendasProductoSelec(String idProducto){
        listaTiendas.clear();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        
        for (int i = 0; i < tiendas.size(); i++) {
            Tiendas tienda = tiendas.get(i);
            
            contenerProducto(idProducto);
            listaTiendas.add(tienda);
            //System.err.println("contenerProducto----"+contenerProducto(idProducto));
           
        }   
        
        columnIdProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("id_tienda"));
        columnNombreProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTipoProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDirProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        //? stock del producto en tienda:
        //columnStockProductoSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaTiendasProducto.setItems(listaTiendas);

    }
    private void rellenarAlmacenesProductoSelec(String idProducto){
        listaAlmacenes.clear();
        ObservableList<Almacenes> almacenes = darListaAlmacenes();

        for (int i = 0; i < almacenes.size(); i++) {
            Almacenes almacen = almacenes.get(i);
            
            contenerProducto(idProducto);
            listaAlmacenes.add(almacen); 
        }

        columnIdAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("id_almacen"));
        columnNombreAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDirAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnHoarioAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("horario"));
        columnCapOcupadaAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("capacidad_ocupada"));
        columnCapTotalAlmacenesSelecProducto.setCellValueFactory(new PropertyValueFactory<>("capacidad_total"));

        tablaAlmacenesProductoSelec.setItems(listaAlmacenes);
    }
    //para buscar la img
    public void cargarImagen(String imagenNombre, ImageView imgProductoSelec) {
        
        if (imagenNombre != null && !imagenNombre.isEmpty()) {
            String rutaCarpeta = "src/main/resources/assets/";
            String rutaImagen = rutaCarpeta + imagenNombre;

            File imagenArchivo = new File(rutaImagen);
            if (imagenArchivo.exists() && imagenArchivo.isFile()) {
                
                try {
                    Image image = new Image(imagenArchivo.toURI().toString());
                    imgProductoSelec.setImage(image);
                    
                } catch (Exception e) {
                    System.out.println("Error al cargar la imagen");
                    imgProductoSelec.setImage(null);
                }
                
            } else {
                imgProductoSelec.setImage(null);
            }
            
        } else {
            imgProductoSelec.setImage(null);
            //? poner texto para indicar q no hay nada
        }
    }
    
    
    //pg tienda selec:
    private void rellenarTablaTiendaSelec(Tiendas tiendaSelec){
        ObservableList<Tiendas> listaTiendaSelec = FXCollections.observableArrayList();
        listaTiendaSelec.add(tiendaSelec); 
        
        tablaTiendaSelec.setItems(listaTiendaSelec);

        columnIdTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("id_tienda"));
        columnNombreTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnCiudadTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDirTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnHorarioTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("horario"));
        columnPaisTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnTipoTiendaSelec.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    }
    private void rellenarProductosTiendaSelec(String idTienda) {
        listaProductos.clear();
        ObservableList<Productos> productos = darListaProductos();
        
        for (int i = 0; i < productos.size(); i++) {
            Productos producto = productos.get(i);
            if (producto.getId_tienda().equals(idTienda)) {
                listaProductos.add(producto);
            }
        }
        
        columnIdTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columnNombreTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnImgTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        columnTipoTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnSubTipoTiendaSelecProd.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerSubTipo()));
        columnTallaTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("talla"));
        columnPrecioTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnStockTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaProductosTienda.setItems(listaProductos);
    }
    private void rellenarAlmacenesTiendaSelec(String idTienda) {
        listaAlmacenes.clear();
        ObservableList<Almacenes> almacenes = darListaAlmacenes();
        
        for (int i = 0; i < almacenes.size(); i++) {
            Almacenes almacen = almacenes.get(i);
            if (almacen.getId_tienda().equals(idTienda)) {
                listaAlmacenes.add(almacen);
            }
        }
        
        columnIdTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("id_almacen"));
        columnNombreTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnDirTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnHorarioTiendaSelecAlmac.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerHorario()));
        columnCapOcupadaTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("capacidad_ocupada"));
        columnCapTotalTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("capacidad_total"));

        
        tablaAlmacenesTienda.setItems(listaAlmacenes);
    }
    
    
    //pg almacen selec:
    private void rellenarAlmacenSelec(Almacenes almacenSelec){
        texIdAlmacenSelec.setText(almacenSelec.getId_almacen());
        textNombreAlmacenSelec.setText(almacenSelec.getNombre());
        textDirAlmacenSelec.setText(almacenSelec.getDireccion());
        textTelAlmacenSelec.setText(Integer.toString(almacenSelec.getTelefono()));
        textCiudadAlmacenSelec.setText(almacenSelec.getCiudad());
        textPaisAlmacenSelec.setText(almacenSelec.getPais());
        
        //para el horario:
        Map<String, Map<String, String>> horarios = new LinkedHashMap<>();
        Map<String, String> horarioL = new LinkedHashMap<>();
        String sumHorarioL = horarioL.get("apertura")+" : "+horarioL.get("cierre");
        //horarios.get("lunes").get("apertura");
        System.out.println("horario "+sumHorarioL);

        HorarioAlmacen horario = new HorarioAlmacen(horarios);
        ObservableList<HorarioAlmacen> listaHorarios = FXCollections.observableArrayList();
        listaHorarios.add(horario);

        columnLHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("lunes"));
        columnMHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("martes"));
        columnXHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("miercoles"));
        columnJHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("jueves"));
        columnVHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("viernes"));
        columnSHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("sabado"));
        columnDHorarioAlmacenSelec.setCellValueFactory(new PropertyValueFactory<>("domingo"));

        tablaHorarioAlmacenSelec.setItems(listaHorarios);
    }
    private void rellenarProductosAlmacenSelec(String idAlmacen){
        listaProductos.clear();
        ObservableList<Productos> productos = darListaProductos();

        for (int i = 0; i < productos.size(); i++) {
            Productos producto = productos.get(i);
            
            if (producto.getId_almacen().equals(idAlmacen)) {
                listaProductos.add(producto);
                //System.out.println("2productos de almacen "+producto.getId_producto());
            }
        }

        columnIdProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columnNombreProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnImgProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        columnTipoProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnSubTipoProductosSelecAlmacen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerSubTipo()));
        columnTallaProductosSelecAlmacen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerTallas()));
        columnPrecioProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnStockProductosSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("stock"));

        
        tablaProductosAlmacen.setItems(listaProductos);
    }
    private void rellenarTiendasAlmacenSelec(String idTienda){
        listaTiendas.clear();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        System.out.println("Almacen selec, id TIENDA -- " + idTienda);

        for (int i = 0; i < tiendas.size(); i++) {
            Tiendas tienda = tiendas.get(i);
            if (tienda.getId_tienda().equals(idTienda)) {
                listaTiendas.add(tienda);
                //System.out.println("cc -- " + tienda.getId_tienda());
            }
        }
        //System.out.println("Num tiendas añadidas: " + listaTiendas.size());

        columnIdTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("id_tienda"));
        columnNombreTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTipoTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDirTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnHorarioTiendasSelecAlmacen.setCellValueFactory(new PropertyValueFactory<>("horario"));
        

        tablaTiendasAlmacen.setItems(listaTiendas);tablaTiendasAlmacen.refresh();
    }

    
    
    
    //decodificar img base 64
    //private 
    

    
    
    
    //recoger texto para cambio idioma
    @FXML
    private ComboBox<String> btnCambioIdioma;
    private void cargarIdiomas(String idioma){
        
        if (idioma.equals("en")) {
            rb = ResourceBundle.getBundle("messages", new java.util.Locale("en", "US"));
        } else {
            rb = ResourceBundle.getBundle("messages", new java.util.Locale("es", "ES"));
        }

        ponerTextos();
    }
    @FXML
    private void cambiarIdioma() {
        
        String idiomaSelec = btnCambioIdioma.getValue();
        
        if ("Español".equals(idiomaSelec)) {
            cargarIdiomas("es");
        } else if ("English".equals(idiomaSelec)) {
            cargarIdiomas("en");
        }
    }
    private void ponerTextos(){
        //? acabar d eponer los textos para idiomas
        btnTablero.setText(rb.getString("btnTablero"));
        btnProductos.setText(rb.getString("btnProductos"));
        btnTiendas.setText(rb.getString("btnTiendas"));
        btnAlmacenes.setText(rb.getString("btnAlmacenes"));
        btnAjustes.setText(rb.getString("btnAjustes"));

    }
    
    
    //poner para que desde el incio salga paneContenidoInicio
    private void setearPaneInicio(){
        quitarPaneCabecera(true);
        mostrarPane(paneContenidoInicio);
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cargar los idiomas
        btnCambioIdioma.getItems().addAll("Español", "English");
        btnCambioIdioma.setValue("Español"); 
        btnCambioIdioma.setOnAction(e -> cambiarIdioma());
        
        setearPaneInicio();
        
       
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
                ObservableList<Productos> listaP = darListaProductos();
                ObservableList<Tiendas> listaT = darListaTiendas();
                ObservableList<Almacenes> listaA = darListaAlmacenes();
                
                
                //mostrar solo los productos con el mismo id_Producto
                Set<String> mapeoListaP = new HashSet<>();
                ObservableList<Productos> nuevaListaP = FXCollections.observableArrayList();
                for(Productos producto : listaP){
                    
                    if(!mapeoListaP.contains(producto.getId_producto())){
                        mapeoListaP.add(producto.getId_producto());
                        nuevaListaP.add(producto);
                    }
                }
                
                
                columnIdListaProductos.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
                columnNombreListaProductos.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                columnImgListaProductos.setCellValueFactory(new PropertyValueFactory<>("imagen"));
                columnTipoListaProductos.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                columnSubTipoListaProductos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerSubTipo()));
                columnTallaListaProductos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().recogerTallas()));
                columnPrecioListaProductos.setCellValueFactory(new PropertyValueFactory<>("precio"));
                
                tablaListaProductos.setItems(nuevaListaP);
                
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
                
            } catch (ExceptionInInitializerError e) {
                e.printStackTrace();
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se han podido recoger los datos");
                alert.showAndWait();
            }
        }   
    }
    
   //llamada a las listas:
    private ObservableList<Productos> darListaProductos(){
        ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
        
        if (conexion != null) {
            String query = "SELECT * FROM productos";
            try {
                rs = st.executeQuery(query);
                while (rs.next()) {
                    //convertir el enum a string
                    Productos.TipoProducto tipo = Productos.TipoProducto.valueOf(rs.getString("tipo"));
                    Productos.SubTipoRopaProducto subtipo_ropa = null;
                    Productos.SubTipoAccProducto subtipo_accesorios = null;
                    
                    if (tipo == Productos.TipoProducto.Ropa && rs.getString("subtipo_ropa") != null) {
                        String subTipoRopaString = rs.getString("subtipo_ropa").trim().replace(" ", "_");
                        subtipo_ropa = Productos.SubTipoRopaProducto.valueOf(subTipoRopaString);
                    }
                    
                    if (tipo == Productos.TipoProducto.Accesorios && rs.getString("subtipo_accesorios") != null) {
                        String subtipoAccString = rs.getString("subtipo_accesorios").trim().replace(" ", "_");
                        subtipo_accesorios = Productos.SubTipoAccProducto.valueOf(subtipoAccString);
                    }
                    
                    Set<Productos.TallaProducto> tallas = new HashSet<>();
                    String tallaString = rs.getString("talla");
                    if (tallaString != null && !tallaString.isEmpty()) {
                    //las tallas estan separadas por, 
                    String[] tallaArray = tallaString.split(",");
                    for (int i = 0; i < tallaArray.length; i++){
                        String t = tallaArray[i];
                        
                        try {
                            tallas.add(Productos.TallaProducto.fromString(t.trim()));
                        } catch (IllegalArgumentException e) {
                            
                           
                        }
                    }
                    
                    Productos producto = new Productos(
                        rs.getString("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("imagen"),
                        tipo,
                        subtipo_ropa,
                        subtipo_accesorios,
                        tallas,
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("id_tienda"),
                        rs.getString("id_almacen")
                    );
                    
                 

                        //System.out.println("id producto -- "+ producto.getId_producto());
                    listaProductos.add(producto);
                    
                    
                }}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaProductos;
    }
    
    private ObservableList<Tiendas> darListaTiendas(){
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
                    Map<String, Map<String, String>> horarioMap = null;
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
                    
                    //? ajustar para recoger el horario bien
                    //String horarioTexto = tienda.recogerHorario();
                    
                    listaTiendas.add(tienda);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaTiendas;
    }
    
    private ObservableList<Almacenes> darListaAlmacenes(){
        ObservableList<Almacenes> listaAlmacenes = FXCollections.observableArrayList();
        
        if (conexion != null) {
            String query = "SELECT * FROM almacenes";
            try {
                rs = st.executeQuery(query);
                while (rs.next()) {
                    
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
    
    
    
    //CRUD en bd: añadir, editar/update y borrar
    //comporbar el ultimo id de las tabalas
    private String obtenerUltimoId(String tabla, String columnaId) {
        String ultimoId = null;

        if (conexion != null) {
            
            String query = "SELECT " + columnaId + " FROM " + tabla + " ORDER BY " + columnaId + " DESC LIMIT 1";
            try {
                rs = st.executeQuery(query);
                if (rs.next()) {
                    ultimoId = rs.getString(columnaId);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String prefijo = "";
        
        if (ultimoId != null && !ultimoId.isEmpty()) {
            
            prefijo = ultimoId.substring(0, 1);

            String numeroStr = ultimoId.substring(1);
            int numero = Integer.parseInt(numeroStr);

            numero++;
            return String.format("%s%03d", prefijo, numero);
        }

        switch (tabla.toLowerCase()) {
            case "almacenes":
                prefijo = "A";
                break;
            case "productos":
                prefijo = "P";
                break;
            case "tiendas":
                prefijo = "T";
                break;
            default:
                throw new IllegalArgumentException("No se ha generado id");
        }

        return String.format("%s001", prefijo);
    }
    
    private boolean borrarTienda(String idTienda) {
        if (conexion != null) {
            String query = "DELETE FROM tiendas WHERE id_tienda = ?";

            try {

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, idTienda);

                int filaBorrada = ps.executeUpdate();

                if (filaBorrada > 0) {
                    System.out.println("Tienda borrada");
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Operacion exitosa", "Has eliminado la tienda!");
                }
                
            } catch (SQLException e) {
                System.err.println("--error borrar tienda: " + e.getMessage());
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido borrar la tienda" + e.getMessage());
            }
        }
        return false;
    }


    private void añadirAlmacen(String nombre, String direccion, String ciudad, String pais, int telefono, 
                           Map<String, Map<String, String>> horario, int capacidadTotal, String idTienda) {
        if (conexion != null) {
            //valores por defecto
            String nuevoIdAlmacen = obtenerUltimoId("almacenes", "id_almacen");
            int capacidadOcupada = 0;
            
            String query = "INSERT INTO almacenes (id_almacen, nombre, direccion, ciudad, pais, telefono, horario, capacidad_ocupada, capacidad_total, id_tienda) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            try {
                //convertir el mapa de horario a JSON
                String horarioJson = null;
                if (horario != null && !horario.isEmpty()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    horarioJson = objectMapper.writeValueAsString(horario);
                }

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, nuevoIdAlmacen);
                ps.setString(2, nombre);
                ps.setString(3, direccion);
                ps.setString(4, ciudad);
                ps.setString(5, pais);
                ps.setInt(6, telefono);
                ps.setString(7, horarioJson);
                ps.setInt(8, capacidadOcupada);
                ps.setInt(9, capacidadTotal);
                ps.setString(10, idTienda);

                int rowsInserted = ps.executeUpdate();

                //? cambiar texto segun idioma
                if (rowsInserted > 0) {
                    System.out.println("Almacen añadido!");
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Operacion exitosa", "Almacen añadido! :)");
                } else {
                    System.err.println("No se ha añadido el almacen");
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido añadir el almacen :(");
                }
                
            } catch (SQLException | JsonProcessingException e) {
                System.err.println("--error añadir almacen: " + e.getMessage());
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido añadir el almacen, revisa los campos" + e.getMessage());
            }
            
        } else {
            System.err.println("No se pudo conectar a la base de datos");
        }
    }
    private void editarAlmacen(String idAlmacen, String nombre, String direccion, String ciudad, String pais, int telefono, 
                           Map<String, Map<String, String>> horario, int capacidadTotal, String idTienda) {
        if (conexion != null) {
      
            String query = "UPDATE almacenes SET nombre = ?, direccion = ?, ciudad = ?, pais = ?, telefono = ?, horario = ?, capacidad_total = ?, id_tienda = ? WHERE id_almacen = ? ";
            
            try {
                //convertir el mapa de horario a JSON
                String horarioJson = null;
                if (horario != null && !horario.isEmpty()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    horarioJson = objectMapper.writeValueAsString(horario);
                }

                PreparedStatement ps = conexion.prepareStatement(query);

                ps.setString(1, nombre);
                ps.setString(2, direccion);
                ps.setString(3, ciudad);
                ps.setString(4, pais);
                ps.setInt(5, telefono);
                ps.setString(6, horarioJson);
                ps.setInt(7, capacidadTotal);
                ps.setString(8, idTienda);
                ps.setString(9, idAlmacen);

                int rowsInserted = ps.executeUpdate();

                //? cambiar texto segun idioma
                if (rowsInserted > 0) {
                    System.out.println("Almacen editado!");
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Operacion exitosa", "Almacen editado! :)");
                } else {
                    System.err.println("No se ha añadido el almacen");
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido editar el almacen :(");
                }
                
            } catch (SQLException | JsonProcessingException e) {
                System.err.println("--error añadir almacen: " + e.getMessage());
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido editar el almacen, revisa los campos" + e.getMessage());
            }
            
        } else {
            System.err.println("No se pudo conectar a la base de datos");
        }
    }
    private boolean borrarAlmacen(String idAlmacen) {
        if (conexion != null) {
            String query = "DELETE FROM almacenes WHERE id_almacen = ?";

            try {

                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setString(1, idAlmacen);

                int filaBorrada = ps.executeUpdate();

                if (filaBorrada > 0) {
                    System.out.println("Almacén eliminado correctamente.");
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Operacion exitosa", "Has eliminado el almacen!");
                }
                
            } catch (SQLException e) {
                System.err.println("--error borrar almacén: " + e.getMessage());
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se ha podido eliminar el almacen" + e.getMessage());
            }
        }
        return false;
    }


    //Alerta para informar al usuario
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensaje);
        alerta.showAndWait();
    }
    
    
    ArrayList<ValidationSupport> validadores;
    //Validaciones:
    public ImageView usarIcono(boolean valido){
        ImageView iconoOk = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("iconos/ok_icon.png")));
        ImageView iconoError = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("iconos/error_icon.png")));
        iconoOk.setFitHeight(16);
        iconoOk.setFitWidth(16);
        iconoError.setFitHeight(16);
        iconoError.setFitWidth(16);
        
        if (valido) {
            return iconoOk;
        } else {
            return iconoError;
        }
    }

    public void comprobarValidacionesAñAlmacen(){
    
        GraphicValidationDecoration decorador = new GraphicValidationDecoration() {
            @Override
            public void applyValidationDecoration(ValidationMessage message) {
                super.applyValidationDecoration(message);
                System.out.println("Mensaje:" + message);
                if (message.getSeverity() == Severity.ERROR || message.getSeverity() == Severity.WARNING) {
                   
                    // Añadir almacen
                    iconoValiNombreAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiDirAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiPaisAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiCiudaadAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiTelAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiCapTotalAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiIdTiendaAñAlmacen.setGraphic(usarIcono(false));
                    iconoValiHorarioAñAlmacen.setGraphic(usarIcono(false));
                    
                    
                           
                    
                } else if (message.getSeverity() == Severity.INFO) {
              
                    // Añadir almacen
                    iconoValiNombreAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiDirAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiPaisAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiCiudaadAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiTelAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiCapTotalAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiIdTiendaAñAlmacen.setGraphic(usarIcono(true));
                    iconoValiHorarioAñAlmacen.setGraphic(usarIcono(true));
                }
            }
        };
               
        
        
        ValidationSupport nombreAl = new ValidationSupport();
        Validator<String> nombreVal = (Control c, String texto) -> {
            if (texto == null || texto.isEmpty()) {
                return ValidationResult.fromError(c, "El nombre no puede estar vacio");
                
            } else{
                String regex = ".*\\d.*";
                if (texto.matches(regex)) {
                    return ValidationResult.fromError(c, "El nombre NO puede contener numeros");
                } else {
                    return ValidationResult.fromInfo(c, "Nombre valido!");
                }    
            }
        };
        nombreAl.registerValidator(textNombreAñAlmacen, false, nombreVal);

        
        ValidationSupport dirAl = new ValidationSupport();
        Validator<String> dirVal = (Control c, String texto) -> {
            if (texto == null || texto.isEmpty()) {
                return ValidationResult.fromError(c, "Direccion vacia");
            }else{
                //no permite \ , pero si /
                String regex = "^[A-Za-z0-9\\sºª,\\-\"/]*$";
                if (!texto.matches(regex)) {
                    return ValidationResult.fromError(c, "Direccion con caracteres no permitidos");
                }
                return ValidationResult.fromInfo(c, "Direccion valida!");
            }

        };
        dirAl.registerValidator(textDirAñAlmacen, false, dirVal);
        
        
        ValidationSupport paisAl = new ValidationSupport();
        Validator<String> paisVal = Validator.createPredicateValidator(
                texto -> !("".equals(texto)),
                "Hay que elegir un pais!",
                Severity.ERROR
        );
        paisAl.registerValidator(comboBoxPaisAñAlmacen, false, paisVal);
        
        
        ValidationSupport ciudadAl = new ValidationSupport();
        Validator<String> ciudadVal = Validator.createPredicateValidator(
                texto -> !("".equals(texto)),
                "Hay que elegir una ciudad!",
                Severity.ERROR
        );
        ciudadAl.registerValidator(comboBoxCiudadAñAlmacen, false, ciudadVal);
        
        
        ValidationSupport telAl = new ValidationSupport();
        Validator<String> telVal = (Control c, String texto) -> {
            if (texto.isEmpty()) {
                return ValidationResult.fromError(c, "Telefono vacio");

            } else {
                //contien 9 num si o si
                String regex = "^\\d{9}$";

                if (!texto.matches(regex)) {
                    return ValidationResult.fromError(c, "El telefono tiene que tener 9 numeros");
                } else {
                    return ValidationResult.fromInfo(c, "Telefono valido");
                }
            }
        };
        telAl.registerValidator(textTelAñAlmacen, false, telVal);
        
        
        ValidationSupport capTotalAl = new ValidationSupport();
        Validator<String> capTotalVal = (Control c, String texto) -> {
             if (texto.isEmpty() || texto == "0") {
                return ValidationResult.fromError(c, "La capacidad no puede estar vacia o ser 0");

            } else {
               //ni caract especial ni nada, solo num
                String regex = "^\\d+$";

                if (!texto.matches(regex)) {
                    return ValidationResult.fromError(c, "La capacidad debe ser un numero valido");
                } else {
                    return ValidationResult.fromInfo(c, "Capacidad total valida!");
                }
            }
        };
        capTotalAl.registerValidator(textCapTotalAñAlmacen, false, capTotalVal);
        
        
        ValidationSupport idTiendaAl = new ValidationSupport();
        Validator<String> idTiendaVal = (Control c, String texto) -> {
             if (texto.isEmpty()) {
                return ValidationResult.fromError(c, "La tienda asociada no puede estar vacia");

            } else {
                if (!verificarTiendaExistente(textIdTiendaAñAlmacen.getText())) {
                    return ValidationResult.fromError(c, "La tienda no se encuentra");
                } else {
                    return ValidationResult.fromInfo(c, "La tienda es valida!");
                }
            }
        };
        idTiendaAl.registerValidator(textIdTiendaAñAlmacen, false, idTiendaVal);
        
        
        validadores = new ArrayList<>();
        validadores.addAll(Arrays.asList(nombreAl, dirAl, paisAl, ciudadAl, telAl, capTotalAl, idTiendaAl));
        
        
        Platform.runLater(() -> {
            for (ValidationSupport validationSupport : validadores) {
                validationSupport.initInitialDecoration();
            }
            
            nombreAl.setValidationDecorator(decorador);
            dirAl.setValidationDecorator(decorador);
            paisAl.setValidationDecorator(decorador);
            ciudadAl.setValidationDecorator(decorador);
            telAl.setValidationDecorator(decorador);
            capTotalAl.setValidationDecorator(decorador);
            idTiendaAl.setValidationDecorator(decorador);
            
          
        });

    }
    
    private boolean comprobarDatosAlmacen(){
        for (ValidationSupport validationSupport : validadores) {
            ValidationResult resultados = validationSupport.getValidationResult();
            System.out.println("Validador Errores: " + resultados.getErrors());
            System.out.println("Validador Infos: " + resultados.getInfos());
        }
        
        boolean todoOK = true;
        for (ValidationSupport validationSupport : validadores) {
            todoOK = (todoOK && validationSupport.getValidationResult().getErrors().isEmpty());
            return true;
        }
        return false;
        
    }
    
    private boolean verificarTiendaExistente(String tienda) {
        if (conexion != null) {
            String query = "SELECT COUNT(*) AS count FROM tiendas WHERE id_tienda = ? OR nombre = ?";
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, tienda);
                ps.setString(2, tienda);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
            } catch (SQLException e) {
                System.err.println("No existe la tienda que has indicado" + e.getMessage());
            }
        }
        return false;
    }
    
    

    
    
}

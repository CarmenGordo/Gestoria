package controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.Tiendas;
import modelos.Almacenes;
import modelos.HorarioAlmacen;
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
import java.util.HashMap;
import java.util.Locale;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ConexionBD;

public class ControladorIndex implements Initializable {

    public Connection conexion;
    public Statement st;
    public ResultSet rs;
    
    private ResourceBundle rb;

    ObservableList<Tiendas> listaTiendas = FXCollections.observableArrayList();
    ObservableList<Almacenes> listaAlmacenes = FXCollections.observableArrayList();
    ObservableList<HorarioAlmacen> horarioAlmacen = FXCollections.observableArrayList();
    ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
    
    
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
    private Pane paneContenidoListaTiendas;
    @FXML
    private Pane paneContenidoTiendaSelec;
    @FXML
    private Pane paneContenidoListaAlmacenes;
    @FXML
    private Pane paneContenidoAlmacenSelec;
    @FXML
    private Pane paneContenidoListaProductos;
    @FXML
    private Pane paneContenidoProductoSelec;
    
    
   
    
    
    //PaneCabecera: 
    @FXML
    private Button btnVolver;
    //? arreglar migas y volver atras
    @FXML
    private Text textoMigas;
    @FXML
    private void volverTiendas(){
        
    }
    private void visiblePaneCabecera(boolean v){
        btnVolver.setVisible(v);
        textoMigas.setVisible(v);
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
    private Button btnTiendas;
    @FXML
    private void cambiarPaneListaTiendas(){
        mostrarPane(paneContenidoListaTiendas);
    }
    private void cambiarPaneTiendaSelec(){
        mostrarPane(paneContenidoTiendaSelec);
    }
    @FXML
    private Button btnAlmacenes;
    @FXML
    private void cambiarPaneListaAlmacenes(){
        mostrarPane(paneContenidoListaAlmacenes);
    }
    @FXML
    private Button btnProductos;
    @FXML
    private void cambiarPaneListaProductos(){
        mostrarPane(paneContenidoListaProductos);
    }
    private void mostrarPane(Pane paneMostrar) {
        paneContenidoListaProductos.setVisible(false);
        paneContenidoProductoSelec.setVisible(false);
        paneContenidoListaTiendas.setVisible(false);
        paneContenidoTiendaSelec.setVisible(false);
        paneContenidoListaAlmacenes.setVisible(false);
        paneContenidoAlmacenSelec.setVisible(false);
        
        paneMostrar.setVisible(true);
    } 
    @FXML
    private Button btnAjustes;
    
    
    
    //Tabla lista productos:
    @FXML
    private TableView<Productos> tablaListaProductos;
    @FXML
    private TableColumn<Tiendas, String> columnIdListaProductos;
    @FXML
    private TableColumn<Tiendas, String> columnNombreListaProductos;
    @FXML
    private TableColumn<Tiendas, String> columnImgListaProductos;
    @FXML
    private TableColumn<Tiendas, Productos.TipoProducto> columnTipoListaProductos;
    @FXML
    private TableColumn<Tiendas, ?> columnSubTipoListaProductos;
    @FXML
    private TableColumn<Tiendas, Productos.TallaProducto> columnTallaListaProductos;
    @FXML
    private TableColumn<Tiendas, Double> columnPrecioListaProductos;
    @FXML
    private TableColumn<Tiendas, Integer> columnStockListaProductos;
    
    
    
    
    
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
    //@FXML
    //private TableColumn<Productos, Productos.SubTipoAccProducto>columnSubTipoTiendaSelecProd;
    @FXML
    private TableColumn<Productos, Productos.TallaProducto>columnTallaTiendaSelecProd;
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
    private TableColumn<Almacenes, Map> columnHorarioTiendaSelecAlmac;    
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
    private Text texIdAlmacenSelec;
    @FXML
    private Text textNombreAlmacenSelec;
    @FXML
    private Text textTelAlmacenSelec;
    @FXML
    private Text textlDirAlmacenSelec;
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
    private Text textCiudadAlmacenSelec;
    @FXML
    private Text textPaisAlmacenSelec;
    
    //pg almacen selec, tabla productos:
    @FXML
    private TableView<Almacenes> tablaProductosAlmacen;
    @FXML
    private TableColumn<Productos, String> columnIdAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, String> columnNombreAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, String> columnImgAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, Productos.TipoProducto> columnTipoAlmacenSelecProductos;
    //@FXML
    //private TableColumn<Productos, String> columnSubTipoAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, Productos.TallaProducto> columnTallaAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, Double> columnPrecioAlmacenSelecProductos;
    @FXML
    private TableColumn<Productos, Integer> columnStockAlmacenSelecProductos;
            
    //pg almacen selec, tabla tiendas:
    @FXML
    private TableView<Tiendas> tablaTiendasAlmacen;
    @FXML
    private TableColumn<Tiendas, String> columnIdAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnNombreAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnTipoAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnDirAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnCiudadAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, String> columnPaisAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, Integer> columnTelAlmacenSelecTiendas;
    @FXML
    private TableColumn<Tiendas, Map> columnHorarioAlmacenSelecTiendas;
    
    
    
    
    //Botones pane botonera:
    @FXML
    private void añadir(){
        
    }
    
    @FXML
    private void editar(){
        
    }
            
    @FXML
    private void actualizar(){
        
    }
            
    @FXML
    private void borrar(){
        
    }
    
    
    @FXML
    private void verSeleccion() {
       
        if (tablaListaTiendas.getSelectionModel().getSelectedItem() != null){
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
            
            System.out.println("almacen selec, id TIENDA -- " + almacenSelec.getId_tienda());
            rellenarAlmacenSelec(almacenSelec);
            rellenarTiendasAlmacenSelec(tiendaAlmacenSelec);
            
            tablaListaAlmacenes.getSelectionModel().clearSelection();
        }
        //?arreglar ver boton
        //else if (tablaListaProdutos.getSelectionModel().getSelectedItem() != null){
            //Tiendas tiendaSelec = tablaListaTiendas.getSelectionModel().getSelectedItem();
            //mostrarPane(paneContenidoProdcutoSelec);
            //visiblePaneCabecera(true);
            
            //System.out.println("producto Selec id-- " + productoSelec.getId_tienda());
            //rellenarTablaTiendaSelec(tiendaSelec);
            //rellenarAlmacenesTienda(tiendaSelec.getId_tienda());
            
            //tablaListaProductos.getSelectionModel().clearSelection();
        //}
        
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
        
        //?preguntar que es para rellenar
        //columnSubTipoTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("pais"));
        //?preguntar que es para rellenar
//columnTallaTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("subtipo_ropa"));
        columnTallaTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("talla"));
        columnPrecioTiendaSelecProd.setCellValueFactory(new PropertyValueFactory<>("talla"));
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
        columnHorarioTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("horario"));
        columnCapOcupadaTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("capacidad_ocupada"));
        columnCapTotalTiendaSelecAlmac.setCellValueFactory(new PropertyValueFactory<>("capacidad_total"));

        
        tablaAlmacenesTienda.setItems(listaAlmacenes);
    }
    
    
    //pg almacen selec:
    private void rellenarAlmacenSelec(Almacenes almacenSelec){
        texIdAlmacenSelec.setText(almacenSelec.getId_almacen());
        textNombreAlmacenSelec.setText(almacenSelec.getNombre());
        textlDirAlmacenSelec.setText(almacenSelec.getDireccion());
        textTelAlmacenSelec.setText(Integer.toString(almacenSelec.getTelefono()));
        textCiudadAlmacenSelec.setText(almacenSelec.getCiudad());
        textPaisAlmacenSelec.setText(almacenSelec.getPais());
        
        //para el horario:
        Map<String, Map<String, String>> horarios = new HashMap<>();
        horarios.put("lunes", Map.of("apertura", "10:00", "cierre", "18:00"));
        horarios.put("martes", Map.of("apertura", "10:00", "cierre", "18:00"));
        horarios.put("miércoles", Map.of("apertura", "10:00", "cierre", "18:00"));
        horarios.put("jueves", Map.of("apertura", "10:00", "cierre", "18:00"));
        horarios.put("viernes", Map.of("apertura", "10:00", "cierre", "18:00"));

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
    private void rellenarProductosAlmacenSelec(String idTienda){
        
    }
    private void rellenarTiendasAlmacenSelec(String idTienda){
        listaTiendas.clear();
        ObservableList<Tiendas> tiendas = darListaTiendas();
        System.out.println("bbb almacen selec, id TIENDA -- " + idTienda);

        for (int i = 0; i < tiendas.size(); i++) {
            Tiendas tienda = tiendas.get(i);
            if (tienda.getId_tienda().equals(idTienda)) {
                listaTiendas.add(tienda);
                System.out.println("cc -- " + tienda.getId_tienda());
            }
        }
        System.out.println("Número de tiendas añadidas: " + listaTiendas.size());

        columnIdAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("id_tienda"));
        columnNombreAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTipoAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnDirAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCiudadAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        columnPaisAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("pais"));
        columnTelAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnHorarioAlmacenSelecTiendas.setCellValueFactory(new PropertyValueFactory<>("horario"));
        

        tablaTiendasAlmacen.setItems(listaTiendas);tablaTiendasAlmacen.refresh();
    }

    
    
    

    
    
    
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
        
        btnTablero.setText(rb.getString("btnTablero"));
        btnProductos.setText(rb.getString("btnProductos"));
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cargar los idiomas
        btnCambioIdioma.getItems().addAll("Español", "English");
        btnCambioIdioma.setValue("Español"); 
        btnCambioIdioma.setOnAction(e -> cambiarIdioma());
        
        //mostrar el pane de inicio
        //mostrarPane(paneInicio);
        
        
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
                ObservableList<Productos> listaP = darListaProductos();
                
                
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
                
                //? añadir productos
                
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
    
    private void mostrarTiendas() {
       tablaListaTiendas.setItems(listaTiendas);
    }
    
    private ObservableList<Almacenes> darListaAlmacenes(){
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
    
    private void mostrarAlmacenes() {
       tablaListaAlmacenes.setItems(listaAlmacenes);
    }
    
    private ObservableList<Productos> darListaProductos(){
        ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
        
        if (conexion != null) {
            String query = "SELECT * FROM productos";
            try {
                rs = st.executeQuery(query);
                while (rs.next()) {
                    //convertir el enum a string
                    Productos.TipoProducto tipo = Productos.TipoProducto.valueOf(rs.getString("tipo"));
                    Productos.SubTipoRopaProducto subtipo_ropa = Productos.SubTipoRopaProducto.valueOf(rs.getString("subtipo_ropa"));
                    Productos.SubTipoAccProducto subtipo_accesorios = Productos.SubTipoAccProducto.valueOf(rs.getString("subtipo_accesorios"));
                    Productos.TallaProducto talla = Productos.TallaProducto.valueOf(rs.getString("talla"));

                    
                    Productos producto = new Productos(
                        rs.getString("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("imagen"),
                        tipo,
                        subtipo_ropa,
                        subtipo_accesorios,
                        talla,
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("id_tienda"),
                        rs.getString("id_almacen")
                    );

                    
                    listaProductos.add(producto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return listaProductos;
    }
    
    private void mostrarProductos() {
       tablaListaProductos.setItems(listaProductos);
    }
    
    
}

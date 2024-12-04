package modelos;

import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author carmen_gordo
 */
public class Tiendas {

    private String id_tienda;
    private String nombre;
    private TipoTienda tipo;
    private String direccion;
    private String ciudad;
    private String pais;
    private int telefono;
    public Map<String, Map<String, String>> horario;
    
    private ObservableList<Productos> productos;
 

    public Tiendas() {
    }

    public Tiendas( String id_tienda, String nombre, TipoTienda tipo, String direccion, String ciudad, String pais, int telefono, Map<String, Map<String, String>> horario) {
       
        this.id_tienda = id_tienda;
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.horario = horario;
    }

   

    public String getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(String id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoTienda getTipo() {
        return tipo;
    }

    public void setTipo(TipoTienda tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Map<String, Map<String, String>> getHorario() {
        return horario;
    }

    public void setHorario(Map<String, Map<String, String>> horario) {
        this.horario = horario;
    }

    
    //enum de tiendas:
    public enum TipoTienda {
        normal,
        outlet,
        premium
    }
    
    
    public String recogerHorario() {
        
        if (horario == null || horario.isEmpty()) {
            return "No disponible";
        }

        StringBuilder horarioString = new StringBuilder();

        String[] diasSemana = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};

        for (String diaSemana : diasSemana) {
            Map<String, String> horas = horario.get(diaSemana);  // Obtenemos las horas de cada día

            // Comprobamos si tenemos datos de apertura y cierre para este día
            String apertura = (horas != null) ? horas.get("apertura") : null;
            String cierre = (horas != null) ? horas.get("cierre") : null;

            horarioString.append(ponerLetraMayus(diaSemana)).append(": ");

            // Si tenemos datos de apertura y cierre, los mostramos
            if (apertura != null && cierre != null) {
                horarioString.append(apertura).append(" - ").append(cierre);
            } 
            horarioString.append(", ");
        }

        if (horarioString.length() > 2) {
            horarioString.setLength(horarioString.length() - 2);
        }

        return horarioString.toString();
    }

   
    private String ponerLetraMayus(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    
    //para saber sus productos
    public ObservableList<Productos> getProductos() {
        return productos;
    }
}

package modelos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import org.checkerframework.checker.units.qual.Length;

/**
 *
 * @author carmen_gordo
 */
public class Almacenes {

    public String id_almacen;
    public String nombre;
    public String direccion;
    public String ciudad;
    public String pais;
    public int telefono;
    public Map<String, Map<String, String>> horario;
    public int capacidad_ocupada;
    public int capacidad_total;
    public String id_tienda;
    
    private ObservableList<Productos> productos;

    public Almacenes() {
    }

    public Almacenes(String id_almacen, String nombre, String direccion, String ciudad, String pais, int telefono, Map<String, String> horario, int capacidad_ocupada, int capacidad_total, String id_tienda) {
        this.id_almacen = id_almacen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.telefono = telefono;
        this.horario = new LinkedHashMap<>();
        this.capacidad_ocupada = capacidad_ocupada;
        this.capacidad_total = capacidad_total;
        this.id_tienda = id_tienda;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getCapacidad_ocupada() {
        return capacidad_ocupada;
    }

    public void setCapacidad_ocupada(int capacidad_ocupada) {
        this.capacidad_ocupada = capacidad_ocupada;
    }

    public int getCapacidad_total() {
        return capacidad_total;
    }

    public void setCapacidad_total(int capacidad_total) {
        this.capacidad_total = capacidad_total;
    }

    public String getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(String id_tienda) {
        this.id_tienda = id_tienda;
    }
    
    //Map<String, Map<String, String>> horarios = new LinkedHashMap<>();
    //horarios.put("lunes", Map.of("apertura", "10:00", "cierre", "18:00"));
    
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
    
    //para saber sus producots
    public ObservableList<Productos> getProductos() {
        return productos;
    }

}

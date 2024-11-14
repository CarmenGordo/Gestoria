package modelos;

import java.util.Map;

/**
 *
 * @author carmen_gordo
 */
public class Tiendas {
    
    //private boolean check;
    private String id_tienda;
    private String nombre;
    private TipoTienda tipo;
    private String direccion;
    private String ciudad;
    private String pais;
    private int telefono;
    private Map<String, String> horario;
 

    public Tiendas() {
    }

    public Tiendas( String id_tienda, String nombre, TipoTienda tipo, String direccion, String ciudad, String pais, int telefono, Map<String, String> horario) {
       // this.check = check;
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

    public Map<String, String> getHorario() {
        return horario;
    }

    public void setHorario(Map<String, String> horario) {
        this.horario = horario;
    }

    
    //enum de tiendas:
    public enum TipoTienda {
        normal,
        outlet,
        premium
    }
}

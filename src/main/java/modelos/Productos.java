package modelos;

/**
 *
 * @author carmen_gordo
 */
public class Productos {
    public String id_producto;
    public String nombre;
    public String imagen;
    public TipoProducto tipo;
    public SubTipoRopaProducto subtipo_ropa;
    public SubTipoAccProducto subtipo_accesorios;
    public TallaProducto talla;
    public double precio;
    public int stock;
    public String id_tienda;
    public String id_almacen;	

    public Productos() {
    }

    public Productos(String id_producto, String nombre, String imagen, TipoProducto tipo, SubTipoRopaProducto subtipo_ropa, SubTipoAccProducto subtipo_accesorios, TallaProducto talla, double precio, int stock, String id_tienda, String id_almacen) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
        this.subtipo_ropa = subtipo_ropa;
        this.subtipo_accesorios = subtipo_accesorios;
        this.talla = talla;
        this.precio = precio;
        this.stock = stock;
        this.id_tienda = id_tienda;
        this.id_almacen = id_almacen;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public SubTipoRopaProducto getSubtipo_ropa() {
        return subtipo_ropa;
    }

    public void setSubtipo_ropa(SubTipoRopaProducto subtipo_ropa) {
        this.subtipo_ropa = subtipo_ropa;
    }

    public SubTipoAccProducto getSubtipo_accesorios() {
        return subtipo_accesorios;
    }

    public void setSubtipo_accesorios(SubTipoAccProducto subtipo_accesorios) {
        this.subtipo_accesorios = subtipo_accesorios;
    }

    public TallaProducto getTalla() {
        return talla;
    }

    public void setTalla(TallaProducto talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(String id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }
    
    //enum de tiendas:
    public enum TipoProducto {
        Accesorios,
        Ropa, 
        Zapatillas
    }
    
    public enum SubTipoRopaProducto {
        camiseta,
        sudadera,
        jersey,
        chaqueta,
        pantalones_cortos,
        pantalones_largos,
        leggins,
        chandals,
        faldas,
        vestidos
        
    }
    
    public enum SubTipoAccProducto {
        gorro_y_gorra,
        bolso,
        mochila,
        calcetines,
        guantes,
        cinturones,
        carteras,
        gafas_de_sol
    }
    
    public enum TallaProducto{
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        t35,t36,t37,t38,t39,t40,t41,t42,t43,t44,t45
    }
}

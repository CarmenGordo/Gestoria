package modelos;

/**
 *
 * @author carmen_gordo
 */
public class Productos {
    public String $id_producto;
    public String $nombre;
    public String $imagen;
    public Enum $tipo;
    public Enum $subtipo_ropa;
    public Enum $subtipo_accesorios;
    public Enum $talla;
    public double $precio;
    public int $stock;
    public String $id_tienda;
    public String $id_almacen;	

    public Productos() {
    }

    public Productos(String $id_producto, String $nombre, String $imagen, Enum $tipo, Enum $subtipo_ropa, Enum $subtipo_accesorios, Enum $talla, double $precio, int $stock, String $id_tienda, String $id_almacen) {
        this.$id_producto = $id_producto;
        this.$nombre = $nombre;
        this.$imagen = $imagen;
        this.$tipo = $tipo;
        this.$subtipo_ropa = $subtipo_ropa;
        this.$subtipo_accesorios = $subtipo_accesorios;
        this.$talla = $talla;
        this.$precio = $precio;
        this.$stock = $stock;
        this.$id_tienda = $id_tienda;
        this.$id_almacen = $id_almacen;
    }

    public String get$id_producto() {
        return $id_producto;
    }

    public void set$id_producto(String $id_producto) {
        this.$id_producto = $id_producto;
    }

    public String get$nombre() {
        return $nombre;
    }

    public void set$nombre(String $nombre) {
        this.$nombre = $nombre;
    }

    public String get$imagen() {
        return $imagen;
    }

    public void set$imagen(String $imagen) {
        this.$imagen = $imagen;
    }

    public Enum get$tipo() {
        return $tipo;
    }

    public void set$tipo(Enum $tipo) {
        this.$tipo = $tipo;
    }

    public Enum get$subtipo_ropa() {
        return $subtipo_ropa;
    }

    public void set$subtipo_ropa(Enum $subtipo_ropa) {
        this.$subtipo_ropa = $subtipo_ropa;
    }

    public Enum get$subtipo_accesorios() {
        return $subtipo_accesorios;
    }

    public void set$subtipo_accesorios(Enum $subtipo_accesorios) {
        this.$subtipo_accesorios = $subtipo_accesorios;
    }

    public Enum get$talla() {
        return $talla;
    }

    public void set$talla(Enum $talla) {
        this.$talla = $talla;
    }

    public double get$precio() {
        return $precio;
    }

    public void set$precio(double $precio) {
        this.$precio = $precio;
    }

    public int get$stock() {
        return $stock;
    }

    public void set$stock(int $stock) {
        this.$stock = $stock;
    }

    public String get$id_tienda() {
        return $id_tienda;
    }

    public void set$id_tienda(String $id_tienda) {
        this.$id_tienda = $id_tienda;
    }

    public String get$id_almacen() {
        return $id_almacen;
    }

    public void set$id_almacen(String $id_almacen) {
        this.$id_almacen = $id_almacen;
    }
    
    
}

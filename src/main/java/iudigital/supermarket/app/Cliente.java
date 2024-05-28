
package iudigital.supermarket.app;

import java.util.List;

/**
 *
 * @author jaime
 */
public class Cliente {
    private String nombre;
    List<Producto> productos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Cliente(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }
    
      
}

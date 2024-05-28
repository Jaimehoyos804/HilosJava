package iudigital.supermarket.app;

/**
 *
 * @author jaime
 */
public class Cajeras implements Runnable {

  
    private String nombre;
    private Cliente cliente;
    private Long tiempoCompra;
    double totalcompra = 0;

    //Metodo constructor
    public Cajeras(String nombre, Cliente cliente, Long tiempoCompra) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoCompra = tiempoCompra;
    }

    private void procesarProducto(Producto productos) throws InterruptedException {
        
        System.out.println("Ingresando Producto "+productos.getNombre());
        System.out.println("Precio: $"+productos.getPrecio());
        try{
            Thread.sleep((long)(productos.getPrecio()*20));
                        
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Producto " +productos.getNombre() + " procesado en "
                +(System.currentTimeMillis()-tiempoCompra)/100+ " segundos");
    }

    @Override
    public void run() {
        System.out.println("Cajero: " + nombre + " buenas tardes bienvenidos");
        System.out.println("**COMIENZA PROCESO DE COMPRA**");
        System.out.println(cliente.getNombre() + " timepo de compra " + 
                (System.currentTimeMillis() - tiempoCompra)
                / 100 + " Segundos");

        for (Producto productos : cliente.getProductos()) {
            try {
                procesarProducto(productos);
                totalcompra = (productos.getCantidad() * productos.getPrecio());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Cajera " + nombre + "termino de procesar la compra del "
                + cliente.getNombre() + " en el tiempo "
                + (System.currentTimeMillis() - tiempoCompra) / 100 + " Segundos"
                + " Total a pagar: " + totalcompra);

    }
}

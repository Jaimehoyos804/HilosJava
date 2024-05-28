package iudigital.supermarket.app;

import java.util.Arrays;

/**
 *
 * @author jaime
 */
public class SuperMarketApp {

    public static void main(String[] args) {
        Producto productoOne = new Producto("Arroz", 1500, 1);
        Producto productoTwo = new Producto("Leche", 1200, 3);
        Producto productoThree = new Producto("Huevos", 800, 5);

        Cliente clienteOne = new Cliente("Jaime Hoyos", Arrays.asList(productoOne,
                productoTwo, productoThree));
        Cliente clienteTwo = new Cliente("Yuliana Goméz", Arrays.asList(productoOne,
                productoTwo));
        Cliente clienteThree = new Cliente("Jorge Bermudez", Arrays.asList(productoTwo,
                productoThree));

        long tiempoInicioCompra = System.currentTimeMillis();

        Cajeras cajeraOne = new Cajeras("Juan Lopez ", clienteTwo,
                tiempoInicioCompra);
        Cajeras cajeraTwo = new Cajeras("Luciana ", clienteOne,
                tiempoInicioCompra);
        Cajeras cajeraThree = new Cajeras("Ana Maria ", clienteThree,
                tiempoInicioCompra);

        Thread hiloOne = new Thread(cajeraOne);
        Thread hiloTwo = new Thread(cajeraTwo);
        Thread hiloThree = new Thread(cajeraThree);
       
        hiloOne.start();
        hiloTwo.start();
        hiloThree.start();

        try {
            hiloOne.join();
            hiloTwo.join();
            hiloThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cobro finalizado");
        
    }
}

package tienda.servicios;

import java.util.List;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicios {

    private final ProductoDAO productoDAO;

    public ProductoServicios() {
        productoDAO = new ProductoDAO();
    }

    public void traerProductos() throws Exception {
        try {
            List<Producto> productos = productoDAO.conseguirProductos();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene personas.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s\n", "ID", "Nombre");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s\n", prod.getCodigo(), prod.getNombre());                    
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
    public void traerNombresYPreciosProductos() throws Exception {
        try {
            List<Producto> productos = productoDAO.conseguirProductos();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene personas.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s\n", "ID", "Nombre","Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s\n", prod.getCodigo(), prod.getNombre(),prod.getPrecio());                    
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
    
    public void traerProductosPrecioEntre120y202() throws Exception {
        try {
            List<Producto> productos = productoDAO.conseguirProductosPreciosEntre120y202();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene personas.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s\n", "ID", "Nombre","Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s\n", prod.getCodigo(), prod.getNombre(),prod.getPrecio());                    
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

}

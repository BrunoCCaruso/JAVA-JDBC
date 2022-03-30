package tienda.servicios;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicios {

    private final ProductoDAO productoDAO;
    private static Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

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
    
    public void traerProductosPortatiles() throws Exception {
        try {
            List<Producto> productos = productoDAO.conseguirProductosPortatiles();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene personas.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s%-15s\n", "ID", "Nombre","Precio","Código Fabricante");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s%-15s\n", prod.getCodigo(), prod.getNombre(),prod.getPrecio(),prod.getCodigo());                    
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
    
    public void traerProductoMenorPrecio() throws Exception {
        try {
            List<Producto> productos = productoDAO.conseguirProductoMenorPrecio();

            if (productos.isEmpty()) {
                throw new Exception("La lista no tiene personas.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-35s%-35s\n", "Nombre","Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-35s%-35s\n", prod.getNombre(),prod.getPrecio());                    
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
    
   public void crearProducto() throws Exception {
       Producto product = new Producto();
       Fabricante fabr = new Fabricante();
       
       try {
            System.out.println("Ingrese el nombre del producto:");
            String nombre = read.next();
            product.setNombre(nombre);            
            if ( nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }
            System.out.println("Ingrese el precio del producto:");
            Double precio = read.nextDouble();
            product.setPrecio(precio);             

            System.out.println("Ingrese el codigo del fabricante del producto:");
            int codFabricante = read.nextInt();
            fabr.setCodigo(codFabricante);
            product.setFabricante(fabr);           
      
            productoDAO.ingresarProducto(product);
            
        } catch (Exception e) {
            throw e;
        }
    }
    

}

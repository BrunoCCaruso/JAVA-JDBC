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
                throw new Exception("La lista no tiene productos.");
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
                throw new Exception("La lista no tiene productos.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s\n", "ID", "Nombre", "Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s\n", prod.getCodigo(), prod.getNombre(), prod.getPrecio());
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
                throw new Exception("La lista no tiene productos.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s\n", "ID", "Nombre", "Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s\n", prod.getCodigo(), prod.getNombre(), prod.getPrecio());
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
                throw new Exception("La lista no tiene productos.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-10s%-35s%-35s%-15s\n", "ID", "Nombre", "Precio", "Código Fabricante");
                for (Producto prod : productos) {
                    System.out.printf("%-10s%-35s%-35s%-15s\n", prod.getCodigo(), prod.getNombre(), prod.getPrecio(), prod.getCodigo());
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
                throw new Exception("La lista no tiene productos.");
            } else {
                System.out.println("Lista de productos");
                System.out.printf("%-35s%-35s\n", "Nombre", "Precio");
                for (Producto prod : productos) {
                    System.out.printf("%-35s%-35s\n", prod.getNombre(), prod.getPrecio());
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
            if (nombre == null || nombre.trim().isEmpty()) {
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

    public void editarProducto() throws Exception {

        try {
            System.out.println("Seleccione el código del producto que quiera modificar:");
            int codigo = read.nextInt();

            System.out.println("El producto seleccionado es: ");
            List<Producto> listaProducto = productoDAO.conseguirProductoPorCodigo(codigo);
            if (listaProducto.isEmpty()) {
                throw new Exception("La lista no tiene productos.");
            } else {
                System.out.printf("%-10s%-35s%-35s%-35s%-35s\n", "ID", "Nombre", "Precio", "Código Fabricante", "Nombre Fabricante");
                for (Producto prod : listaProducto) {
                    System.out.printf("%-10s%-35s%-35s%-35s%-35s\n", prod.getCodigo(), prod.getNombre(), prod.getPrecio(), prod.getFabricante().getCodigo(), prod.getFabricante().getNombre());
                }
            }

            System.out.println("Que desea modificar del producto elegido?");
            System.out.println(
                      "a- Nombre\n"
                    + "b- Precio\n"
            );

            String opc = "";
            boolean band = true;

            do {
                System.out.println("Opción elegida: ");
                opc = read.next();
                
                switch (opc.toLowerCase()) {
                    case "a":
                        System.out.println("Nombre seleccionado.");
                        System.out.println("Ingrese el nuevo nombre: ");
                        String nombreNuevo = read.next();

                        listaProducto.get(0).setNombre(nombreNuevo);

                        productoDAO.modificarProducto(listaProducto.get(0));

                        System.out.println("Nombre cambiado satisfactoriamente!");

                        band = false;

                        break;
                    case "b":
                        System.out.println("Precio seleccionado.");
                        System.out.println("Ingrese el nuevo precio: ");
                        Double precioNuevo = read.nextDouble();
                        listaProducto.get(0).setPrecio(precioNuevo);
                        productoDAO.modificarProducto(listaProducto.get(0));
                        System.out.println("Precio cambiado satisfactoriamente!");
                        band = false;
                        break;
                    default:
                        System.out.println("Ingrese una opción válida.");
                        break;
                }
            } while (band);

        } catch (Exception e) {
            throw e;
        }

    }

}

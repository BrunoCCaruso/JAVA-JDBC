package tienda.servicios;

import java.util.Locale;
import java.util.Scanner;

public class TiendaServicios {

    ProductoServicios prodServ = new ProductoServicios();
    FabricanteServicios fabrServ = new FabricanteServicios();

    private static Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void menu() throws Exception {
        try {
            System.out.println("|------------------------------- MENU -----------------------------------|\n"
                    + "a- Listar el nombre de todos los productos que hay en la tabla producto.\n"
                    + "b- Listar los nombres y los precios de todos los productos de la tabla producto.\n"
                    + "c- Listar aquellos productos que su precio esté entre 120 y 202.\n"
                    + "d- Buscar y listar todos los Portátiles de la tabla producto.\n"
                    + "e- Listar el nombre y el precio del producto más barato.\n"
                    + "f- Ingresar un producto a la base de datos.\n"
                    + "g- Ingresar un fabricante a la base de datos.\n"
                    + "h- Editar un producto con datos a elección.\n"
                    + "i- Salir.\n"
                    + "|--------------------------------------------------------------------------|"
            );
            respuestaUsuario();               
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Debe ingresar únicamente una opción válida (a,b,c,d,e,f,g,h,i).");            
        }
       
    }

    public void respuestaUsuario() throws Exception {
        try {
            System.out.print("- Opción elegida: ");
            String resp = read.next();            
            seleccionadorRespuesta(resp); 
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("La opción ingresada no es válida.");

        }        
    }

    public void seleccionadorRespuesta(String resp) throws Exception {
        try {
            switch (resp.toLowerCase()) {
                case "a":
                    prodServ.traerProductos();
                    menu();
                    break;
                case "b":
                    prodServ.traerNombresYPreciosProductos();
                    menu();
                    break;
                case "c":
                    prodServ.traerProductosPrecioEntre120y202();
                    menu();
                    break;
                case "d":
                    prodServ.traerProductosPortatiles();
                    menu();
                    break;
                case "e":
                    prodServ.traerProductoMenorPrecio();
                    menu();
                    break;
                case "f":
                    prodServ.crearProducto();
                    menu();
                    break;
                case "g":
                   fabrServ.crearFabricante();    
                    menu();
                    break;
                case "h":

                    menu();
                    break;
                case "i":
                    System.out.println("Salió exitosamente!");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    menu();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("No se pudieron verificar las opciones.");
        }
    }

}

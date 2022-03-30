
package tienda.servicios;

import java.util.Locale;
import java.util.Scanner;


public class TiendaServicios {
    
    private static Scanner read= new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    
    public void menu(){
        System.out.println
        ("|------------------------------- MENU -----------------------------------|\n"+
        "a- Listar el nombre de todos los productos que hay en la tabla producto.(SELECT nombre FROM producto;)\n"+ 
        "b- Listar los nombres y los precios de todos los productos de la tabla producto.\n"+ 
        "c- Listar aquellos productos que su precio esté entre 120 y 202.\n"+ 
        "d- Buscar y listar todos los Portátiles de la tabla producto.\n"+ 
        "e- Listar el nombre y el precio del producto más barato.\n"+ 
        "f- Ingresar un producto a la base de datos.\n"+
        "g- Ingresar un fabricante a la base de datos.\n"+
        "h- Editar un producto con datos a elección.\n"+
        "i- Salir.\n"+       
        "|--------------------------------------------------------------------------|"        
        );
       respuestaUsuario();
    }
    
    public void respuestaUsuario(){
        System.out.print("- Opción elegida: ");
        String resp = read.next();
        seleccionadorRespuesta(resp);
    }
    
    public void seleccionadorRespuesta(String resp){
        
        switch (resp.toLowerCase()){
            case "a": 
                
                menu();
                break;
            case "b":
                
                menu();
                break;
            case "c":
                
                menu();
                break;
            case "d":
                
                menu();
                break;
            case "e":
                
                menu();
                break;
            case "f":
                
                menu();
                break;
            case "g":
                
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
    }
    
}

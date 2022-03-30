////////////////////// consigna //////////////////
/*

*/
package tienda;

import tienda.servicios.TiendaServicios;


public class Main {

    
    public static void main(String[] args) {
       
        TiendaServicios servicio = new TiendaServicios();
        
        try{
        servicio.menu();
        }catch(Exception e){
            System.out.println(e.getMessage());                         
        }
        
        
    }
    
}

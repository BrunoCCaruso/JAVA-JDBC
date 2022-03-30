package tienda.servicios;

import java.util.Locale;
import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicios {

    private final FabricanteDAO fabricanteDAO = new FabricanteDAO();
    private static Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

    public void crearFabricante() throws Exception {

        Fabricante fabr = new Fabricante();

        try {
            System.out.println("Ingrese el nombre del fabricante:");
            String nombre = read.next();
            fabr.setNombre(nombre);
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("El nombre es obligatorio");
            }

            fabricanteDAO.ingresarFabricante(fabr);

        } catch (Exception e) {
            throw e;
        }
    }

}

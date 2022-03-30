
package tienda.persistencia;

import tienda.entidades.Fabricante;



public class FabricanteDAO extends DAO{
    
    public void ingresarFabricante(Fabricante fabr) throws Exception {
        try {
            if (fabr == null) {
                throw new Exception("El fabricante no puede ser nulo");            }

            String template = "INSERT INTO fabricante VALUES (NULL, '%s');";
            String sql = String.format(template, fabr.getNombre());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar fabricante");
        }
    }
    
    
    
    
    
}

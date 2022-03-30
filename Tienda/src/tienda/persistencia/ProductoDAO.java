
package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Producto;


public class ProductoDAO extends DAO{
    
    public List<Producto> traerProductos() throws Exception{
        
        String sql = "SELECT nombre FROM producto;";
        
        queryDatabase(sql);
        
        List<Producto> listaProducto = new ArrayList<>();
        Producto product;
        
        while (resultSet.next()) {
            
            product = new Producto();
            
            product.setCodigo(resultSet.getInt(1));
            product.setFabricante(resultSet.getInt(4));
            product.setNombre(resultSet.getString(2));
            product.setPrecio(resultSet.getDouble(3));
            
            listaProducto.add(product);            
            
        }
    
        return listaProducto;
    }
    
    
    
    
}

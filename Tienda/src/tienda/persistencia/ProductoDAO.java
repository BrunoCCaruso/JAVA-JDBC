package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

public class ProductoDAO extends DAO {
       

    public List<Producto> conseguirProductos() throws Exception {
        try {

            String sql = "SELECT * FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante;";

            queryDatabase(sql);

            List<Producto> listaProducto = new ArrayList<>();
            Producto product=null;
            Fabricante fabr = null;

            while (resultSet.next()) {
               
                product = new Producto();
                fabr =new Fabricante();
                
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                
                fabr.setCodigo(resultSet.getInt(5));
                fabr.setNombre(resultSet.getString(6));
                product.setFabricante(fabr);
                                
                listaProducto.add(product);

            }

            return listaProducto;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar productos");
        }finally {
            disconnectDatabase();
        }
    }
    public List<Producto> conseguirProductosPreciosEntre120y202() throws Exception {
        try {

            String sql = "SELECT * FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante WHERE precio >= 120 AND precio <= 202;";

            queryDatabase(sql);

            List<Producto> listaProducto = new ArrayList<>();
            Producto product=null;
            Fabricante fabr = null;

            while (resultSet.next()) {
               
                product = new Producto();
                fabr =new Fabricante();
                
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                
                fabr.setCodigo(resultSet.getInt(5));
                fabr.setNombre(resultSet.getString(6));
                product.setFabricante(fabr);
                                
                listaProducto.add(product);

            }

            return listaProducto;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar productos");
        }finally {
            disconnectDatabase();
        }
    }
    
    public List<Producto> conseguirProductosPortatiles() throws Exception {
        try {

            String sql = "SELECT * FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante WHERE producto.nombre LIKE 'Portátil%';";

            queryDatabase(sql);

            List<Producto> listaProducto = new ArrayList<>();
            Producto product=null;
            Fabricante fabr = null;

            while (resultSet.next()) {
               
                product = new Producto();
                fabr =new Fabricante();
                
                product.setCodigo(resultSet.getInt(1));
                product.setNombre(resultSet.getString(2));
                product.setPrecio(resultSet.getDouble(3));
                
                fabr.setCodigo(resultSet.getInt(5));
                fabr.setNombre(resultSet.getString(6));
                product.setFabricante(fabr);
                                
                listaProducto.add(product);

            }

            return listaProducto;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar productos");
        }finally {
            disconnectDatabase();
        }
    }       
    
    public List<Producto> conseguirProductoMenorPrecio() throws Exception {
        try {

            String sql = "SELECT producto.nombre, MIN(producto.precio) FROM producto INNER JOIN fabricante ON fabricante.codigo = producto.codigo_fabricante;";

            queryDatabase(sql);

            List<Producto> listaProducto = new ArrayList<>();
            Producto product=null;
            Fabricante fabr = null;

            while (resultSet.next()) {
               
                product = new Producto();
                fabr =new Fabricante();                
                
                product.setNombre(resultSet.getString(1));
                product.setPrecio(resultSet.getDouble(2));                
                
                product.setFabricante(fabr);
                                
                listaProducto.add(product);

            }

            return listaProducto;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar productos");
        }finally {
            disconnectDatabase();
        }
    }
    
    public void ingresarProducto(Producto product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("El producto no puede ser nulo");            }

            String template = "INSERT INTO producto VALUES (NULL, '%s', '%s', '%s');";
            String sql = String.format(template, product.getNombre(), product.getPrecio(), product.getFabricante().getCodigo());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar producto");
        }
    }
       
    
    
}

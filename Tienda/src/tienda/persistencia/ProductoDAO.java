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
    
    
    
    
    
    
    
    
    /*
    public void savePerson(Producto product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("La persona no puede ser nula");
            }

            String template = "INSERT INTO person VALUES (NULL, '%s', '%s', '%s');";
            String sql = String.format(template, product.getFirstName(), person.getLastName(), person.getEmail());

            System.out.println("STATEMENT");
            System.out.println(sql);

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al guardar persona");
        }
    }

    public void modifyPerson(Person person) throws Exception {
        try {
            if (person == null) {
                throw new Exception("La persona no puede ser nula");
            }

            String template = "UPDATE person SET first_name = '%s', last_name = '%s' WHERE person_id = %s;";
            String sql = String.format(template, person.getFirstName(), person.getLastName(), person.getPersonId());

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al modificar persona");
        }
    }

    public void deletePerson(Integer personId) throws Exception {
        try {
            String sql = "DELETE FROM person WHERE person_id = " + personId + ";";

            insertModifyDelete(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al eliminar persona");
        }
    }

    public List<Person> getPeople() throws Exception {
        try {
            String sql = "SELECT * FROM person;";

            queryDatabase(sql);

            List<Person> persons = new ArrayList<>();
            Person person;

            while (resultSet.next()) {
                person = new Person();

                person.setPersonId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
                person.setEmail(resultSet.getString(4));

                persons.add(person);
            }

            return persons;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener personas");
        } finally {
            disconnectDatabase();
        }
    }
    
    public List<Person> getPeopleIdMayor2() throws Exception {
        try {
            String sql = "SELECT * FROM person WHERE person_id > 2;";

            queryDatabase(sql);

            List<Person> persons = new ArrayList<>();
            Person person;

            while (resultSet.next()) {
                person = new Person();

                person.setPersonId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
                person.setEmail(resultSet.getString(4));

                persons.add(person);
            }

            return persons;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error al obtener personas");
        } finally {
            disconnectDatabase();
        }
    }
*/
}


package tienda.entidades;

import java.util.ArrayList;
import java.util.List;

public class Fabricante {
    private int codigo;
    private String nombre;
    private List<Producto> producto = new ArrayList<>();

    public Fabricante() {
    }

    public Fabricante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
    
    
    @Override
    public String toString() {
        return String.format("Fabricante (codigo: %s, nombre: %s, producto: %s )", codigo, nombre, producto);
    }
    
    
    
}

package jc.com.geoscz.entity;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Categoria(){
        this.idCategoria = -1;
        this.nombre = "";
        this.descripcion = "";
    }

    public Categoria(int idCategoria, String descripcion, String nombre) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

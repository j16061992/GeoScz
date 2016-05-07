package jc.com.geoscz.entity;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class ActEco {

    private int id;
    private String seccion;
    private String division;
    private String grupo;
    private String clase;
    private String subClase;
    private String descripcion;
    private int idCategoriaFK;

    public ActEco() {
        this.id = -1;
        this.seccion = "";
        this.division = "";
        this.grupo = "";
        this.clase = "";
        this.subClase = "";
        this.descripcion = "";
        this.idCategoriaFK = -1;
    }

    public ActEco(int id, String seccion, String division, String grupo, String clase, String subClase, String descripcion ,int idCategoriaFK) {
        this.id = id;
        this.seccion = seccion;
        this.division = division;
        this.grupo = grupo;
        this.clase = clase;
        this.subClase = subClase;
        this.descripcion = descripcion;
        this.idCategoriaFK = idCategoriaFK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getSubClase() {
        return subClase;
    }

    public void setSubClase(String subClase) {
        this.subClase = subClase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdCategoriaFK() {
        return idCategoriaFK;
    }

    public void setIdCategoriaFK(int idCategoriaFK) {
        this.idCategoriaFK = idCategoriaFK;
    }

    @Override
    public String toString() {
        return "ActEco{" +
                "id=" + id +
                ", seccion='" + seccion + '\'' +
                ", division='" + division + '\'' +
                ", grupo='" + grupo + '\'' +
                ", clase='" + clase + '\'' +
                ", subClase='" + subClase + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", idCategoriaFK=" + idCategoriaFK +
                '}';
    }
}

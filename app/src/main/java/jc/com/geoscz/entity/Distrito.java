package jc.com.geoscz.entity;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class Distrito {
    //"OBJECTID": "1", "Id": "1", "Monbre": "Distrito uno", "area": 0.000000
    private int idDistrito;
    private String OBJECTID;
    private String idTipo;
    private String nombre;
    private String area;

    public Distrito() {
        this.idDistrito = -1;
        this.OBJECTID = "";
        this.idTipo = "";
        this.nombre = "";
        this.area = "";
    }

    public Distrito(int idDistrito, String OBJECTID, String idTipo, String nombre, String area) {
        this.idDistrito = idDistrito;
        this.OBJECTID = OBJECTID;
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.area = area;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(String OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Distrito{" +
                "idDistrito=" + idDistrito +
                ", OBJECTID='" + OBJECTID + '\'' +
                ", idTipo='" + idTipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

}

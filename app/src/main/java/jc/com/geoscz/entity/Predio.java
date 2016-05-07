package jc.com.geoscz.entity;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class Predio {
    private int idPredio;
    private double latitud;
    private double longitud;
    private int idActEcoFK;

    public Predio() {
        this.idPredio = -1;
        this.latitud = 0;
        this.longitud = 0;
        this.idActEcoFK = -1;
    }

    public Predio(int idPredio, double latitud, double longitud ,int idActEcoFK) {
        this.idPredio = idPredio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idActEcoFK = idActEcoFK;
    }

    public int getIdPredio() {
        return idPredio;
    }

    public void setIdPredio(int idPredio) {
        this.idPredio = idPredio;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getIdActEcoFK() {
        return idActEcoFK;
    }

    public void setIdActEcoFK(int idActEcoFK) {
        this.idActEcoFK = idActEcoFK;
    }

    @Override
    public String toString() {
        return "Predio{" +
                "idPredio=" + idPredio +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", idActEcoFK=" + idActEcoFK +
                '}';
    }

}

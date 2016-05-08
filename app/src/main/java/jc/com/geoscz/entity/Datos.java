package jc.com.geoscz.entity;

/**
 * Created by cesar on 08-05-16.
 */
public class Datos {
    public String agua,alc,gas,luz,manzana,distrito,personas,telfijo,trabajadores;
    public Double latitud,longitud;

    public Datos() {
    }

    public Datos(String agua, String alc, String gas, String luz, String manzana, String distrito, String personas, String telfijo, String trabajadores, Double latitud, Double longitud) {
        this.agua = agua;
        this.alc = alc;
        this.gas = gas;
        this.luz = luz;
        this.manzana = manzana;
        this.distrito = distrito;
        this.personas = personas;
        this.telfijo = telfijo;
        this.trabajadores = trabajadores;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getAlc() {
        return alc;
    }

    public void setAlc(String alc) {
        this.alc = alc;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getTelfijo() {
        return telfijo;
    }

    public void setTelfijo(String telfijo) {
        this.telfijo = telfijo;
    }

    public String getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(String trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "agua='" + agua + '\'' +
                ", alc='" + alc + '\'' +
                ", gas='" + gas + '\'' +
                ", luz='" + luz + '\'' +
                ", manzana='" + manzana + '\'' +
                ", distrito='" + distrito + '\'' +
                ", personas='" + personas + '\'' +
                ", telfijo='" + telfijo + '\'' +
                ", trabajadores='" + trabajadores + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}

package jc.com.geoscz.entity;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class Uvs {
    private int idUvs;
    private String OBJECTID;
    private String IdTipo;
    private int ANILLO;
    private String DIST_MUN;
    private String ET_UV;
    private double latitud;
    private double longitud;

    public Uvs() {
        this.idUvs = -1;
        this.OBJECTID = "";
        IdTipo = "";
        this.ANILLO = 0;
        this.DIST_MUN = "";
        this.ET_UV = "";
        this.latitud = 0;
        this.longitud = 0;
    }

    public Uvs(int idUvs, String OBJECTID, String idTipo, int ANILLO, String DIST_MUN, String ET_UV, double latitud, double longitud) {
        this.idUvs = idUvs;
        this.OBJECTID = OBJECTID;
        IdTipo = idTipo;
        this.ANILLO = ANILLO;
        this.DIST_MUN = DIST_MUN;
        this.ET_UV = ET_UV;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdUvs() {
        return idUvs;
    }

    public void setIdUvs(int idUvs) {
        this.idUvs = idUvs;
    }

    public String getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(String OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    public String getIdTipo() {
        return IdTipo;
    }

    public void setIdTipo(String idTipo) {
        IdTipo = idTipo;
    }

    public int getANILLO() {
        return ANILLO;
    }

    public void setANILLO(int ANILLO) {
        this.ANILLO = ANILLO;
    }

    public String getDIST_MUN() {
        return DIST_MUN;
    }

    public void setDIST_MUN(String DIST_MUN) {
        this.DIST_MUN = DIST_MUN;
    }

    public String getET_UV() {
        return ET_UV;
    }

    public void setET_UV(String ET_UV) {
        this.ET_UV = ET_UV;
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

    @Override
    public String toString() {
        return "Uvs{" +
                "idUvs=" + idUvs +
                ", OBJECTID='" + OBJECTID + '\'' +
                ", IdTipo='" + IdTipo + '\'' +
                ", ANILLO=" + ANILLO +
                ", DIST_MUN='" + DIST_MUN + '\'' +
                ", ET_UV='" + ET_UV + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

}

package jc.com.geoscz.entity;

import com.google.android.gms.maps.model.LatLng;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cesar on 08-05-16.
 */
public class ListaCoordenadas {

    int id;
    String uv;
    List<LatLng> listaPuntos;

    public ListaCoordenadas(int id, List<LatLng> listaPuntos) {
        this.id = id;
        this.listaPuntos = listaPuntos;
    }

    public ListaCoordenadas(String uv, List<LatLng> listaPuntos) {
        this.uv = uv;
        this.listaPuntos = listaPuntos;
    }

    public int getId() {
        return id;
    }

    public List<LatLng> getListaPuntos() {
        return listaPuntos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaPuntos(List<LatLng> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }
}

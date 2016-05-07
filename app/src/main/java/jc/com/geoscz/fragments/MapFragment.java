package jc.com.geoscz.fragments;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.LinkedList;
import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.adapters.AdapterDistrito;
import jc.com.geoscz.adapters.AdapterUvs;
import jc.com.geoscz.entity.Distrito;
import jc.com.geoscz.entity.Uvs;

public class MapFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    protected GoogleApiClient mGoogleApiClient;
    protected LocationRequest mLocationRequest;
    View view;

    public AdapterDistrito adapterDistrito;
    public AdapterUvs adapterUvs;
    RecyclerView recListDistrito;
    RecyclerView recListUvs;

    List<Distrito> distritoList;
    List<Uvs> uvsList;

    public MapFragment(List<Distrito> distritoList,List<Uvs> uvsList) {
        // Required empty public constructor
        this.distritoList = distritoList;
        this.uvsList = uvsList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = (RelativeLayout) inflater.inflate(R.layout.fragment_map, container, false);
            setUpMapIfNeeded();
            buildGoogleApiClient();
        }catch (InflateException e) {
            /* map is already there, just return view as it is */
        }

        recListDistrito = (RecyclerView) view.findViewById(R.id.fragment_distritos_cardList);
        recListDistrito.setHasFixedSize(true);
        LinearLayoutManager llmd = new LinearLayoutManager(getActivity());
        llmd.setOrientation(LinearLayoutManager.VERTICAL);
        recListDistrito.setLayoutManager(llmd);
        adapterDistrito = new AdapterDistrito(getActivity(),distritoList);
        recListDistrito.setAdapter(adapterDistrito);


        recListUvs = (RecyclerView) view.findViewById(R.id.fragment_uvs_cardList);
        recListUvs.setHasFixedSize(true);
        LinearLayoutManager llmuv = new LinearLayoutManager(getActivity());
        llmd.setOrientation(LinearLayoutManager.VERTICAL);
        recListUvs.setLayoutManager(llmuv);
        adapterUvs = new AdapterUvs(getActivity(),uvsList);
        recListUvs.setAdapter(adapterUvs);


        return view;
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map codSpalhi the SupportMapFragment.
            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.location_map)).getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return true;
            }
        });
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);

        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        iniciarGPS();
    }

    private void iniciarGPS() {

        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.reconnect();
        } else {
            mGoogleApiClient.connect();
        }
    }

    private void detenerGPS() {
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();

        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ", "" + location.getAltitude() + " --- " + location.getLongitude());
//        adicionarMarcadorMapa(location.getLatitude(), location.getLongitude());
        adicionarMarcadorMapa(-17.72618, -63.14272);

        List<LatLng> listaPuntos = new LinkedList<>();
        listaPuntos.add(new LatLng(-17.72618,-63.14272));
        listaPuntos.add(new LatLng(-17.72635,-63.14283));
        listaPuntos.add(new LatLng(-17.72617,-63.14311));
        listaPuntos.add(new LatLng(-17.72593,-63.14295));
        listaPuntos.add(new LatLng(-17.72606,-63.14275));

        dibujarPoligono(listaPuntos, Color.RED, 2);

        detenerGPS();

    }

    private void dibujarPoligono(List<LatLng> listaPuntos,int color,int grosor) {
        PolygonOptions rectangulo = new PolygonOptions();

        for (int i=0 ;i<listaPuntos.size();i++){
            rectangulo.add(listaPuntos.get(i));
        }

        rectangulo.strokeWidth(grosor);
        rectangulo.strokeColor(color);

        mMap.addPolygon(rectangulo);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("onConnectionFailed", "Connection failed: ConnectionResult.getErrorCode() = " + connectionResult.getErrorCode());
    }
    private void adicionarMarcadorMapa(double latitude, double longitude) {
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Mi posición actual");
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        // adding marker
        mMap.clear();
        mMap.addMarker(marker);
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 16F);
        mMap.animateCamera(cu);
    }
}

package jc.com.geoscz.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.adapters.AdapterDistrito;
import jc.com.geoscz.adapters.AdapterUvs;
import jc.com.geoscz.bussines.BLLPredio;
import jc.com.geoscz.entity.Datos;
import jc.com.geoscz.entity.Distrito;
import jc.com.geoscz.entity.ListaCoordenadas;
import jc.com.geoscz.entity.Predio;
import jc.com.geoscz.entity.Uvs;
import jc.com.geoscz.iclass.ActualizarDatos;
import jc.com.geoscz.iclass.NotificaDistrito;
import jc.com.geoscz.iclass.NotificaUv;
import jc.com.geoscz.iclass.NotificarPredios;
import jc.com.geoscz.iu.MainActivity;

public class MapFragment extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener,NotificaDistrito,NotificaUv {

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

    List<ListaCoordenadas> distritos;
    List<ListaCoordenadas> uvs;
    Context context;

    BLLPredio bllPredio;

    List<Predio> seleccionados;
    List<Datos> datosList;

    ActualizarDatos actualizarDatos;


    public MapFragment(Context context,List<Distrito> distritoList,List<Uvs> uvsList,Boolean buscarPre) {
        // Required empty public constructor
        this.distritoList = distritoList;
        this.uvsList = uvsList;
        distritos = new LinkedList<>();
        uvs = new LinkedList<>();
        uvs = new LinkedList<>();
        seleccionados = new LinkedList<>();
        datosList = new LinkedList<>();
        this.context = context;
        bllPredio = new BLLPredio(context);
        seleccionados = bllPredio.getAll();
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
        adapterDistrito.add(this);


        recListUvs = (RecyclerView) view.findViewById(R.id.fragment_uvs_cardList);
        recListUvs.setHasFixedSize(true);
        LinearLayoutManager llmuv = new LinearLayoutManager(getActivity());
        llmd.setOrientation(LinearLayoutManager.VERTICAL);
        recListUvs.setLayoutManager(llmuv);
        adapterUvs = new AdapterUvs(getActivity(),uvsList);
        recListUvs.setAdapter(adapterUvs);
        adapterUvs.add(this);

        if(seleccionados.size()>0){
            ThreadPredios threadPredios = new ThreadPredios(context,seleccionados);
            threadPredios.execute();
        }




        return view;
    }

    public void add(ActualizarDatos actualizarDatos1){
        actualizarDatos = actualizarDatos1;
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
        adicionarMarcadorMapa(location.getLatitude(), location.getLongitude());
        detenerGPS();

    }

    private void dibujarPoligono(List<LatLng> listaPuntos,int color,int grosor) {
//        mMap.clear();

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
//        mMap.clear();
        mMap.addMarker(marker);
//        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 16F);
//        mMap.animateCamera(cu);
    }

    @Override
    public void notificaDistrito(Distrito distrito) {
        ThreadDistritos threadDistritos = new ThreadDistritos(context,distrito.getIdDistrito());
        threadDistritos.execute();
    }

    @Override
    public void notificaUv(Uvs uvs) {
        Log.d("FFFF","---------------------------------------------------------------------------------------- JULIO CESAR : "+uvs.toString());
    }


//    ------------------------------------------------------TRAE DISTRITOS------------------------------------------------------------------

    public class ThreadDistritos extends AsyncTask <Void, Void, Void>{

    String respuesta = "";
    Context context;
    int id;
    List<LatLng> list = new LinkedList<>();

    public ThreadDistritos(Context context,int id)
    {
        this.context = context;
        this.id = id;
    }



        @Override
        protected Void doInBackground(Void... params) {
            String serverUrl = "http://192.168.43.200/Hackaton/service/getDistrito.php";

            InputStream inputStream = null;

            try {
                HttpClient httpClient = new DefaultHttpClient();
//
                HttpPost httpPost = new HttpPost(serverUrl);
                List<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("id", id + ""));
                httpPost.setEntity(new UrlEncodedFormEntity(parms));

                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();

                respuesta = EntityUtils.toString(entity);

                Log.d("-------------------------------------------------------- RESPONDE  ",respuesta);



                JSONArray jArray = new JSONArray(respuesta);
                for(int i=0; i<jArray.length(); i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    list.add(new LatLng(json_data.getDouble("longitud"),json_data.getDouble("latitud")));
//                Log.i("log_tag", "****************************************************  latitud" + json_data.getDouble("latitud") +
//                                ", longitud" + json_data.getDouble("longitud")
//                );
                }
            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            distritos.add(new ListaCoordenadas(id,list));
            dibujarPoligono(list,Color.GREEN,5);
        }


    }


    //    ------------------------------------------------------TRAE PREDIOS------------------------------------------------------------------

    public class ThreadPredios extends AsyncTask <Void, Void, Void>{

        String respuesta = "";
        Context context;
        List<Predio> predios;

        public ThreadPredios(Context context,List<Predio> predios)
        {
            this.context = context;
            this.predios= predios;
        }



        @Override
        protected Void doInBackground(Void... params) {
            String serverUrl = "http://192.168.43.200/Hackaton/service/getPredios.php";

            String a="851101";
            String b="";
            String c="";
            String d="";
            String f="851104";

//            for (int i = 0; i < list.size(); i++) {
//
////                System.out.println("****************************************************************************** "+MainActivity.OPCIONES_ELEGIDAS.get(i));
//                switch (i){
//                    case 0 : a =  list.get(i).getSubClase();break;
//                    case 1 : b =  list.get(i).getSubClase();break;
//                    case 2 : c =  list.get(i).getSubClase();break;
//                    case 3 : d =  list.get(i).getSubClase();break;
//                    case 4 : f =  list.get(i).getSubClase();break;
//                }
//
//            }


            try {
                HttpClient httpClient = new DefaultHttpClient();
//
                HttpPost httpPost = new HttpPost(serverUrl);
                List<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("a", a));
                parms.add(new BasicNameValuePair("b", b));
                parms.add(new BasicNameValuePair("c", c));
                parms.add(new BasicNameValuePair("d", d));
                parms.add(new BasicNameValuePair("f", f));
                httpPost.setEntity(new UrlEncodedFormEntity(parms));





                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();

                respuesta = EntityUtils.toString(entity);

                Log.d("-------------------------------------------------------- RESPONDE  ",respuesta);


                JSONArray jArray = new JSONArray(respuesta);
                for(int i=0; i<jArray.length(); i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    Datos dat=new Datos();
                    dat.agua = json_data.getString("agua");
                    dat.alc = json_data.getString("alc");
                    dat.gas = json_data.getString("gas");
                    dat.luz = json_data.getString("luz");
                    dat.manzana = json_data.getString("manzana");
                    dat.distrito = json_data.getString("distrito");
                    dat.personas = json_data.getString("personas");
                    dat.telfijo = json_data.getString("telfijo");
                    dat.trabajadores = json_data.getString("trabajadores");
                    dat.latitud = Double.parseDouble(json_data.getDouble("latitud") + "");
                    dat.longitud =Double.parseDouble( json_data.getDouble("longitud")+"");

                    datosList.add(dat);

//                    list.add(new LatLng(json_data.getDouble("longitud"),json_data.getDouble("latitud")));
//                Log.i("log_tag", "****************************************************  latitud" + json_data.getDouble("latitud") +
//                                ", longitud" + json_data.getDouble("longitud")
//                );
                }
            } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            for (int i = 0; i < datosList.size(); i++) {
                adicionarMarcadorMapa(datosList.get(i).getLongitud(),datosList.get(i).getLatitud());
            }


        }


    }

}

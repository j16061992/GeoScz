package jc.com.geoscz.iu;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.util.LinkedList;
import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.bussines.BLLCategoria;
import jc.com.geoscz.bussines.BLLDistrito;
import jc.com.geoscz.bussines.BLLUvs;
import jc.com.geoscz.entity.Categoria;
import jc.com.geoscz.entity.Distrito;
import jc.com.geoscz.entity.Uvs;
import jc.com.geoscz.fragments.EstadisticaFragment;
import jc.com.geoscz.fragments.MainFragment;
import jc.com.geoscz.fragments.MapFragment;
import jc.com.geoscz.threads.ThreadDistritos;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    ImageButton btn_datos,btn_map,btn_estadisticas;

    List<Distrito> distritoList;
    List<Uvs> uvsList;
    List<Categoria> categoriaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_datos = (ImageButton) findViewById(R.id.ImgBtnDatos);
        btn_datos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_DATOS);
            }
        });
        btn_map = (ImageButton) findViewById(R.id.ImgBtnMapa);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_MAP);
            }
        });
        btn_estadisticas = (ImageButton) findViewById(R.id.ImgBtnEstadistica);
        btn_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(FRAGMENT_ESTADISTICA);
                ThreadDistritos threadDistritos = new ThreadDistritos(MainActivity.this);
                threadDistritos.execute();
            }
        });

        distritoList = new LinkedList<>();
        uvsList = new LinkedList<>();

        BLLDistrito bllDistrito= new BLLDistrito(MainActivity.this);
        distritoList = bllDistrito.getAll();
//        bllDistrito.imprimirDistritos();

        BLLUvs bllUvs =new BLLUvs(MainActivity.this);
        uvsList = bllUvs.getAll();
//        bllUvs.imprimirDistritos();

        BLLCategoria bllCategoria =new BLLCategoria(MainActivity.this);
        categoriaList = bllCategoria.getAll();
    }

    public static final int FRAGMENT_DATOS = 1;
    public static final int FRAGMENT_MAP = 2;
    public static final int FRAGMENT_ESTADISTICA = 3;

    public void replaceFragment(int typeOfFragment) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragment);
        frameLayout.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (typeOfFragment) {
            case FRAGMENT_DATOS:
                MainFragment mainFragment = new MainFragment(categoriaList,null);
                fragmentTransaction.replace(R.id.fragment, mainFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;
            case FRAGMENT_MAP:
                MapFragment mapFragment= new MapFragment(distritoList,uvsList);
                fragmentTransaction.replace(R.id.fragment, mapFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;
            case FRAGMENT_ESTADISTICA:
                EstadisticaFragment estadisticaFragment = new EstadisticaFragment();
                fragmentTransaction.replace(R.id.fragment, estadisticaFragment);
//                PRINCIPAL = IUMAIN_HOME;
                break;

        }
        fragmentTransaction.commit();
    }
}

package jc.com.geoscz.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.adapters.AdapterCategoria;
import jc.com.geoscz.adapters.AdapterDistrito;
import jc.com.geoscz.entity.ActEco;
import jc.com.geoscz.entity.Categoria;


public class MainFragment extends Fragment {

    public AdapterCategoria adapterCategoria;
    RecyclerView recListCategoria;
    View view;

    List<Categoria> categoriaList;
    List<ActEco> actEcoList;

    public MainFragment(List<Categoria> categoriaList,List<ActEco> actEcoList) {
        // Required empty public constructor
        this.categoriaList = categoriaList;
        this.actEcoList = actEcoList;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }

        view = (RelativeLayout) inflater.inflate(R.layout.fragment_main, container, false);

        recListCategoria = (RecyclerView) view.findViewById(R.id.cv_tipo);
        recListCategoria.setHasFixedSize(true);
        LinearLayoutManager llmd = new LinearLayoutManager(getActivity());
        llmd.setOrientation(LinearLayoutManager.VERTICAL);
        recListCategoria.setLayoutManager(llmd);
        adapterCategoria = new AdapterCategoria(getActivity(),categoriaList);
        recListCategoria.setAdapter(adapterCategoria);

        // Inflate the layout for this fragment
        return view;
    }





}

package jc.com.geoscz.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.adapters.AdapterCategoria;
import jc.com.geoscz.adapters.AdapterDistrito;
import jc.com.geoscz.adapters.AdapterSocioEconomico;
import jc.com.geoscz.bussines.BLLActEco;
import jc.com.geoscz.entity.ActEco;
import jc.com.geoscz.entity.Categoria;
import jc.com.geoscz.global.RecyclerItemClickListener;


public class MainFragment extends Fragment {

    Context context;
    public AdapterCategoria adapterCategoria;
    public AdapterSocioEconomico adapterSocioEconomico;
    RecyclerView recListCategoria;
    RecyclerView recListSocioEco;
    View view;

    List<Categoria> categoriaList;
    List<ActEco> actEcoList;

    BLLActEco bllActEco;

    public MainFragment(Context context,List<Categoria> categoriaList) {
        // Required empty public constructor
        this.context = context;
        this.categoriaList = categoriaList;

        bllActEco =new BLLActEco(this.context);
        this.actEcoList = bllActEco.getAll(1);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }

        //

        view = (RelativeLayout) inflater.inflate(R.layout.fragment_main, container, false);

        recListCategoria = (RecyclerView) view.findViewById(R.id.cv_tipo);
        recListCategoria.setHasFixedSize(true);
        LinearLayoutManager llmd = new LinearLayoutManager(getActivity());
        llmd.setOrientation(LinearLayoutManager.VERTICAL);
        recListCategoria.setLayoutManager(llmd);
        adapterCategoria = new AdapterCategoria(getActivity(),categoriaList);
        recListCategoria.setAdapter(adapterCategoria);

        recListSocioEco = (RecyclerView) view.findViewById(R.id.cv_act_eco);
        recListSocioEco.setHasFixedSize(true);
        LinearLayoutManager llmd1 = new LinearLayoutManager(getActivity());
        llmd1.setOrientation(LinearLayoutManager.VERTICAL);
        recListSocioEco.setLayoutManager(llmd1);
        adapterSocioEconomico = new AdapterSocioEconomico(getActivity(),actEcoList);
        recListSocioEco.setAdapter(adapterSocioEconomico);


        recListCategoria.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recListCategoria, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Log.d("*************************************************************  ", categoriaList.get(position).toString());

                actEcoList = bllActEco.getAll(categoriaList.get(position).getIdCategoria());
                adapterSocioEconomico = new AdapterSocioEconomico(getActivity(),actEcoList);
                recListSocioEco.setAdapter(adapterSocioEconomico);
            }

            @Override
            public void onItemLongClick(View view, int position) {
//                Snackbar.make(view, sFavorites.get(position).email, Snackbar.LENGTH_SHORT).show();
            }
        }));


        // Inflate the layout for this fragment
        return view;
    }





}

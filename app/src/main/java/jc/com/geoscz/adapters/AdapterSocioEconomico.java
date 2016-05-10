package jc.com.geoscz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.bussines.BLLPredio;
import jc.com.geoscz.entity.ActEco;
import jc.com.geoscz.entity.Categoria;
import jc.com.geoscz.entity.Predio;
import jc.com.geoscz.iu.MainActivity;

/**
 * Created by cesar on 07-05-16.
 */





public class AdapterSocioEconomico extends RecyclerView.Adapter<AdapterSocioEconomico.SocioEcoViewHolder> {

    private List<ActEco> actEcoList;
    private Context context;
    int isNull=-1;
    BLLPredio bllPredio;
    List<Predio> predios;

    public AdapterSocioEconomico(Context ctx,List<ActEco> actEcoList) {
        this.context = ctx;
        this.actEcoList = actEcoList;



        bllPredio = new BLLPredio(context);
        predios = bllPredio.getAll();

//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+actEcoList.toString());
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ "+predios.toString());
    }

    @Override
    public int getItemCount() {
        return actEcoList.size();
    }


    @Override
    public void onBindViewHolder(final AdapterSocioEconomico.SocioEcoViewHolder distritoViewHolder, final int i) {
        distritoViewHolder.tv_adapter_acteco_titulo.setText(actEcoList.get(i).getDescripcion());
        distritoViewHolder.tv_adapter_acteco_cod.setText(actEcoList.get(i).getSubClase());


        if(existe(predios,actEcoList.get(i).getSubClase())){
            distritoViewHolder.cb_act_eco.setChecked(true);
        }else{
            distritoViewHolder.cb_act_eco.setChecked(false);
        }

        distritoViewHolder.rl_act_eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (distritoViewHolder.cb_act_eco.isChecked()) {
                    distritoViewHolder.cb_act_eco.setChecked(false);

                    bllPredio.delete(actEcoList.get(i).getSubClase());
//                    if(!existe(actEcoList.get(i).getSubClase())){
//                        eliminar(actEcoList.get(i).getSubClase());
//                    }
                } else {
                    distritoViewHolder.cb_act_eco.setChecked(true);
//                    if(existe(actEcoList.get(i).getSubClase())){
//                        MainActivity.OPCIONES_ELEGIDAS.add(actEcoList.get(i).getSubClase());
//                    }
                    Predio predio = new Predio();
                    predio.setSubClase(actEcoList.get(i).getSubClase());

                    bllPredio.insert(predio);
                }
            }
        });

        distritoViewHolder.cb_act_eco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (distritoViewHolder.cb_act_eco.isChecked()) {
                    distritoViewHolder.cb_act_eco.setChecked(false);

                    bllPredio.delete(actEcoList.get(i).getSubClase());
//                    if(!existe(actEcoList.get(i).getSubClase())){
//                        eliminar(actEcoList.get(i).getSubClase());
//                    }
                } else {
                    distritoViewHolder.cb_act_eco.setChecked(true);
//                    if(existe(actEcoList.get(i).getSubClase())){
//                        MainActivity.OPCIONES_ELEGIDAS.add(actEcoList.get(i).getSubClase());
//                    }
                    Predio predio = new Predio();
                    predio.setSubClase(actEcoList.get(i).getSubClase());

                    bllPredio.insert(predio);
                }
            }
        });


    }



    public boolean existe(List<Predio> predios1,String id){

        for (int i = 0; i < predios1.size(); i++) {

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  * -"+predios1.get(i).getSubClase()+"+"+id+"+" );
            if(predios1.get(i).getSubClase().equals(id)) return true;
        }
        return  false;
    }

    public void eliminar(String id){
        List<String> aux = new LinkedList<>();
        for (int i = 0; i < MainActivity.OPCIONES_ELEGIDAS.size(); i++) {
            if(MainActivity.OPCIONES_ELEGIDAS.get(i)!=id){
                aux.add(MainActivity.OPCIONES_ELEGIDAS.get(i));
            }
        }
        MainActivity.OPCIONES_ELEGIDAS = aux;
    }

    @Override
    public SocioEcoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_act_economico, viewGroup, false);

        return new SocioEcoViewHolder(itemView);
    }



    public static class SocioEcoViewHolder extends RecyclerView.ViewHolder {


        protected RelativeLayout rl_act_eco;
        protected CheckBox cb_act_eco;
        protected TextView tv_adapter_acteco_titulo,tv_adapter_acteco_cod;


        public SocioEcoViewHolder(View v) {
            super(v);
            rl_act_eco = (RelativeLayout) v.findViewById(R.id.rl_act_eco);
            cb_act_eco = (CheckBox) v.findViewById(R.id.cb_act_eco);
            tv_adapter_acteco_titulo = (TextView) v.findViewById(R.id.tv_adapter_acteco_titulo);
            tv_adapter_acteco_cod = (TextView) v.findViewById(R.id.tv_adapter_acteco_cod);
        }
    }
}

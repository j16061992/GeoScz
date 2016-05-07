package jc.com.geoscz.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.entity.ActEco;
import jc.com.geoscz.entity.Categoria;

/**
 * Created by cesar on 07-05-16.
 */





public class AdapterSocioEconomico extends RecyclerView.Adapter<AdapterSocioEconomico.SocioEcoViewHolder> {

    private List<ActEco> actEcoList;
    private Context context;
    int isNull=-1;

    public AdapterSocioEconomico(Context ctx,List<ActEco> actEcoList) {
        this.context = ctx;
        this.actEcoList = actEcoList;

    }

    @Override
    public int getItemCount() {
        return actEcoList.size();
    }


    @Override
    public void onBindViewHolder(AdapterSocioEconomico.SocioEcoViewHolder distritoViewHolder, final int i) {
        distritoViewHolder.tv_adapter_acteco_titulo.setText(actEcoList.get(i).getDescripcion());
        distritoViewHolder.tv_adapter_acteco_cod.setText(actEcoList.get(i).getClase());
    }

    @Override
    public SocioEcoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_act_economico, viewGroup, false);

        return new SocioEcoViewHolder(itemView);
    }



    public static class SocioEcoViewHolder extends RecyclerView.ViewHolder {


        protected CheckBox cb_act_eco;
        protected TextView tv_adapter_acteco_titulo,tv_adapter_acteco_cod;


        public SocioEcoViewHolder(View v) {
            super(v);
            cb_act_eco = (CheckBox) v.findViewById(R.id.cb_act_eco);
            tv_adapter_acteco_titulo = (TextView) v.findViewById(R.id.tv_adapter_acteco_titulo);
            tv_adapter_acteco_cod = (TextView) v.findViewById(R.id.tv_adapter_acteco_cod);
        }
    }
}

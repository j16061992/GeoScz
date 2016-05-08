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

import java.util.ArrayList;
import java.util.List;

import jc.com.geoscz.R;
import jc.com.geoscz.entity.Distrito;
import jc.com.geoscz.entity.Uvs;


public class AdapterUvs extends RecyclerView.Adapter<AdapterUvs.DistritoViewHolder> {

    private List<Uvs> uvsList;
    private Context context;
    int isNull=-1;

    public AdapterUvs(Context ctx,List<Uvs> uvsList) {
        this.context = ctx;
        this.uvsList = uvsList;

    }

    @Override
    public int getItemCount() {
        return uvsList.size();
    }


    @Override
    public void onBindViewHolder(final AdapterUvs.DistritoViewHolder distritoViewHolder, final int i) {
            distritoViewHolder.tv_adapter_uvs.setText(uvsList.get(i).getET_UV());
            distritoViewHolder.rl_uvs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(distritoViewHolder.cb_uvs.isChecked()){
                        distritoViewHolder.cb_uvs.setChecked(false);
                    }else {
                        distritoViewHolder.cb_uvs.setChecked(true);
                    }
                }
            });

    }



    @Override
    public DistritoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_uvs, viewGroup, false);

        return new DistritoViewHolder(itemView);
    }



    public static class DistritoViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_adapter_uvs;
        protected TextView tv_adapter_uvs;
        protected CheckBox cb_uvs;
        protected RelativeLayout rl_uvs;


        public DistritoViewHolder(View v) {
            super(v);
            iv_adapter_uvs = (ImageView) v.findViewById(R.id.iv_adapter_uvs);
            tv_adapter_uvs = (TextView) v.findViewById(R.id.tv_adapter_uvs);
            cb_uvs = (CheckBox) v.findViewById(R.id.cb_uvs);
            rl_uvs = (RelativeLayout) v.findViewById(R.id.rl_uvs);
        }
    }
}

package jc.com.geoscz.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
//        this.uvsList = new ArrayList<>();
//        uvsList.add(new Uvs(1,"aaaa","aaaa",8,"aaaa","aaaa",-63.2356,-36.115));
//        uvsList.add(new Uvs(1,"bbbbb","bbbbb",8,"bbbbb","bbbbb",-63.2356,-36.115));
//        uvsList.add(new Uvs(1,"cccc","cccc",8,"cccc","cccc",-63.2356,-36.115));

    }

    @Override
    public int getItemCount() {
        return uvsList.size();
    }


    @Override
    public void onBindViewHolder(AdapterUvs.DistritoViewHolder distritoViewHolder, final int i) {
            distritoViewHolder.tv_adapter_uvs.setText(uvsList.get(i).getET_UV());
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


        public DistritoViewHolder(View v) {
            super(v);
            iv_adapter_uvs = (ImageView) v.findViewById(R.id.iv_adapter_uvs);
            tv_adapter_uvs = (TextView) v.findViewById(R.id.tv_adapter_uvs);
        }
    }
}

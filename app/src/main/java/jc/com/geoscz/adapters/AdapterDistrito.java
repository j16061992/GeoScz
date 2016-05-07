package jc.com.geoscz.adapters;




        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Color;
        import android.support.v7.widget.RecyclerView;
        import android.text.Html;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;

        import jc.com.geoscz.R;
        import jc.com.geoscz.entity.Distrito;


public class AdapterDistrito extends RecyclerView.Adapter<AdapterDistrito.DistritoViewHolder> {

    private List<Distrito> distritoList;
    private Context context;
    int isNull=-1;

    public AdapterDistrito(Context ctx,List<Distrito> distritoList) {
        this.context = ctx;
        this.distritoList = distritoList;
//        this.distritoList = new ArrayList<>();
//        distritoList.add(new Distrito(1,"aaa","aaaa","aaaa","aaaa"));
//        distritoList.add(new Distrito(1,"bbb","bbb","bbb","bbb"));
//        distritoList.add(new Distrito(1,"ccc","ccc","ccc","ccc"));


    }

    @Override
    public int getItemCount() {
        return distritoList.size();
    }


    @Override
    public void onBindViewHolder(AdapterDistrito.DistritoViewHolder distritoViewHolder, final int i) {
            distritoViewHolder.tv_adapter_distrito.setText(distritoList.get(i).getNombre());
    }

    @Override
    public DistritoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_distritos, viewGroup, false);

        return new DistritoViewHolder(itemView);
    }



    public static class DistritoViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_adapter_distrito_;
        protected TextView tv_adapter_distrito;


        public DistritoViewHolder(View v) {
            super(v);
            iv_adapter_distrito_ = (ImageView) v.findViewById(R.id.iv_adapter_distrito);
            tv_adapter_distrito = (TextView) v.findViewById(R.id.tv_adapter_distrito);
        }
    }
}

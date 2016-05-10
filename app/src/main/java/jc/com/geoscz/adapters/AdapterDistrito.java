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
        import android.widget.CheckBox;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;

        import jc.com.geoscz.R;
        import jc.com.geoscz.entity.Distrito;
        import jc.com.geoscz.iclass.NotificaDistrito;


public class AdapterDistrito extends RecyclerView.Adapter<AdapterDistrito.DistritoViewHolder> {

    private List<Distrito> distritoList;
    private Context context;
    int isNull=-1;
    NotificaDistrito notificaDistrito;

    public AdapterDistrito(Context ctx,List<Distrito> distritoList) {
        this.context = ctx;
        this.distritoList = distritoList;
//        this.distritoList = new ArrayList<>();
//        distritoList.add(new Distrito(1,"aaa","aaaa","aaaa","aaaa"));
//        distritoList.add(new Distrito(1,"bbb","bbb","bbb","bbb"));
//        distritoList.add(new Distrito(1,"ccc","ccc","ccc","ccc"));


    }

    public void add(NotificaDistrito notifica){
        notificaDistrito = notifica;
    }

    @Override
    public int getItemCount() {
        return distritoList.size();
    }


    @Override
    public void onBindViewHolder(final AdapterDistrito.DistritoViewHolder distritoViewHolder, final int i) {

            distritoViewHolder.tv_adapter_distrito.setText(distritoList.get(i).getNombre());
            distritoViewHolder.rl_distritos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (distritoViewHolder.cb_distritos.isChecked()) {
                        distritoViewHolder.cb_distritos.setChecked(false);
                    } else {
                        distritoViewHolder.cb_distritos.setChecked(true);
                        notificaDistrito.notificaDistrito(distritoList.get(i));
                    }
                }
            });

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
        protected RelativeLayout rl_distritos;
        protected CheckBox cb_distritos;


        public DistritoViewHolder(View v) {
            super(v);
            iv_adapter_distrito_ = (ImageView) v.findViewById(R.id.iv_adapter_distrito);
            tv_adapter_distrito = (TextView) v.findViewById(R.id.tv_adapter_distrito);
            rl_distritos = (RelativeLayout) v.findViewById(R.id.rl_distritos);
            cb_distritos = (CheckBox) v.findViewById(R.id.cb_distritos);
        }
    }
}

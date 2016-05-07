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
        import jc.com.geoscz.entity.Categoria;
        import jc.com.geoscz.entity.Distrito;


public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder> {

    private List<Categoria> categoriaList;
    private Context context;
    int isNull=-1;

    public AdapterCategoria(Context ctx,List<Categoria> categoriaList) {
        this.context = ctx;
        this.categoriaList = categoriaList;

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }


    @Override
    public void onBindViewHolder(AdapterCategoria.CategoriaViewHolder distritoViewHolder, final int i) {
        distritoViewHolder.et_adapter_categori.setText(categoriaList.get(i).getNombre());
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview_categorias, viewGroup, false);

        return new CategoriaViewHolder(itemView);
    }



    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_adapter_categori;
        protected TextView et_adapter_categori;


        public CategoriaViewHolder(View v) {
            super(v);
            iv_adapter_categori = (ImageView) v.findViewById(R.id.iv_adapter_categori);
            et_adapter_categori = (TextView) v.findViewById(R.id.et_adapter_categori);
        }
    }
}

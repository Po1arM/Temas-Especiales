package pucmm.eitc.primerparcial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.ItemViewHolder>{
    private final Context context;
    private final ArrayList<Articulo> articulos;

    public LayoutAdapter(Context context, ArrayList<Articulo> courseModelArrayList) {
        this.context = context;
        this.articulos = courseModelArrayList;
    }

    @NonNull
    @Override
    public LayoutAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout , parent , false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutAdapter.ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Articulo articulo = articulos.get(position);

        holder.articulo.setText(articulo.getArticulo());
        holder.descripcion.setText(articulo.getDescripcion());
        holder.precio.setText(articulo.getPrecio().toString());

        holder.borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articulos.remove(position);
                MainActivity.layoutAdapter.notifyDataSetChanged();
            }
        });

        holder.compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return articulos.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView articulo, descripcion, precio;
        Button borrar, compartir;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            articulo = itemView.findViewById(R.id.articuloName);
            descripcion = itemView.findViewById(R.id.articuloDescription);
            precio = itemView.findViewById(R.id.articuloPrice);
            borrar = itemView.findViewById(R.id.deleteBtn);
            compartir = itemView.findViewById(R.id.shareBtn);

        }
    }
}

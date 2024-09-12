package adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import model.ItemListCoches;

import com.example.proyecto.R;
import com.example.proyecto.Utilidades.DetailActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterCoches extends RecyclerView.Adapter<RecyclerAdapterCoches.RecyclerHolder>{

    private List<ItemListCoches> items;
    private RecyclerItemClick itemClick;

    public RecyclerAdapterCoches(List<ItemListCoches> items, RecyclerItemClick itemClick) {
        this.items = items;
        this.itemClick = itemClick;
    }


    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_coches, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, final int position) {
        final ItemListCoches item = items.get(position);
        holder.imageViewCoche.setImageResource(item.getImgCoche());
        holder.tvModelo.setText(item.getModelo());
        holder.tvPrecio.setText(item.getPrecio());
        holder.tvCombustible.setText(item.getCombustible());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("itemDetail", item); //item de la clase onBindViewHolder de arriba que contiene la imagen, titulo y descripcion
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewCoche;
        private TextView tvModelo;
        private TextView tvPrecio;
        private TextView tvCombustible;

        public RecyclerHolder(@NonNull View itemView){
            super(itemView);

            imageViewCoche = itemView.findViewById(R.id.imgItemCoche);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvCombustible = itemView.findViewById(R.id.tvCombustible);
        }

    }

    public interface RecyclerItemClick {
        void itemClick(ItemListCoches item);
    }
}

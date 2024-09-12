package adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.proyecto.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import model.ItemList;
import model.ItemListCoches;

import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private List<ItemList> items;
    private RecyclerItemClick itemClick;
    public RecyclerAdapter(List<ItemList> items, RecyclerItemClick itemClick) {
        this.items = items;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescription.setText(item.getDescripcion());
        holder.tvSlogan.setText(item.getSlogan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView tvTitulo;
        private TextView tvDescription;
        private TextView tvSlogan;
        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescription = itemView.findViewById(R.id.tvDescripcion);
            tvSlogan = itemView.findViewById(R.id.tvSlogan);
        }
    }


    public interface RecyclerItemClick {
        void itemClick(ItemList item);
    }

}

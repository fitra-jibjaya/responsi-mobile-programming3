package com.example.jual_ajalah.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jual_ajalah.R;
import com.example.jual_ajalah.model.Barang;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ListViewHolder> {

    private final ArrayList<Barang> listBarang;
    private OnItemClickCallback onItemClickCallback;


    public BarangAdapter(ArrayList<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_barang, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        Barang barang = listBarang.get(position);
        Glide.with(holder.itemView.getContext())
                .load(barang.getImage())
                .apply(new RequestOptions())
                .into(holder.img_barang);
        holder.name.setText(barang.getBrg_name());
        holder.jenis.setText(barang.getJenis());
        holder.price.setText(barang.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listBarang.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_barang;
        TextView name, jenis, price;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_barang = itemView.findViewById(R.id.img_brg);
            name = itemView.findViewById(R.id.nm_brg);
            jenis = itemView.findViewById(R.id.jn_brg);
            price = itemView.findViewById(R.id.harga);


        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Barang barang);
    }
}

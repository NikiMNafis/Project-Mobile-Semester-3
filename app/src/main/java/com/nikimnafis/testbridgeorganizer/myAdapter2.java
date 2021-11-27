package com.nikimnafis.testbridgeorganizer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class myAdapter2 extends FirebaseRecyclerAdapter<model, myAdapter2.myViewHolder> {

    public myAdapter2( @NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull model model) {
        holder.txtNama.setText(model.getNama());
        holder.txtStatus.setText(model.getStatus());
        Glide.with(holder.imgAnggota.getContext()).load(model.getGurl()).into(holder.imgAnggota);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_anggota, parent, false);

        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAnggota;
        TextView txtNama, txtStatus;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgAnggota = itemView.findViewById(R.id.img_anggota);
            txtNama = itemView.findViewById(R.id.txt_nama_anggota);
            txtStatus = itemView.findViewById(R.id.txt_status_anggota);
        }
    }
}

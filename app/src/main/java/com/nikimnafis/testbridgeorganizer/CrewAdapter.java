package com.nikimnafis.testbridgeorganizer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.ViewHolder> {

    private ArrayList<CrewHelper> crewHelper;

    public CrewAdapter(ArrayList<CrewHelper> crewHelper) {
        this.crewHelper = crewHelper;
    }

    @NonNull
    @Override
    public CrewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_crew, parent, false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CrewAdapter.ViewHolder holder, int position) {

        holder.namaCrew.setText(crewHelper.get(position).getNamaCrew());
        holder.statusCrew.setText(crewHelper.get(position).getStatusCrew());
        holder.imgCrew.setImageResource(crewHelper.get(position).getImgCrew());

    }

    @Override
    public int getItemCount() {
        return crewHelper.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namaCrew, statusCrew;
        ImageView imgCrew;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            namaCrew = itemView.findViewById(R.id.txt_nama_crew);
            statusCrew = itemView.findViewById(R.id.txt_status_crew);
            imgCrew = itemView.findViewById(R.id.img_crew);
        }
    }
}

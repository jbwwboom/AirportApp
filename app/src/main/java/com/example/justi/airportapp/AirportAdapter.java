package com.example.justi.airportapp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportViewHolder> {

    private ArrayList<Airport> dataset;

    public AirportAdapter(ArrayList<Airport> dataset) {
        this.dataset = dataset;
    }

    public class AirportViewHolder extends RecyclerView.ViewHolder {

        public TextView icao, name;

        public AirportViewHolder(View itemView) {
            super(itemView);
            icao = itemView.findViewById(R.id.icao);
            name = itemView.findViewById(R.id.name);
        }
    }

    @NonNull
    @Override
    public AirportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listview_row, parent, false);
        return new AirportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AirportViewHolder holder, int position) {

        final Airport airport = dataset.get(position);
        holder.icao.setText(airport.getIcao());
        holder.name.setText(airport.getName());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}


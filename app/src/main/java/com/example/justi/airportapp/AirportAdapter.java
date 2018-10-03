package com.example.justi.airportapp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AirportAdapter extends RecyclerView.Adapter<AirportAdapter.AirportViewHolder> implements Filterable {

    private ArrayList<Airport> dataset;
    private ArrayList<Airport> filteredDataset;

    public ArrayList<Airport> getDataset() {
        return dataset;
    }

    public ArrayList<Airport> getFilteredDataset() {
        return filteredDataset;
    }

    public AirportAdapter(ArrayList<Airport> dataset) {
        this.dataset = dataset;
        this.filteredDataset = dataset;
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
        final Airport airport = filteredDataset.get(position);
        holder.icao.setText(airport.getIcao());
        holder.name.setText(airport.getName());
    }

    @Override
    public int getItemCount() {
        return filteredDataset.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredDataset = dataset;
                } else {
                    ArrayList<Airport> filteredList = new ArrayList<>();
                    for (Airport airport : dataset) {

                        if (airport.getIcao().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(airport);
                        }
                    }

                    filteredDataset = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredDataset;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredDataset = (ArrayList<Airport>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }
}


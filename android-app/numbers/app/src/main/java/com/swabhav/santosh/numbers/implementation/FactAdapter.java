package com.swabhav.santosh.numbers.implementation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swabhav.santosh.numbers.R;

import java.util.ArrayList;
import java.util.List;

public class FactAdapter extends RecyclerView.Adapter<FactAdapter.ViewHolder> {

    private List<String> facts;

    public FactAdapter(ArrayList<String> facts) {
        this.facts = facts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView indexData, randomFactData;
        int i =1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            indexData = (TextView) itemView.findViewById(R.id.indexData);
            randomFactData = (TextView) itemView.findViewById(R.id.randomFactData);
        }
    }

    @NonNull
    @Override
    public FactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fact_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactAdapter.ViewHolder holder, int position) {
        holder.indexData.setText(position+"");
        holder.randomFactData.setText(facts.get(position));
    }

    @Override
    public int getItemCount() {
        return facts.size();
    }
}

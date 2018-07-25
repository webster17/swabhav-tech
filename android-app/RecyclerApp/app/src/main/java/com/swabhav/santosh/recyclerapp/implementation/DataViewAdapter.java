package com.swabhav.santosh.recyclerapp.implementation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swabhav.santosh.recyclerapp.R;

public class DataViewAdapter extends RecyclerView.Adapter<DataViewAdapter.ViewHolder> {

    public String[] names;
    public View.OnClickListener onClickListener;

    public DataViewAdapter(String[] names, View.OnClickListener onClickListener){
        this.names = names;
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public ViewHolder(@NonNull View view) {
            super(view);
            name= (TextView) view.findViewById(R.id.nameTextView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout=(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_element, parent, false);
        ViewHolder vh = new ViewHolder(linearLayout);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(names[position]);
        holder.name.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount(){
        return names.length;
    }
}
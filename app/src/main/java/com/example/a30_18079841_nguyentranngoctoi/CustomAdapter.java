package com.example.a30_18079841_nguyentranngoctoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    private ArrayList<Emloyee> emloyees;

    public CustomAdapter(ArrayList<Emloyee> emloyees) {
        this.emloyees = emloyees;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Emloyee emloyee = emloyees.get(position);
        holder.tvId.setText(emloyee.getId());
        holder.tvName.setText(emloyee.getName());
        holder.tvAge.setText(emloyee.getAge()+"");
    }

    @Override
    public int getItemCount() {
        return emloyees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId,tvName,tvAge;
        Button btnUp,btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId_item);
            tvName=itemView.findViewById(R.id.tvName_item);
            tvAge=itemView.findViewById(R.id.tv_age_item);
            btnDelete=itemView.findViewById(R.id.btn_de_item);
            btnUp=itemView.findViewById(R.id.btn_up_item);

        }
    }
}

package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pe.bicentenariolalibertad.Model.CategoryActivity;

import java.util.List;

public class HolderCategory extends RecyclerView.Adapter<HolderCategory.MyViewHolder> {

    private Context ncontext;
    private List<CategoryActivity> nCat;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

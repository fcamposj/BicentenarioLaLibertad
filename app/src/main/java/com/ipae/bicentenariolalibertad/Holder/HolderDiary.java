package com.ipae.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ipae.bicentenariolalibertad.Model.ModelDiary;
import com.ipae.bicentenariolalibertad.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderDiary extends RecyclerView.Adapter<HolderDiary.ViewHolder> {

    Context context;
    List<ModelDiary> models;



    @NonNull
    @Override
    public HolderDiary.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDiary.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         public LinearLayout linerDiary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.linerDiary = (LinearLayout) itemView.findViewById(R.id.linearDiary);
        }
    }
}

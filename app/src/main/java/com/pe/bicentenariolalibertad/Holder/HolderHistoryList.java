package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.pe.bicentenariolalibertad.Model.CategoryActivity;
import com.pe.bicentenariolalibertad.R;

import java.util.List;

public class HolderHistoryList extends RecyclerView.Adapter<HolderHistoryList.MyViewHolder> {

    private List<CategoryActivity> cat;

    public HolderHistoryList(List<CategoryActivity> cat) {
        this.cat = cat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.activity_history_list,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindHistory(cat.get(position));
    }

    @Override
    public int getItemCount() {
        return cat.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layoutItemList;
        View viewBackground;
        RoundedImageView imgHistoryOne;
        TextView textName, textHistory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemList = itemView.findViewById(R.id.layoutItemList);
            imgHistoryOne = itemView.findViewById(R.id.imgHistoryOne);
            textName = itemView.findViewById(R.id.textName);
            textHistory = itemView.findViewById(R.id.textHistory);

        }

        void bindHistory(final CategoryActivity categoryActivity){
            imgHistoryOne.setImageResource(categoryActivity.getImage());
            textName.setText(categoryActivity.getName());
            textHistory.setText(categoryActivity.getStory());
        }
    }
}

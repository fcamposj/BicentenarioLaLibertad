package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.pe.bicentenariolalibertad.Model.CategoryActivity;
import com.pe.bicentenariolalibertad.R;

import java.util.ArrayList;
import java.util.List;

public class HolderCategory extends RecyclerView.Adapter<HolderCategory.MyViewHolder> {

    List<CategoryActivity> itemHist;
    private ArrayList<CategoryActivity> recyclingArrayList;
    private OnItemListener onItemListener;

    public HolderCategory(ArrayList<CategoryActivity> recyclingArrayList, OnItemListener onItemListener) {

        this.recyclingArrayList = recyclingArrayList;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_history,parent,false);
        return new MyViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.recyclerCatImageHistoria.setImageResource(recyclingArrayList.get(position).getImage());
        holder.recyclerCatTitle.setText(recyclingArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return recyclingArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        RoundedImageView itemImage;
        private ImageView recyclerCatImageHistoria;
        private TextView recyclerCatTitle;
        private OnItemListener onItemListener;

        public MyViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemList);
            recyclerCatImageHistoria = (ImageView) itemView.findViewById(R.id.imageDetailCell);
            recyclerCatTitle = (TextView) itemView.findViewById(R.id.textDetailCell);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);

        }

        void setPostImage(CategoryActivity postItem) {
            itemImage.setImageResource(postItem.getImage());
        }

        @Override
        public void onClick(View v) {
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemListener {
        void onItemClick(int position);
    }

}

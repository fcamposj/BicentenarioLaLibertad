package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import com.pe.bicentenariolalibertad.Activitys.DetailDiaryActivity;
import com.pe.bicentenariolalibertad.Entidades.ModelDiary;

import com.pe.bicentenariolalibertad.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderDiary extends RecyclerView.Adapter<HolderDiary.ViewHolder> {

    private Context context;
    private ArrayList<ModelDiary> models;

    public HolderDiary(ArrayList<ModelDiary> models,Context context){
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public HolderDiary.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_diary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDiary.ViewHolder holder, int position) {
       final ModelDiary mode = models.get(position);

       holder.view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bundle bundle = new Bundle();
               bundle.putSerializable("mode",mode);
               Intent intent = new Intent(holder.itemView.getContext(), DetailDiaryActivity.class);
               intent.putExtras(bundle);
               context.startActivity(intent);
           }
       });

        Picasso.get().load(mode.getAimagen()).placeholder(R.drawable.ic_launcher)
                .resize(370,200).into(holder.imageview_foto);

        //Glide.with(context).load(mode.getAimagen())
        // .placeholder(R.drawable.ic_launcher).override(330,180).centerCrop()
           //     .error(R.drawable.back_arrow).into(holder.imageview_foto);

        holder.txttitulo.setText(mode.getAtitulo());
        holder.txtfecha.setText(mode.getAfecha());
        holder.txthora.setText(mode.getAhora());
        holder.txtdireccion.setText(mode.getAdireccion());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linerDiary;
        private TextView txttitulo,txtfecha,txthora,txtdireccion;
        private ImageView imageview_foto;
        public  View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
            this.linerDiary = (LinearLayout) itemView.findViewById(R.id.linearDiary);
            this.imageview_foto = (ImageView) itemView.findViewById(R.id.imageView_foto);
            this.txttitulo = (TextView) itemView.findViewById(R.id.txtTitulo);
            this.txtfecha = (TextView) itemView.findViewById(R.id.txtFecha);
            this.txthora = (TextView) itemView.findViewById(R.id.txtHora);
            this.txtdireccion = (TextView) itemView.findViewById(R.id.txtDireccion);
        }
    }
}

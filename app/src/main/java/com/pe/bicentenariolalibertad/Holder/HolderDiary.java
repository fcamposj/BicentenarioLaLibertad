package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import com.pe.bicentenariolalibertad.Entidades.ModelDiary;

import com.pe.bicentenariolalibertad.R;

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
        ModelDiary mode = models.get(position);

        Glide.with(context).load(mode.getAimagen())
                .placeholder(R.drawable.ic_launcher).override(330,180).centerCrop()
                .error(R.drawable.back_arrow).into(holder.imageview_foto);

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

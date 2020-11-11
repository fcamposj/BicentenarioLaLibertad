package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pe.bicentenariolalibertad.Model.ModelDiary;
import com.pe.bicentenariolalibertad.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderDiary extends RecyclerView.Adapter<HolderDiary.ViewHolder> {

    Context context;
    ArrayList<ModelDiary> models;

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
        holder.txtTitulo.setText(mode.getDiarytitulo());
        holder.txtFecha.setText(mode.getDiaryFecha());
        holder.txtHora.setText(mode.getHora());
        holder.txtDireccion.setText(mode.getDireccion());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linerDiary;
        private TextView txtTitulo,txtFecha,txtHora,txtDireccion;
        private ImageView imageView_foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.linerDiary = (LinearLayout) itemView.findViewById(R.id.linearDiary);
            imageView_foto = itemView.findViewById(R.id.imageView_foto);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtHora = itemView.findViewById(R.id.txtHora);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);
        }
    }
}

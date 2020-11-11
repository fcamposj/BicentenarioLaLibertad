package com.pe.bicentenariolalibertad.Holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pe.bicentenariolalibertad.R;

public class HolderHistoryList extends RecyclerView.Adapter<HolderHistoryList.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public HolderHistoryList(Context ct, String r1[], String r2[], int imgs[]) {
        context = ct;
        data1 = r1;
        data2 = r2;
        images = imgs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_history_list_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt1.setText(data1[position]);
        holder.txt2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt1, txt2;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.history_txt);
            txt2 = itemView.findViewById(R.id.description_txt);
            myImage = itemView.findViewById(R.id.myImage);
        }
    }
}

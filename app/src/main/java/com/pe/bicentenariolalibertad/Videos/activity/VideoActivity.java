package com.pe.bicentenariolalibertad.Videos.activity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.Activitys.MenuActivity;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.Videos.Model.ModelVideo;
import com.pe.bicentenariolalibertad.Videos.holder.HolderVideos;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

public class VideoActivity extends AppCompatActivity {




    String url="",name="";
    DatabaseReference reference;
    RecyclerView recyclerView;
  private ImageView imagenicon;
  private View inflater;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);



        recyclerView = findViewById(R.id.reciclerVideo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference().child("Videos");


        imagenicon = findViewById(R.id.txtatrasvideo);


      imagenicon.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {


              Intent intents = new Intent(VideoActivity.this, MenuActivity.class);
              startActivity(intents);
          }
      });

    }



    @Override
    protected void onStart() {
        super.onStart();

       FirebaseRecyclerOptions<ModelVideo> optios =
               new FirebaseRecyclerOptions.Builder<ModelVideo>()
               .setQuery(reference, ModelVideo.class).build();



        FirebaseRecyclerAdapter<ModelVideo, HolderVideos> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelVideo, HolderVideos>(optios) {
                    @Override
                    protected void onBindViewHolder(@NonNull HolderVideos holder, int position, @NonNull ModelVideo model) {
                        holder.setExoplyer(getApplication(),model.getTitulo(),model.getUrl());

                        holder.setonClickListener(new HolderVideos.Clicklistener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                url = getItem(position).getUrl();
                                name= getItem(position).getTitulo();
                                Intent intent = new Intent(VideoActivity.this,DetailsVideoActivity.class);
                                intent.putExtra("ulr",url);
                                intent.putExtra("name",name);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public Void onItemLongClick(View view, int position) {
                                return null;
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public HolderVideos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.activity_video_list,parent,false);
                        return new HolderVideos(view);
                    }
                };
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }



}

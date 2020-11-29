package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pe.bicentenariolalibertad.Entidades.ModelDiary;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.Videos.activity.VideoActivity;
import com.squareup.picasso.Picasso;

public class DetailDiaryActivity extends AppCompatActivity {

    private TextView txttitulode ,txtfechade,txthorade,txtdireccionde;
    private ImageView imageView_fotode;
    ImageView imagenicon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_details);

        imagenicon = findViewById(R.id.txtatrasdiarydetails);


        imagenicon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intents = new Intent(DetailDiaryActivity.this, DiaryActivity.class);
                startActivity(intents);
            }
        });

        ModelDiary mode = (ModelDiary) getIntent().getSerializableExtra("mode");
        this.txttitulode = (TextView) findViewById(R.id.txtTitulode);
        this.imageView_fotode = (ImageView) findViewById(R.id.imageView_fotode);
        this.txtfechade = (TextView) findViewById(R.id.txtLugarde);
        this.txthorade = (TextView) findViewById(R.id.txtHorade);
        this.txtdireccionde = (TextView) findViewById(R.id.txtDireccionde);

        txttitulode.setText(mode.getAtitulo());
        Picasso.get().load(mode.getAimagen()).placeholder(R.drawable.ic_launcher)
                .resize(370,200).into(imageView_fotode);
        txtfechade.setText(mode.getAfecha());
        txthorade.setText(mode.getAhora());
        txtdireccionde.setText(mode.getAdireccion());



    }
}

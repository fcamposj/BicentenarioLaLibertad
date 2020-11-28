package com.pe.bicentenariolalibertad.Activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pe.bicentenariolalibertad.Entidades.ModelDiary;
import com.pe.bicentenariolalibertad.R;
import com.squareup.picasso.Picasso;

public class DetailDiaryActivity extends AppCompatActivity {

    private TextView txttitulode ,txtfechade,txthorade,txtdireccionde;
    private ImageView imageView_fotode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_details);

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

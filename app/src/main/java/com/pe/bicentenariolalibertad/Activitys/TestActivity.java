package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pe.bicentenariolalibertad.Model.ModelTest;
import com.pe.bicentenariolalibertad.R;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jorge Ventura on 2020-03-01.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class TestActivity extends AppCompatActivity  {


      TextView preInicial,txttiempo;
      Button opc1, opc2, opc3;
     int total= 1;
     int correct = 0;
     int wrong = 0;

      int computerCount =0;

     DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        preInicial= findViewById(R.id.txtquestions);
        opc1 = findViewById(R.id.txtopcone);
        opc2 = findViewById(R.id.txtopctwo);
        opc3 = findViewById(R.id.txtopcthree);
        txttiempo = findViewById(R.id.txtTiempo);
        updateQuestion();

        reverseTimer(60,txttiempo);

    }


    private  void updateQuestion(){

        computerCount++;
        if(computerCount > 10){

        }else{
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(computerCount));
            total++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                  final ModelTest model = snapshot.getValue(ModelTest.class);

                  preInicial.setText(model.getQuestion());

                  opc1.setText(model.getRespA());
                  opc2.setText(model.getRespB());
                  opc3.setText(model.getRespC());

                  opc1.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          if(opc1.getText().toString().equals(model.getAnswer())){
                              opc1.setBackgroundColor(Color.GREEN);
                              correct = correct+1;
                              Handler handler = new Handler();

                              handler.postDelayed(new Runnable() {
                                  @Override
                                  public void run() {
                                    correct++;
                                    opc1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                    updateQuestion();
                                  }
                              },1500);
                          }else {
                              wrong++;
                              opc1.setBackgroundColor(Color.RED);
                              if(opc2.getText().toString().equals(model.getAnswer())){
                                  opc2.setBackgroundColor(Color.GREEN);
                              }else if (opc3.getText().toString().equals(model.getAnswer())){
                                  opc3.setBackgroundColor(Color.GREEN);
                              }

                              Handler handler = new Handler();
                              handler.postDelayed(new Runnable() {
                                  @Override
                                  public void run() {
                                      opc1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                      opc2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                      opc3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                  }
                              },1500);
                          }
                      }
                  });


                    opc2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opc2.getText().toString().equals(model.getAnswer())){
                                opc2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        opc2.setBackgroundColor(Color.GRAY);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                opc2.setBackgroundColor(Color.RED);
                                if(opc1.getText().toString().equals(model.getAnswer())){
                                    opc1.setBackgroundColor(Color.GREEN);
                                }else if (opc3.getText().toString().equals(model.getAnswer())){
                                    opc3.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        opc1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opc2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opc3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                        }
                    });


                    opc3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(opc3.getText().toString().equals(model.getAnswer())){
                                opc3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        opc3.setBackgroundColor(Color.GRAY);
                                        updateQuestion();
                                    }
                                },1500);
                            }else {
                                wrong++;
                                opc3.setBackgroundColor(Color.RED);
                                if(opc1.getText().toString().equals(model.getAnswer())){
                                    opc1.setBackgroundColor(Color.GREEN);
                                }else if (opc2.getText().toString().equals(model.getAnswer())){
                                    opc2.setBackgroundColor(Color.GREEN);
                                }
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        opc1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opc2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        opc3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                },1500);
                            }
                        }
                    });






                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }


    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("Completed");
               /* Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);
                myIntent.putExtra("total",String.valueOf(total));
                myIntent.putExtra("correct",String.valueOf(correct));
                myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);*/
            }
        }.start();
    }


}

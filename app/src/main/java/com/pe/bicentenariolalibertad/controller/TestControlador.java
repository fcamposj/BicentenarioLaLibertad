package com.pe.bicentenariolalibertad.controller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.pe.bicentenariolalibertad.Activitys.MenuActivity;
import com.pe.bicentenariolalibertad.Activitys.TestActivity;
import com.pe.bicentenariolalibertad.Datos.TestDatos;
import com.pe.bicentenariolalibertad.Entidades.ModelTest;


import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;


public class TestControlador {



    private Context context;

    private static int computerCount =0;
    private static DatabaseReference reference;
    private static TestDatos testDatos;


   private static int total= 1;
   private static int correct = 0;
    private  static int wrong = 0;
    TextView preInicial,txttiempo, txtnum;
    Button opc1, opc2, opc3;


    public TestControlador(Context context) {
        this.context = context;
    }

    public static void nuevometodo(final TextView preInicial, final Button opc1, final Button opc2,
                                   final Button opc3, final TextView txtnum, final  TextView txttiempo) {

        computerCount++;
          txtnum.setText(""+computerCount);
        reverseTimer(30,txttiempo);
        //guardadatos();
        if(computerCount > 10){

        }else{

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(computerCount));
           // computerCount++;
           // reference = testDatos.tablapregunta(computerCount);
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
                                        opc1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                       nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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
                                        opc1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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
                                        opc2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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
                                        opc1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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
                                        opc3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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
                                        opc1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        opc3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                                        nuevometodo(preInicial, opc1,opc2,  opc3,txtnum,txttiempo);
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





    public static void reverseTimer(int Seconds, final TextView tv){

         final TestActivity testActivity = new TestActivity();
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
               // testActivity.ventana();
               // Intent myIntent = new Intent(TestActivity.this,MenuActivity.class);
                // myIntent.putExtra("total",String.valueOf(total));
                // myIntent.putExtra("correct",String.valueOf(correct));
                // myIntent.putExtra("incorrect",String.valueOf(wrong));
               // startActivity(myIntent);
            }
        }.start();
    }


}

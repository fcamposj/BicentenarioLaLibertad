package com.pe.bicentenariolalibertad.Activitys;


import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pe.bicentenariolalibertad.Entidades.ModelTest;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.ScoreActivity.ScoreActivity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Cleiner Rodriguez.
 * cleinerrodriguezs@gmail.com
 *
 *  Apps
 * Lima, Peru.
 **/
public class TestActivity extends AppCompatActivity implements  View.OnClickListener  {

      TextView preInicial,txttiempo, txtnum;
      Button opc1, opc2, opc3;
     int total= 1;
     int correct = 0;
     int wrong = 0;

      private TextView question,gCount, timer;
      private Button opc1, opc2, opc3;
      private List<ModelTest> questionList;
      private  int quesNum;
      private  CountDownTimer countDown;
      private  int score;
      private FirebaseFirestore firestore;
      private int setNo;
      private Dialog loadingDialog;

     DatabaseReference reference;
     FirebaseUser firebaseUser;

     FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        question= findViewById(R.id.txtquestions);
        timer = findViewById(R.id.txtTiempo);
        gCount = findViewById(R.id.txtnum);

        opc1 = findViewById(R.id.txtopcone);
        opc2 = findViewById(R.id.txtopctwo);
        opc3 = findViewById(R.id.txtopcthree);
        txttiempo = findViewById(R.id.txtTiempo);
        txtnum = findViewById(R.id.txtnum);


        firebaseDatabase =  FirebaseDatabase.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        updateQuestion();

        opc1.setOnClickListener(this);
        opc2.setOnClickListener(this);
        opc3.setOnClickListener(this);




        computerCount++;
        txtnum.setText(""+computerCount);
        guardadatos();
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
                              guardadatos();
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


                                ));
                    }
                    setQuestion();
                }else{
                    Toast.makeText(TestActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


       // setQuestion();
    }

    private void  setQuestion(){
        timer.setText(String.valueOf(10));
        question.setText(questionList.get(0).getQuestion());
        opc1.setText(questionList.get(0).getRespA());
        opc2.setText(questionList.get(0).getRespB());
        opc3.setText(questionList.get(0).getRespC());

        gCount.setText(String.valueOf(1)+ "/" + String.valueOf(questionList.size()));

        startTimer();
        quesNum = 0;
    }

    private  void startTimer(){
        countDown = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished < 10000)
                timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                tv.setText("Completed");
                Intent myIntent = new Intent(TestActivity.this,MenuActivity.class);
               // myIntent.putExtra("total",String.valueOf(total));
               // myIntent.putExtra("correct",String.valueOf(correct));
               // myIntent.putExtra("incorrect",String.valueOf(wrong));
                startActivity(myIntent);
            }
        }, 2000);
    }

  public void guardadatos(){
                FirebaseDatabase fire = FirebaseDatabase.getInstance();
       final DatabaseReference referen = fire.getReference().child(firebaseUser.getUid());
        referen.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
              if (snapshot.exists()){
                  Long num= (Long) snapshot.child("total").getValue() + 5 ;



                    referen.child("datos").child(firebaseUser.getUid()).setValue(num);
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


  }

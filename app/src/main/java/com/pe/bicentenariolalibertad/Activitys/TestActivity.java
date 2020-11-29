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
import android.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pe.bicentenariolalibertad.Entidades.ModelTest;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.ScoreActivity.ScoreActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Cleiner Rodriguez.
 * cleinerrodriguezs@gmail.com
 *
 *  Apps
 * Lima, Peru.
 **/
public class TestActivity extends AppCompatActivity implements  View.OnClickListener  {


      private TextView question,gCount, timer;
      private Button opc1, opc2, opc3;
      private List<ModelTest> questionList;
      private  int quesNum;
      private  CountDownTimer countDown;
      private  int score;
      private FirebaseFirestore firestore;
      private int setNo;
      private Dialog loadingDialog;

      public int err;

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

        opc1.setOnClickListener(this);
        opc2.setOnClickListener(this);
        opc3.setOnClickListener(this);




        questionList= new ArrayList<>();
        setNo = getIntent().getIntExtra("SETNO",1);
        firestore = FirebaseFirestore.getInstance();

        getQuestionsList();
        score =0;
        err = 0;

    }


    private  void getQuestionsList(){

   questionList.clear();


        firestore.collection("Bicentenario").document("Question")
                .collection("Play")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    QuerySnapshot question = task.getResult();

                    for (QueryDocumentSnapshot doc : question){
                        questionList.add(new ModelTest(
                                doc.getString("question"),
                                doc.getString("pregA"),
                                doc.getString("pregB"),
                                doc.getString("pregC"),
                                Integer.valueOf(doc.getString("answer"))


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
               // changeQuestion();

            }
        };
        countDown.start();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

         int selectedOption = 0;
           switch (v.getId())
           {

               case R.id.txtopcone :
                   selectedOption = 1;
                   break;

               case R.id.txtopctwo:
                   selectedOption = 2;
                   break;

               case R.id.txtopcthree:
                   selectedOption = 3;
                   break;

               default:

           }
           countDown.cancel();
           chechAnswer(selectedOption, v);
    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void  chechAnswer (int selecdOption, View view){

        if (selecdOption == questionList.get(quesNum).getCorrectAns()){
                    //Right answer
              ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
              score++;


        }else {

             err++;


            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            switch (questionList.get(quesNum).getCorrectAns()){
                case 1:
                    opc1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;

                case 2:
                    opc2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;

                case 3:
                    opc3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (err==3){

                    Intent intent = new Intent(TestActivity.this, ScoreActivity.class);
                    intent.putExtra("SCORE",String.valueOf(score)+ "/" + String.valueOf(questionList.size()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    //guardardato();
                    startActivity(intent);
                }else{
                    changeQuestion();
                }

            }
        }, 2000);
    }

    private void  changeQuestion(){


        if (quesNum < questionList.size() - 1){
            quesNum++;


            payAnim(question, 0,0);
            payAnim(opc1, 0,1);
            payAnim(opc2, 0,2);
            payAnim(opc3, 0,3);

            gCount.setText(String.valueOf(quesNum+1)+ "/"+ String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            startTimer();




        }else{

            // go to score activity
            Intent intent = new Intent(TestActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE",String.valueOf(score)+ "/" + String.valueOf(questionList.size()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //guardardato();
            startActivity(intent);
            //TestActivity.this.finish();
        }

    }

    private  void payAnim(View view, final int value, int viewNum){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (value == 0 ){
                        switch (viewNum)
                        {
                            case 0:
                                ( (TextView)view).setText(questionList.get(quesNum).getQuestion());
                                break;

                            case 1:
                                ( (Button)view).setText(questionList.get(quesNum).getRespA());
                                break;

                            case 2:
                                ( (Button)view).setText(questionList.get(quesNum).getRespB());
                                break;

                            case 3:
                                ( (Button)view).setText(questionList.get(quesNum).getRespC());
                                break;
                        }
                            if(viewNum != 0)
                                ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E99C03")));

                            payAnim(view, 1,viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countDown.cancel();
    }
/*
    private  void guardardato(){

        DatabaseReference reference;
        FirebaseAuth auth = null;
        FirebaseUser user;
       // reference = FirebaseDatabase.getInstance().getReference("Users").child(auth.getUid());

       //String fd = reference.toString();

        Map<String, Object> map = new HashMap<>();
        map.put("buenas",""+String.valueOf(score));
        map.put("malas",""+ String.valueOf(err));
        //map.put("user",fd);
        firestore.collection("Bicentenario").document("result").set(map);
    }



    private  void guardardato(){

         DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth hg = FirebaseAuth.getInstance();


        Map<String, Object> map = new HashMap<>();
        map.put("buenas",""+String.valueOf(score));
        map.put("malas",""+ String.valueOf(err));

        mDatabase.child("users").child(hg.getUid()).setValue(map);
    }
    */
    }


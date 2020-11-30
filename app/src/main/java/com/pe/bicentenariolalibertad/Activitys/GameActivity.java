package com.pe.bicentenariolalibertad.Activitys;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pe.bicentenariolalibertad.R;

public class GameActivity extends AppCompatActivity {
    private static final int RC_FROM_GALLERY = 124;
    private TextView mtxtProfileName;
        private ImageView imgProfile;
        private FirebaseAuth mAuth;
        private DatabaseReference mReference;

        private ImageView imageView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        initParams();
        setParams();
        selectPhoto();
    }


    @SuppressLint("WrongViewCast")
    private void initParams(){
        mtxtProfileName = findViewById(R.id.txtProfileName);

        imgProfile = findViewById(R.id.imgProfileGame);


        GoogleSignInAccount signInAccount= GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null){
            mtxtProfileName.setText(signInAccount.getDisplayName());
        }


        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            mtxtProfileName.setText(user.getDisplayName());
            if(user.getPhotoUrl() != null){
                String photourl = user.getPhotoUrl().toString();
                photourl=photourl + "?type=large";
                Picasso.get().load(photourl).into(imgProfile);
            }
        }else {}

    }

    private void setParams(){
     informationUser();
    }


    private void informationUser(){
        String id = mAuth.getCurrentUser().getUid();
        mReference.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (snapshot.exists()){
                    String name= snapshot.child("rName").getValue().toString();
                    String Lats= snapshot.child("rLast").getValue().toString();
                    loadImage(user.getPhotoUrl());

                    mtxtProfileName.setText(name + " " + Lats);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== RC_FROM_GALLERY){
            FirebaseStorage  firebaseStorage = FirebaseStorage.getInstance();
            final StorageReference refe= firebaseStorage.getReference().child("my foto").child("profile");
             Uri selectImageUri = data.getData();

            if (selectImageUri != null){
                refe.putFile(selectImageUri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                refe.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                        if (user != null){
                                            UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                                    .setPhotoUri(uri).build();
                                            user.updateProfile(request)
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if(task.isSuccessful()){
                                                                loadImage(user.getPhotoUrl());
                                                            }
                                                        }
                                                    });
                                        }
                                    }
                                });
                            }
                        });
            }
        }
    }

    public  void selectPhoto(){
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(inte, RC_FROM_GALLERY);

            }
        });



    }

    private  void loadImage(Uri photoUrl){


        Picasso.get().load(photoUrl).into(imgProfile);


    }
}

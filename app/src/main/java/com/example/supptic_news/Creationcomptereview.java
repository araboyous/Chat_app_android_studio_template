package com.example.supptic_news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.UserDataReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Creationcomptereview extends AppCompatActivity {

    TextInputEditText text1,text2,text3,text4;
    private static final int RC_SIGN_IN = 123;
    Button bouton1;
    String emailpattern="[a-zA-Z0-9._-]@[a-z]\\.[a-z]";
    CardView cardView;
    ProgressDialog progessdialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationcomptereview);
        text1=findViewById(R.id.pseudo1);
        text2=findViewById(R.id.Email1);
        text3=findViewById(R.id.password1);
        text4=findViewById(R.id.conf_password);
        bouton1=findViewById(R.id.button_creation);
        cardView=findViewById(R.id.card);
        progessdialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        firebaseFirestore=FirebaseFirestore.getInstance();



        //Partie logique de la connexion
        bouton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerforAuth();



            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignInActivity();



            }
        });

    }

    public void PerforAuth(){

        String str1=text1.getText().toString();
        String str2=text2.getText().toString();
        String str3=text3.getText().toString();
        String str4=text4.getText().toString();
        if (str1.length()<3){
            text1.setError("Entrer un nom existant");
        }
        else if(str2.matches(emailpattern)){
            text2.setError("Entrer un mail valide");

        }
        else if (str3.isEmpty()||str3.length()<6){
            text3.setError("Entrer un mot de pass correct");
        }
        else if(!str3.equals(str4)){
            text4.setError("Mot de pass incompatible");
        }
        else {
            progessdialog.setMessage("Sauvegarde en cous...");
            progessdialog.setTitle("Enregistrement");
            progessdialog.setCanceledOnTouchOutside(false);
            progessdialog.show();

            mAuth.createUserWithEmailAndPassword(str2,str3).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    progessdialog.dismiss();
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    progessdialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Echec de creation Compte",Toast.LENGTH_SHORT).show();

                }
            });

        }


    }




    private void startSignInActivity(){

        // Choose authentication providers
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build());
                //new AuthUI.IdpConfig.EmailBuilder().build());

        // Launch the activity

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.Theme_Supptic_news)
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false, true)
                        .setLogo(R.drawable.logo)
                        .build(),
                RC_SIGN_IN);
    }
  /*  private void senUsertonextActivity() {
        Intent intent=new Intent(getApplicationContext(),Acceuil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      super.onActivityResult(requestCode, resultCode, data);
      this.handleResponseAfterSignIn(requestCode, resultCode, data);
  }
    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data){

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN) {
            // SUCCESS
            if (resultCode == RESULT_OK) {
                Intent in =new Intent(getApplicationContext(),Acceuil.class);
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                startActivity(in);
            }
            else {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
            }

            }
        else{
            Toast.makeText(getApplicationContext(),"RAS",Toast.LENGTH_LONG).show();
        }
            }




        }




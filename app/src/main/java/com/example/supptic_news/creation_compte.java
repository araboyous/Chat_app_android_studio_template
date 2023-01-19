package com.example.supptic_news;


import static android.content.ContentValues.TAG;



import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.List;

public class creation_compte extends AppCompatActivity {
    /// declaration des variables
    Button Creer_compte;
    private FirebaseAuth mAuth;

    CardView google1;
    private static final int  RC_SIGN_IN=100;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView se_connecter;
    TextInputEditText Pseudo,Email,pass12,repass12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* //affectation
        google1=findViewById(R.id.card);
        Creer_compte=findViewById(R.id.button_creation);
        se_connecter=findViewById(R.id.seconnecter);
        Pseudo=findViewById(R.id.pseudo1);
        Email=findViewById(R.id.Email1);
        pass12=findViewById(R.id.password1);
        repass12=findViewById(R.id.conf_password);
        ///google
        mAuth = FirebaseAuth.getInstance();

       /* Creer_compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount ();
            }});
        //la page se connecter
        se_connecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent page_connecter =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(page_connecter);
            }});
        //// utilisation de google

        google1=findViewById(R.id.card);
        google1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignInActivity();
                if(mAuth.getCurrentUser()!=null) {
                    Intent login_3=new Intent(getApplicationContext(),Acceuil.class);
                    startActivity(login_3);
                }
            }
        });*/






    }

/*
    void  createAccount () {
        //creation de string
        String a1= Pseudo.getText().toString();


        String b1 = Email.getText().toString();
        String c1 = pass12.getText().toString();
        String d1 = repass12.getText().toString();
/////////////creation compte
        boolean verifier = validationData(a1, b1, c1, d1);
        if (!verifier) {
            Toast.makeText(getApplicationContext(), "reverifier svp car les donnees ne sont pas sauvegardé.",Toast.LENGTH_SHORT).show();
            return;

        }
        createaccountInFirebase(a1, b1,c1,d1);
        utilisateur user =new utilisateur(a1,b1,c1);
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        Intent charge =new Intent(getApplicationContext(), Acceuil.class);
        startActivity(charge);
    }

    void  createaccountInFirebase(String a1, String b1,String c1, String d1){
        mAuth.createUserWithEmailAndPassword(b1, c1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            //If sign in fails, display a message to the user.

                            // Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    //verification des entrees
    private boolean validationData(String a1, String b1,String c1, String d1)
    {     //validation
        if(a1.length()<3 ){
            Pseudo.requestFocus();
            Pseudo.setError("le champ  doit comptenir au moins 3 caracteres");
            return false ;
        }
        else if (!a1.matches("[a-zA-Z]+"))
        {
            Pseudo.requestFocus();
            Pseudo.setError("entrer seulement les alphabets");
            return false;
        }
        //////////////////////
        else  if(b1.length()==0 ){
            Email.requestFocus();
            Email.setError("le champ ne doit etre vide");
            return false ;
        }
        else if(!b1.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            Email.requestFocus();
            Email.setError("entrer un emil  valide");
            return false ;
        }

        else if(c1.length() <6){
            pass12.requestFocus();
            pass12.setError("la longueur du mot de passe  est invalidée ");
            return false;
        }///////////////////////
        else if(d1.length()==0){
            repass12.requestFocus();
            repass12.setError("le champ ne doit pas etre vide");
        }
        else if (!c1.equals(d1)){
            repass12.requestFocus();
            repass12.setError("entrez le meme mot de pass");
        }

        return  true;

    }
    ///methode sign in

    private void startSignInActivity(){

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers =
                Collections.singletonList(new AuthUI.IdpConfig.GoogleBuilder().build());

        startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false, true)
                        .build(),
                RC_SIGN_IN);

    }
*/


}



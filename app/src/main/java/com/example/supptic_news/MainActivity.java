package com.example.supptic_news;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    Button button1;
    TextInputEditText textcon1,textcon2;
    FirebaseAuth firebaseAuth;
    TextView fix1;
    ProgressDialog progressDialog;
    CardView cardView;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1=findViewById(R.id.textcreate);
        fix1=findViewById(R.id.passforget);
        textcon1=findViewById(R.id.mailconnect);
        textcon2=findViewById(R.id.motconnect);
        button1=findViewById(R.id.connect);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        cardView=findViewById(R.id.google);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestEmail().build();
        gsc= GoogleSignIn.getClient(this, gso);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String con1=textcon1.getText().toString();
                String con2=textcon2.getText().toString();
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(con1,con2).
                        addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Intent intent=new Intent(getApplicationContext(),Acceuil.class);
                                progressDialog.cancel();
                            }
                        }).
                        addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Echec de connexion",Toast.LENGTH_SHORT).show();

                            }
                        });


                Intent intent=new Intent(getApplicationContext(),Acceuil.class);
                startActivity(intent);
            }
        });
        fix1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String con1=textcon1.getText().toString();
                progressDialog.setTitle("Email en cours d'envoi..");
                progressDialog.show();
                firebaseAuth.sendPasswordResetEmail(con1).
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(),"Email vous a été envoyé",Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();

                            }
                        }).
                        addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();


                            }
                        });

            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Creationcomptereview.class);
                startActivity(intent);
            }
        });


    }

    private void signIn() {
        Intent intent=gsc.getSignInIntent();
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                HomeActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(),"Une erreur s est produite",Toast.LENGTH_SHORT);

            }

        }
    }

    private void HomeActivity() {

        Intent intent=new Intent(getApplicationContext(),Acceuil.class);
        startActivity(intent);
        finish();

    }
}
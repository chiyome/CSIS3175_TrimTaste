package com.example.trimtaste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Signup extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private FirebaseAuth mAuth;
    private EditText usernameTextView, streetAddress, city, postalCode,
            phoneTextView, emailTextView, passwordTextView;
    private Spinner province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        databaseHelper = new DatabaseHelper(this);
        usernameTextView = findViewById(R.id.edTxtUNameReg);
        streetAddress = findViewById(R.id.edTxtStAddress);
        city = findViewById(R.id.edTxtCity);
        province = findViewById(R.id.spnProvince);
        postalCode = findViewById(R.id.edTxtPostal);
        phoneTextView = findViewById(R.id.edTxtPhone);
        emailTextView = findViewById(R.id.edTxtEmail);
        passwordTextView = findViewById(R.id.edTxtPassReg);
        Button btnSignup = findViewById(R.id.btnSignup);
        //String address = streetAddress.getText().toString() + city.getText().toString()
        //+ province.getSelectedItem().toString() + postalCode.getText().toString();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });


//        btnSignup.setOnClickListener(new View.OnClickListener() {
//            boolean isInserted;
//            @Override
//            public void onClick(View v) {
//                isInserted = databaseHelper.addData(
//                        streetAddress.getText().toString() + " " +
//                                city.getText().toString() + " " +
//                                province.getSelectedItem().toString() + " " +
//                                postalCode.getText().toString(),
//                        email.getText().toString(),
//                        phone.getText().toString(), username.getText().toString(),
//                        password.getText().toString());
//                if(isInserted){
//                    Toast.makeText(Signup.this,"data added",Toast.LENGTH_LONG).show();
//                    username.setText("");
//                    streetAddress.setText("");
//                    city.setText("");
//                    postalCode.setText("");
//                    phone.setText("");
//                    email.setText("");
//                    password.setText("");
//                } else{
//                    Toast.makeText(Signup.this,"data not added",Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }

    private void registerNewUser(){
        String address, email, phone, password;
        address = streetAddress.getText().toString() + " " +
                                city.getText().toString() + " " +
                                province.getSelectedItem().toString() + " " +
                                postalCode.getText().toString();
        email = emailTextView.getText().toString();
        phone = phoneTextView.getText().toString();
        password = passwordTextView.getText().toString();

        //check if fields are empty
        if(TextUtils.isEmpty(address)){
            Toast.makeText(getApplicationContext(),
                    "Please enter address!!", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),
                            "Please enter email!!", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(getApplicationContext(),
                    "Please enter phone!!", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password!!", Toast.LENGTH_LONG).show();
            return;
        }

        //create new user or register
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                            "Registration successful!",
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                        else {

                            // Registration failed
                            Toast.makeText(
                                            getApplicationContext(),
                                            "Registration failed!!"
                                                    + " Please try again later",
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });
    }
}
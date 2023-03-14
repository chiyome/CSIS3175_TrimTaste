package com.example.trimtaste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText username = findViewById(R.id.edTxtUNameReg);
        EditText streetAddress = findViewById(R.id.edTxtStAddress);
        EditText city = findViewById(R.id.edTxtCity);
        Spinner province = findViewById(R.id.spnProvince);
        EditText postalCode = findViewById(R.id.edTxtPostal);
        EditText phone = findViewById(R.id.edTxtPhone);
        EditText email = findViewById(R.id.edTxtEmail);
        EditText password = findViewById(R.id.edTxtPassReg);
        Button btnSignup = findViewById(R.id.btnSignup);

    }
}
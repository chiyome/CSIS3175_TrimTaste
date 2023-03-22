package com.example.trimtaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Admin_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        ImageButton imgBtnAddItems = findViewById(R.id.imgBtnAddItems);
        ImageButton imgBtnViewOrders = findViewById(R.id.imgBtnViewOrders);


        imgBtnAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_MainActivity.this, Admin_AddRemobeItems.class));
            }
        });

        imgBtnViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_MainActivity.this, Admin_ViewEditFoodOrders.class));
            }
        });
    }
}
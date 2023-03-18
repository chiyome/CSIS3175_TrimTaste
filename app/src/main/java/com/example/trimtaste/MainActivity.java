package com.example.trimtaste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnSearch = findViewById(R.id.imgBtnSearch);
        ImageButton btnOrderFood = findViewById(R.id.imgBtnOrderFood);
        ImageButton btnViewOrderDetails = findViewById(R.id.imgBtnOrderDetails);
        ImageButton btnHistory = findViewById(R.id.imgBtnViewHistory);
        ImageButton btnProfile = findViewById(R.id.imgBtnProfile);
        ImageButton btnLogout = findViewById(R.id.imgBtnLogout);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchRestaurant.class));
            }
        });
    }
}
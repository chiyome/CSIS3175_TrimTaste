package com.example.trimtaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SearchRestaurant extends AppCompatActivity
        implements RestaurantAdapter.ItemClickListener {

    Integer[] restaurants = {R.drawable.mock_restaurant1, R.drawable.mock_restaurant2, R.drawable.mock_restaurant3, R.drawable.mock_restaurant4};

    String[] restaurantsNames = {"Chef Ron restaurant and bar", "Pho Express Angkor Noodle House", "Mediterranean Grill", "Tractor Foods"};

    RestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurant);

        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView recyclerViewRes = findViewById(R.id.recyclerViewRestaurant);

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // Start of search process
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // Processing of text changes
//                return false;
//            }
//        });

        recyclerViewRes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RestaurantAdapter(restaurants, restaurantsNames);
        adapter.setClickListener(this);
        recyclerViewRes.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"Selected " + (position+1),
                Toast.LENGTH_SHORT).show();
//        imageView.setImageResource(adapter.getItem(position));
    }
}
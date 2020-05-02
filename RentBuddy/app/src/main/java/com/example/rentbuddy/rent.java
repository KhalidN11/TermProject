package com.example.rentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class rent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);


        final ImageButton house = findViewById(R.id.house);
        final ImageButton apartment = findViewById(R.id.apartment);

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(rent.this, HouseForRent.class);
                rent.this.startActivity(myIntent);
            }
        });


        apartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(rent.this, ApartmentForRent.class);
                rent.this.startActivity(myIntent);
            }
        });


    }
}

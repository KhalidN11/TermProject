package com.example.rentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class sell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);


        final ImageButton house = findViewById(R.id.house);
        final ImageButton apartment = findViewById(R.id.apartment);

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sell.this, HouseForSell.class);
                sell.this.startActivity(myIntent);
            }
        });


        apartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(sell.this, ApartmentForSell.class);
                sell.this.startActivity(myIntent);
            }
        });


    }
}

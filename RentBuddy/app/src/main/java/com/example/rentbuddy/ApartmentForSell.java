package com.example.rentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ApartmentForSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment_for_sell);

        String s=loadJSONFromAsset();

        Button interested1=(Button) findViewById(R.id.interested1);
        Button interested2=(Button) findViewById(R.id.interested2);
        Button interested3=(Button) findViewById(R.id.interested3);

        final TextView count1=(TextView) findViewById(R.id.count1);
        final TextView count2=(TextView) findViewById(R.id.count2);
        final TextView count3=(TextView) findViewById(R.id.count3);



        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("ap_sell_1");
        final DatabaseReference myRef2 = database.getReference("ap_sell_2");
        final DatabaseReference myRef3 = database.getReference("ap_sell_3");
        final long[] cnt = new long[10];

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cnt[1] = (Long)dataSnapshot.getValue();
                count1.setText("Interested: "+cnt[1]);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cnt[2] = (Long)dataSnapshot.getValue();
                count2.setText("Interested: "+cnt[2]);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cnt[3] = (Long)dataSnapshot.getValue();
                count3.setText("Interested: "+cnt[3]);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });


        interested1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue(cnt[1]+1);
                Intent myIntent = new Intent(ApartmentForSell.this, userInfo.class);
                ApartmentForSell.this.startActivity(myIntent);
            }
        });

        interested2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef2.setValue(cnt[2]+1);
                Intent myIntent = new Intent(ApartmentForSell.this, userInfo.class);
                ApartmentForSell.this.startActivity(myIntent);
            }
        });

        interested3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef3.setValue(cnt[3]+1);
                Intent myIntent = new Intent(ApartmentForSell.this, userInfo.class);
                ApartmentForSell.this.startActivity(myIntent);
            }
        });


        try{
            //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            JSONObject obj = new JSONObject(s);
            JSONArray jsonArray = obj.getJSONArray("apartment");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> hashMap;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo_inside = jsonArray.getJSONObject(i);

                String image = jo_inside.getString("image");
                String price = jo_inside.getString("price");
                String address=jo_inside.getString("address");
                String numberOfRooms=jo_inside.getString("number of rooms");
                String contact=jo_inside.getString("contact");

                hashMap = new HashMap<String, String>();
                hashMap.put("image", image);
                hashMap.put("price", price);
                hashMap.put("address",address);
                hashMap.put("number of rooms",numberOfRooms);
                hashMap.put("contact",contact);

                formList.add(hashMap);
            }

            HashMap<String, String> hash1=formList.get(0);
            HashMap<String, String> hash2=formList.get(1);
            HashMap<String, String> hash3=formList.get(2);
            String im1=hash1.get("image");
            String price1="Price: "+hash1.get("price");
            String address1="Address: "+hash1.get("address");
            //Toast.makeText(getApplicationContext(),address1,Toast.LENGTH_LONG).show();


            String numOfrooms1="Number of Rooms: "+hash1.get("number of rooms");
            String contact1="Contact: "+hash1.get("contact");
            //Toast.makeText(getApplicationContext(),contact1,Toast.LENGTH_LONG).show();

            String im2=hash2.get("image");
            String price2="Price: "+hash2.get("price");
            String address2="Address: "+hash2.get("address");
            String numOfrooms2="Number of Rooms: "+hash2.get("number of rooms");
            String contact2="Contact: "+hash2.get("contact");

            String im3=hash3.get("image");
            String price3="Price: "+hash3.get("price");
            String address3="Address: "+hash3.get("address");
            String numOfrooms3="Number of Rooms: "+hash3.get("number of rooms");
            String contact3="Contact: "+hash3.get("contact");


            final ImageView imageView1= (ImageView) findViewById(R.id.image1);
            int resID = getResources().getIdentifier(im1, "drawable", getPackageName());
            imageView1.setImageResource(resID);

            final ImageView imageView2= (ImageView) findViewById(R.id.image2);
            resID = getResources().getIdentifier(im2, "drawable", getPackageName());
            imageView2.setImageResource(resID);

            final ImageView imageView3= (ImageView) findViewById(R.id.image3);
            resID = getResources().getIdentifier(im3, "drawable", getPackageName());
            imageView3.setImageResource(resID);


            final TextView textView1=(TextView) findViewById(R.id.price1);
            textView1.setText(price1);
            final TextView textView2=(TextView) findViewById(R.id.price2);
            textView2.setText(price2);
            final TextView textView3=(TextView) findViewById(R.id.price3);
            textView3.setText(price3);

            final TextView addressView1=(TextView) findViewById(R.id.address1);
            addressView1.setText(address1);
            final TextView addressView2=(TextView) findViewById(R.id.address2);
            addressView2.setText(address2);
            final TextView addressView3=(TextView) findViewById(R.id.address3);
            addressView3.setText(address3);

            final TextView roomView1=(TextView) findViewById(R.id.rooms1);
            roomView1.setText(numOfrooms1);
            final TextView roomView2=(TextView) findViewById(R.id.rooms2);
            roomView2.setText(numOfrooms2);
            final TextView roomView3=(TextView) findViewById(R.id.rooms3);
            roomView3.setText(numOfrooms3);

            final TextView contactView1=(TextView) findViewById(R.id.contact1);
            contactView1.setText(contact1);
            final TextView contactView2=(TextView) findViewById(R.id.contact2);
            contactView2.setText(contact2);
            final TextView contactView3=(TextView) findViewById(R.id.contact3);
            contactView3.setText(contact3);



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("app_for_sell.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

package com.example.rentbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Button button=(Button) findViewById(R.id.button);
        final EditText name=(EditText)findViewById(R.id.name);
        final EditText mail=(EditText)findViewById(R.id.mail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Please enter a valid name!",Toast.LENGTH_LONG).show();
                }
                else if(mail.getText().length()==0) {
                    Toast.makeText(getApplicationContext(),"Please enter a valid mail",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent myIntent = new Intent(userInfo.this, showMessage.class);
                    userInfo.this.startActivity(myIntent);
                }

            }
        });
    }
}

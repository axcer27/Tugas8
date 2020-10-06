package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Internal;
    private Button External;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Internal = findViewById(R.id.internalstorage);
        Internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                startActivity(new Intent(MainActivity.this, Intern.class));
            }
        });

        External = findViewById(R.id.externalstorage);
        External.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ekstern.class));
            }
        });
    }
}
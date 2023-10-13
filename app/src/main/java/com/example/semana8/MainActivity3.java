package com.example.semana8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void sensor(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void asynctask (View view){
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}
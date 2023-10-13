package com.example.semana8;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
SensorManager sensorManager;
Sensor sensor;

SensorEventListener sensorEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        //sensor de proximidad
        sensor= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if(sensor==null)
            finish();
        sensorEventListener=new SensorEventListener() {
            @Override
            //al detectar un objeto o que pueda cambiar de color la pantalla a un color diferente como rojo a verde
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);

                }else{
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }
    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }
    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    }
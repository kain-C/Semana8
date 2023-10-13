package com.example.semana8;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity2 extends Activity {
    public String URL="";
    EditText editText;
    ImageView image;
    Button button;
    ProgressDialog mProgressDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=(EditText)findViewById(R.id.ediTxt);
        image = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            //identificador
            public void onClick(View view) {
                URL=editText.getText().toString();
                new DescargarImagen().execute(URL);
            }
        });
    }
    // descarga de la imagen AsyncTask a traves de un subproceso
    // opciones recomendadas Asynctask y bimap
    private class DescargarImagen extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //creacion de barra de progreso de la descarga de la imagen
            mProgressDialog = new ProgressDialog(MainActivity2.this);
            //citulo del estado de la cargar para el cuadro de dialogo
            mProgressDialog.setTitle("Descargando imagen usando AsyncTask en subproceso");
            //mensaje para el usuario en el dialogo de progreso
            mProgressDialog.setMessage("Descargando...espere porfavor...");
            mProgressDialog.setIndeterminate(false);
            //visible el cuadro de progreso de la descarga
            mProgressDialog.show();
        }
        @Override
        protected Bitmap doInBackground(String... URL) {
            String imageURL = URL[0];
            Bitmap bitmap = null;
            try {
// descargar de la imagen alojada en la variable URL
                InputStream input = new java.net.URL(imageURL).openStream();
// metodo de decodificacion segun la fuente de datos de imagen, para la asignacion de memoria para el mapa de bits
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
            mProgressDialog.dismiss();
        }
    }
    /*public void onClick(View v) {
        new Thread(new Runnable() {
            public void run() {

                final Bitmap bitmap =
                        processBitMap(this, url "image.png");
                imageView.post(new Runnable() {
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }*/
}
package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCancion extends AppCompatActivity {
    TextView titulo;
    TextView cantante;
    TextView duracion;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cancion);
        defineComponents();
        setValuesOfIntents();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
    private void defineComponents () {
        titulo = (TextView) findViewById(R.id.titulo);
        cantante = (TextView) findViewById(R.id.cantante);
        duracion = (TextView) findViewById(R.id.duracion);
        imagen = (ImageView) findViewById(R.id.img_cancion);
    }

    private void setValuesOfIntents () {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        titulo.setText(bundle.getString("titulo"));
        cantante.setText(bundle.getString("cantante"));
        duracion.setText(bundle.getString("duracion"));
        imagen.setImageResource(bundle.getInt("img"));
    }
}
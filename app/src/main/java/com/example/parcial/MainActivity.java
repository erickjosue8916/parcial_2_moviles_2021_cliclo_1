package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listadoCaciones;
    ArrayList<Canciones> data;
    CustomAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeList();
        intializeListView();
    }

    private void initializeList() {
        data = new ArrayList<Canciones>();
        data.add(new Canciones("Bellacoso", "Bad Bunny", 3.5, R.drawable.cancion));
        data.add(new Canciones("Atrevete", "Residente", 3.5, R.drawable.img2));
        data.add(new Canciones("Numb", "Linking Park", 3.5, R.drawable.img3));
        data.add(new Canciones("Stand by me", "Oasis", 3.5, R.drawable.img4));
        data.add(new Canciones("Californication", "Red Hot Chili Papers", 3.5, R.drawable.img5));
        data.add(new Canciones("Mi primer millon", "Bacilos", 3.5, R.drawable.img6));
    }

    private void intializeListView () {
        listadoCaciones = (ListView) findViewById(R.id.list_item);
        listAdapter = new CustomAdapter(this, data);
        listadoCaciones.setAdapter(listAdapter);
        listadoCaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Canciones cancion = data.get(index);
                Intent intent = new Intent(getApplicationContext(), DetalleCancion.class);
                intent.putExtra("img", cancion.portadaImg);
                intent.putExtra("titulo", cancion.tituloCancion);
                intent.putExtra("cantante", cancion.cantante);
                intent.putExtra("duracion", String.valueOf(cancion.duracion));
                startActivity(intent);
            }
        });
    }
}
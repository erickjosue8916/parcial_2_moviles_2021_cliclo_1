package com.example.parcial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Canciones> data;

    public CustomAdapter(Context context, ArrayList<Canciones> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int index) {
        return data.get(index);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        final Canciones cancion = (Canciones) data.get(index);
        view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        ImageView img = (ImageView) view.findViewById(R.id.img_cancion);
        TextView titulo = (TextView) view.findViewById(R.id.titulo_cancion);

        img.setImageResource(cancion.portadaImg);
        titulo.setText(cancion.tituloCancion);

        return view;
    }
}

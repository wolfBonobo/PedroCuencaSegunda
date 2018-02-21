package com.example.pedro.pedrocuencasegunda;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pedro on 20/02/2018.
 */

public class Adaptador extends BaseAdapter {

    private Context contexto; //contexto de la aplicacion
    private ArrayList<Pais> list;

    public Adaptador(Context contexto, ArrayList<Pais> list) {
        this.contexto = contexto;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Pais getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }




    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.layout_adaptatador, null);



        TextView nombreIn=vista.findViewById(R.id.tvPaisIn);
        TextView nombreEs=vista.findViewById(R.id.tvPaisEs);
        TextView clave2=vista.findViewById(R.id.tvClave);
        TextView capital=vista.findViewById(R.id.tvCapital);
        TextView continente=vista.findViewById(R.id.tvContinente);
        TextView poblacion=vista.findViewById(R.id.tvPoblacion);
        TextView latitud=vista.findViewById(R.id.tvLatitud);
        TextView longitud=vista.findViewById(R.id.tvLogitud);
        TextView paisesFronterizos=vista.findViewById(R.id.tvPaisesFronterizos);

        nombreIn.setText(list.get(i).getNombreIn());
         nombreEs.setText(list.get(i).getNombreEs());
        clave2.setText(list.get(i).getClave2());
         capital.setText(list.get(i).getCapital());
        continente.setText(list.get(i).getContinente());
        poblacion.setText(list.get(i).getPoblacion());
        latitud.setText(list.get(i).getLatitud());
        longitud.setText(list.get(i).getLongitud());
         paisesFronterizos.setText(list.get(i).getPaisesFronterizos());



        return vista;
    }
}

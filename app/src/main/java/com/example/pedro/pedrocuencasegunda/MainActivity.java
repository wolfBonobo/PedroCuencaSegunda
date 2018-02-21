package com.example.pedro.pedrocuencasegunda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //VARIABLES NECESARIAS
    private static final String URL="http://restcountries.eu/rest/v2/all";
    //private static final String URL="http://192.168.31.44/Paises/paises.json";
    ArrayList<Pais> datos;
    ListView ListViewDatos;
    Adaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        datos=new ArrayList();
        ListViewDatos =findViewById(R.id.lvLista);

        RequestQueue request = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {


            @Override
            public void onResponse(JSONArray response) {

                try {

                    //RECUPERO TODO EL ARCHVIO JSON
                    JSONArray jsonArrayPrincipal=new JSONArray(response.toString(0));
                    System.out.println("----------------------------------------------------------------------");
                   // System.out.println( jsonArrayPrincipal.toString());

                    for(int i=0;i<jsonArrayPrincipal.length();i++){

                       JSONObject unidad= jsonArrayPrincipal.getJSONObject(i);
                       Pais p=new Pais();

                       //SENCILLOS
                        System.out.println(unidad.get("name")); //PAIS INGLES
                        p.setNombreIn(unidad.get("name").toString());

                        System.out.println(unidad.get("capital"));//CAPITAL
                        p.setCapital(unidad.get("capital").toString());

                        System.out.println(unidad.get("region"));//CONTINENTE
                        p.setContinente(unidad.get("region").toString());

                        System.out.println(unidad.get("population"));//POBLACION
                        p.setPoblacion(unidad.get("population").toString());

                        System.out.println(unidad.get("alpha2Code"));//Clave2
                        p.setClave2(unidad.get("alpha2Code").toString());

                        System.out.println(unidad.get("alpha3Code"));//Clave3
                        p.setClave3(unidad.get("alpha3Code").toString());

                        //COMPUESTOS
                        JSONObject paisesTraducidos=unidad.getJSONObject("translations");
                        System.out.println(paisesTraducidos.get("es"));//PAIS ESPAÑOL
                        p.setNombreEs(paisesTraducidos.get("es").toString());

                        //CON ARRAYS
                        //Fronteras
                        JSONArray foronterizos=unidad.getJSONArray("borders");

                        String frontConcat="";
                        for(int j=0;j<foronterizos.length();j++){
                            frontConcat+=foronterizos.getString(j)+" ";

                        }

                        System.out.println(frontConcat); //PAISES FRONTERIZOS CONCATENADOS
                        p.setPaisesFronterizos(frontConcat);

                        //Latitud Longitud
                        JSONArray latlng=unidad.getJSONArray("latlng");
                        if(latlng.length()==2) {
                            String latitud = latlng.getString(0);
                             String longitud=latlng.getString(1);
                            System.out.println(latitud);//Latitud
                            System.out.println(longitud);//Longitud
                            p.setLatitud(latitud);
                            p.setLongitud(longitud);

                        }else{
                            System.out.println("longitud latitud 000000");
                            p.setLatitud("0");
                            p.setLongitud("0");

                        }

                        System.out.println("----------------------------------------------------------------------");

                        //Meto en arrayList
                        datos.add(p);

                    }

                    //GESTION ADAPTADOR LISTVIEW
                    miAdaptador=new Adaptador(getApplicationContext(),datos);
                    ListViewDatos.setAdapter(miAdaptador);

                    //METODO
                    ListViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            //
                            Pais dato = (Pais) adapterView.getItemAtPosition(i);

                            //MANDO EL OBJETO SELECCIONADO EN EL LISTVIEW A MI NUEVO ACTIVITY DETALLE
                            Intent e = new Intent(getApplicationContext(), Map.class);
                            e.putExtra("objeto", (Serializable) dato);
                            startActivity(e);

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("ERROR    -----------------------------------------");

            }

        });

        request.add(jsonArrayRequest);


    }
}

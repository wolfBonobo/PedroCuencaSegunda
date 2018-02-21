package com.example.pedro.pedrocuencasegunda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mapa;
    SupportMapFragment fragmentMapa;
    Pais pais;
    double latitud;
    double longitud;
    LatLng posicion;
    MarkerOptions marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        fragmentMapa= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragMapa);
        fragmentMapa.getMapAsync(this);

        pais = (Pais) getIntent().getExtras().getSerializable("objeto");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa=googleMap;
        mapa.setMapType(googleMap.MAP_TYPE_NORMAL); //Establecemos tipo de mapa. Podemos poner tb MAP_TYPE_SATELLITE, o MAP_TYPE_HYBRID  o MAP_TYPE_NORMAL
        mapa.getUiSettings().setZoomControlsEnabled(true); //Para botones de zoom el el mapa


        latitud=Double.parseDouble(pais.getLatitud());
        longitud=Double.parseDouble(pais.getLongitud());


        posicion=new LatLng(latitud, longitud);
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, 2));

        String info="Capital: "+pais.getCapital()+" Poblacion: "+pais.getPoblacion();

        marcador=new MarkerOptions().title(pais.getNombreEs()).position(posicion).snippet(info);

        mapa.addMarker(marcador);






    }
}

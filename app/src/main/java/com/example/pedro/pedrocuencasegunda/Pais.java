package com.example.pedro.pedrocuencasegunda;

import java.io.Serializable;

/**
 * Created by Pedro on 21/02/2018.
 */

public class Pais implements Serializable {

    String nombreIn;
    String nombreEs;
    String clave2;
    String clave3;
    String capital;
    String continente;
    String poblacion;
    String latitud;
    String longitud;
    String paisesFronterizos;


    public Pais(){};


    public Pais(String nombreIn, String nombreEs, String clave2, String clave3, String capital, String continente, String poblacion, String latitud, String longitud, String paisesFronterizos) {
        this.nombreIn = nombreIn;
        this.nombreEs = nombreEs;
        this.clave2 = clave2;
        this.clave3 = clave3;
        this.capital = capital;
        this.continente = continente;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getNombreIn() {
        return nombreIn;
    }

    public void setNombreIn(String nombreIn) {
        this.nombreIn = nombreIn;
    }

    public String getNombreEs() {
        return nombreEs;
    }

    public void setNombreEs(String nombreEs) {
        this.nombreEs = nombreEs;
    }

    public String getClave2() {
        return clave2;
    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getClave3() {
        return clave3;
    }

    public void setClave3(String clave3) {
        this.clave3 = clave3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPaisesFronterizos() {
        return paisesFronterizos;
    }

    public void setPaisesFronterizos(String paisesFronterizos) {
        this.paisesFronterizos = paisesFronterizos;
    }
}

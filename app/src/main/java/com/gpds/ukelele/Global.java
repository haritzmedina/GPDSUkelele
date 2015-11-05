package com.gpds.ukelele;

import android.app.Application;

/**
 * Created by Ladis on 04/11/2015.
 */
public class Global extends Application {
    //Definición de variables globales
    private String Usuglobal;


    public String getUsu() {
        return Usuglobal;
    }

    public void setUsu(String nombreusu) {
        this.Usuglobal = nombreusu;
    }
}

package com.gpds.ukelele;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.gpds.ukelele.db.DBManager;
import com.gpds.ukelele.db.Trace;

import java.util.Vector;

public class ResumeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        insertData();
    }



    public void insertData() {

        //Insertar la información de la que disponemos en la actividad resumte
        TextView usernameText = (TextView) findViewById(R.id.userField);
        usernameText.setText(((Global) this.getApplication()).getUsu());

        //Declaración de fields a rellenar, mediante su ID
        TextView chordsActivityText = (TextView) findViewById(R.id.chordsField);
        TextView songsActivityText = (TextView) findViewById(R.id.songsField);
        TextView learnSongsActivityText = (TextView) findViewById(R.id.learnSongsField);

        //Coger los datos que iremos a introducir
        String username = ((Global) this.getApplication()).getUsu();
        Toast.makeText(this.getApplicationContext(), username, Toast.LENGTH_SHORT).show();


        Vector<String> menus = new Vector<String>();
        menus.add("menuChords");
        menus.add("SongsActivity");
        menus.add("LearnSongActivity");

        //Recogida de datos de bd
        // Create the database manager
        DBManager dbManager = new DBManager(this.getApplicationContext());

        String tiempoString;


        for(int i=0;i<menus.size();i++) {



            int tiempoTotalmenu = 0;
            //Recogemos por cada menu, sus datos
            Trace traz = new Trace(username, menus.elementAt(i), 0);
           // Log.w("Bucle 3 user","el user del bucle 3 es "+username);

            Vector<Trace> vectorMenu = dbManager.retrieveTrace(traz);

            //Aquí realizamos la suma de todos los tiempos en el menú
            for (int x = 0; x < vectorMenu.size(); x++) {





                tiempoTotalmenu = tiempoTotalmenu + vectorMenu.elementAt(x).getMenutime();

            if (menus.elementAt(i).equals("menuChords")) {
                //Escribimos en la etiqueta correspondiente
                tiempoString = Integer.toString(tiempoTotalmenu);
                chordsActivityText.setText(tiempoString);
            }
            if (menus.elementAt(i).equals("SongsActivity")) {
                //Escribimos en la etiqueta correspondiente
                tiempoString = Integer.toString(tiempoTotalmenu);
                songsActivityText.setText(tiempoString);
            }
            if (menus.elementAt(i).equals("LearnSongActivity")) {
                //Escribimos en la etiqueta correspondiente
                tiempoString = Integer.toString(tiempoTotalmenu);
                learnSongsActivityText.setText(tiempoString);
                }
            }
        }

    }


    }


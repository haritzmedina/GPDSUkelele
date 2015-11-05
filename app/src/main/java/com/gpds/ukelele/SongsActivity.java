package com.gpds.ukelele;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.gpds.ukelele.db.DBManager;
import com.gpds.ukelele.db.Trace;

public class SongsActivity extends Activity {



    //Variables para tracking
    int tiempoinicial;
    int tiempofinal;
    String nombreMenu;
    String nombreUsuario = ((Global) this.getApplication()).getUsu();

	int index;
	ListView l1;
	
	SongInfo mySong;
	
    String[] songs = {
            "HALLELUJAH",
            "I SHOT THE SHERIFF",
            "I AM YOURS",
            "LET IT BE",
            "SOMEWHERE OVER THE RAINBOW",
            "SWEET HOME ALABAMA",
                     };
    
    String[] songsMp3 = {
            "HALLELUJAH-MP3",
            "I SHOT THE SHERIFF",
            "I AM YOURS",
            "LET IT BE",
            "SOMEWHERE OVER THE RAINBOW",
            "SWEET HOME ALABAMA",
                     };
    
    String[] songsYoutube = {
            "http://www.youtube.com/watch?v=XzOdXhywIbo",
            "http://www.youtube.com/watch?v=IzTgYrnhYhs",
            "http://www.youtube.com/watch?v=1VyPSzbe_x0",
            "http://www.youtube.com/watch?v=LoVvrLPX4eQ",
            "http://www.youtube.com/watch?v=1PiscVZSuEE",
            "http://www.youtube.com/watch?v=LDCzpvvSvjY",
                     };
    
    Intent i = new Intent("com.gpds.ukelele.LearnSongActivity");
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_songs);
		
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, songs);

        //---List View---
        l1 = (ListView) findViewById(R.id.ListView1);
        l1.setAdapter(adapter);
        l1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                index = arg2;
                
                Toast.makeText(getBaseContext(),
                        "You have selected song : " + songs[index], 
                        Toast.LENGTH_SHORT).show();
                
                mySong = new SongInfo();
                
                mySong.setIndex(index);
                mySong.setName(songs[index]);
                mySong.setMp3(songsMp3[index]);
                mySong.setYoutube(songsYoutube[index]);
                
                i.putExtra("MySong", mySong);
        	    
        		startActivity(i);
        		         
            }
        } );
	
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.songs, menu);
		return true;
	}


    protected void onPause() {
        super.onPause();
        //Trace registerTrace = new Trace(((Global) this.getApplication()).getUsu(), "LearnSong", 1313, 1);
        tiempofinal= (int)System.currentTimeMillis()-tiempoinicial;
        tiempofinal=tiempofinal/1000;
        String fin=Integer.toString(tiempofinal);
        String nombreMenu="SongsActivity";


        // Create trace
        Trace TrackAinsertar = new Trace(nombreUsuario, nombreMenu, tiempofinal);

        // Create the database manager
        DBManager dbManager = new DBManager(this.getApplicationContext());

        // Introduce in DB the trace
        dbManager.createTrace(TrackAinsertar);


        //Toast.makeText(this.getApplicationContext(),"Se han invertido "+ fin +" segundos ",Toast.LENGTH_LONG).show();
        //Toast.makeText(this.getApplicationContext(), ((Global) this.getApplication()).getUsu(), Toast.LENGTH_SHORT).show();

    }


    protected void onDestroy() {
        super.onDestroy();
        tiempofinal= (int)System.currentTimeMillis()-tiempoinicial;
        tiempofinal=tiempofinal/1000;
        //String fin=Integer.toString(tiempofinal);
        String nombreMenu=this.getClass().getName();
    }

}

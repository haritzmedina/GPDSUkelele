package com.gpds.ukelele;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

import com.gpds.ukelele.db.DBManager;
import com.gpds.ukelele.db.Trace;

public class ChordsActivity extends Activity {


	int tiempoinicial;
	int tiempofinal;
	String nombreMenu;
	String nombreUsuario = ((Global) this.getApplication()).getUsu();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chords);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chords, menu);
		return true;
	}

	protected void onPause() {
		super.onPause();
		//Trace registerTrace = new Trace(((Global) this.getApplication()).getUsu(), "LearnSong", 1313, 1);
		tiempofinal= (int)System.currentTimeMillis()-tiempoinicial;
		tiempofinal=tiempofinal/1000;
		String fin=Integer.toString(tiempofinal);
		String nombreMenu="ChordsActivity";


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

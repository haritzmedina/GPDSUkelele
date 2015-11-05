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
	String nombreMenu="ChordsActivity";
//	String nombreUsuario = ((Global) this.getApplication()).getUsu();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chords);
		tiempoinicial= ((int) System.currentTimeMillis());
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chords, menu);
		return true;
	}


	protected void onPause() {
		super.onPause();

		tiempofinal= (int)System.currentTimeMillis()-tiempoinicial;
		tiempofinal=tiempofinal/1000;
		String fin=Integer.toString(tiempofinal);
		String nombreUsuario = ((Global) this.getApplication()).getUsu();


		// Create trace
		Trace TrackAinsertar = new Trace(nombreUsuario, nombreMenu, tiempofinal);

		// Create the database manager
		DBManager dbManager = new DBManager(this.getApplicationContext());

		// Introduce in DB the trace
		dbManager.createTrace(TrackAinsertar);


	}


	protected void onDestroy() {
		super.onDestroy();
		tiempofinal= (int)System.currentTimeMillis()-tiempoinicial;
		tiempofinal=tiempofinal/1000;
		String fin=Integer.toString(tiempofinal);
		String nombreUsuario = ((Global) this.getApplication()).getUsu();


		// Create trace
		Trace TrackAinsertar = new Trace(nombreUsuario, nombreMenu, tiempofinal);

		// Create the database manager
		DBManager dbManager = new DBManager(this.getApplicationContext());

		// Introduce in DB the trace
		dbManager.createTrace(TrackAinsertar);

	}



}

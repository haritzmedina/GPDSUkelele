package com.gpds.ukelele;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.gpds.ukelele.db.DBManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		String nombreUsuario = ((Global) this.getApplication()).getUsu();
		Toast.makeText(this.getApplicationContext(), nombreUsuario, Toast.LENGTH_SHORT).show();
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	public void openChords(View v) {
		Intent i = new Intent("com.gpds.ukelele.ChordsActivity");
		startActivity(i);
		DBManager dbManager = new DBManager(this.getApplicationContext());
		//we are going to insert here the data for this button
	}
	
	public void openWikipedia(View v) {
		String url = "http://en.wikipedia.org/wiki/Ukulele";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		DBManager dbManager = new DBManager(this.getApplicationContext());
	}
	
	public void openLearn(View v) {
		Intent i = new Intent("com.gpds.ukelele.SongsActivity");
		startActivity(i);
		DBManager dbManager = new DBManager(this.getApplicationContext());
		//we are going to insert here the data for this button
	}

	public void openResume(View v) {
		Intent i = new Intent("com.gpds.ukelele.ResumeActivity");
		startActivity(i);
	}
}
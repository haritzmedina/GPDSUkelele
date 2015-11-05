package com.gpds.ukelele;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class WikiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wiki);
	}

	protected void onPause() {
		super.onPause();
		//Trace registerTrace = new Trace(((Global) this.getApplication()).getUsu(), "Songs", 1313, 1);
		Toast.makeText(this.getApplicationContext(), ((Global) this.getApplication()).getUsu(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wiki, menu);
		return true;
	}

}

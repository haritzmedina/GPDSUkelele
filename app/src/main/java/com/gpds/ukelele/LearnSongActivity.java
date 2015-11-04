package com.gpds.ukelele;



import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class LearnSongActivity extends Activity {

	String songName;
	String songMP3;
	String songYOUTUBE;
	int indexSong;
	boolean songPlaying=false;

	ImageView image;

	MediaPlayer playSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_learn_song);

		SongInfo obj = (SongInfo) getIntent().getSerializableExtra("MySong");

		indexSong= obj.getIndex();
		songName= obj.getName();
		songMP3= obj.getMp3();
		songYOUTUBE= obj.getYoutube();

		final EditText TxtFirst = (EditText)findViewById(R.id.TxtFirst);
		TxtFirst.setText(songName);

		image = (ImageView) findViewById(R.id.imageView100);

		switch (indexSong) {
			case 0:  image.setImageResource(R.drawable.hallelujah); break;
			case 1:  image.setImageResource(R.drawable.i_shot_the_sheriff); break;
			case 2:  image.setImageResource(R.drawable.i_am_yours); break;
			case 3:  image.setImageResource(R.drawable.let_it_be); break;
			case 4:  image.setImageResource(R.drawable.somewhere); break;
			case 5:  image.setImageResource(R.drawable.sweethomes); break;
		}


	}

	public void openMP3(View v) {

        // Retrieve play/pause button
        Button playPauseButton = (Button) findViewById(R.id.playPauseButton);

        // If song is not playing, start the song, else, stop
		if(!songPlaying){
			switch (indexSong) {
				case 0:  playSong = MediaPlayer.create(this,
						R.raw.hallelujah_txiki); break;
				case 1:  playSong = MediaPlayer.create(this,
						R.raw.i_shot_the_sheriff_txiki); break;
				case 2:  playSong = MediaPlayer.create(this,
						R.raw.i_am_yours_txiki); break;
				case 3:  playSong = MediaPlayer.create(this,
						R.raw.let_it_be_txiki); break;
				case 4:  playSong = MediaPlayer.create(this,
						R.raw.somewhere_txiki); break;
				case 5:  playSong = MediaPlayer.create(this,
						R.raw.sweet_home_txiki); break;
			}
			playSong.start();
			songPlaying=true;
            // Change prompted button text
            playPauseButton.setText(R.string.button_stop);
		}
		else{
			playSong.stop();
            songPlaying=false;
            playPauseButton.setText(R.string.button_start);
		}

	}

	public void openYOUTUBE(View v) {

		String url = songYOUTUBE;

		if (!songPlaying){
			songPlaying=false;
			playSong.stop();
		}

		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.learn_song, menu);
		return true;
	}

}

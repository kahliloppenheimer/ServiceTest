package edu.brandeis.cs.servicetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private static Intent musicIntent;
	private static boolean musicIsPlaying;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		musicIsPlaying = false;
		musicIntent = new Intent(this, MusicService.class);
		
		ImageView image = (ImageView) findViewById(R.id.image);
		image.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				toggleMusic();
			}
		});
	}

	private void toggleMusic() {
		if(musicIsPlaying) {
			//Toast.makeText(this, "Service is already running", Toast.LENGTH_SHORT).show();
			stopService(musicIntent);
			musicIsPlaying = false;
		} else {
			//Toast.makeText(this, "Service is not yet running", Toast.LENGTH_SHORT).show();
			startService(musicIntent);
			musicIsPlaying = true;
		}
	}
}

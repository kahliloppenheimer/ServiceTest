/**
 * 
 */
package edu.brandeis.cs.servicetest;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;

/**
 * @author Kahlil
 *
 */
public class MusicService extends Service {
	
	private static Context context;
	private static AsyncMusic asyncMusic;
	private static MediaPlayer mediaPlayer;
	
	/* (non-Javadoc)
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		context = getApplicationContext();
		asyncMusic = new AsyncMusic();
		mediaPlayer = null;
		//Toast.makeText(this, "My Service Created", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onStart(Intent intent, int startID) {
		asyncMusic.execute();
		//Toast.makeText(this, "My Service Started", Toast.LENGTH_SHORT).show();
	}
	
	/*@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		AsyncMusic asyncMusic = new AsyncMusic();
		asyncMusic.execute();
		return START_STICKY;s
	}*/
	
	@Override
	public void onDestroy() {
		//Toast.makeText(this, "My Service Stopped", Toast.LENGTH_SHORT).show();
		mediaPlayer.stop();
		mediaPlayer.reset();
		super.onDestroy();
	}

	private class AsyncMusic extends AsyncTask<Void, Void, Void>
	{
		
	    @Override
	    protected Void doInBackground(Void... params) {
    		mediaPlayer = MediaPlayer.create(context, R.raw.city);
    		mediaPlayer.setLooping(true);
    		mediaPlayer.start();
	    	return null;
	    }

	    @Override
	    protected void onPostExecute(Void result) {
	        super.onPostExecute(result);
	        //mediaPlayer.reset();
	        //Toast.makeText(context, "onPostExecute()", Toast.LENGTH_SHORT).show();	
	    }
	}
}
